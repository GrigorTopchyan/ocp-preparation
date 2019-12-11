package concurrency.completablefuture;

import domain.CreditRatingService;
import domain.User;
import domain.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CompletableFutureDemoTest {

    @Test
    public void testCreateEmptyCompletableFuture() throws ExecutionException, InterruptedException {
        String value = "Future Result";
        CompletableFuture<String> completableFuture = new CompletableFuture<>();
        completableFuture.complete(value);
        String result = completableFuture.get();
        assertEquals(result, value);
    }

    @Test
    public void whenRunAsyncThenShouldRunInAnotherThread() throws ExecutionException, InterruptedException {
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            sleep(2000);
            System.out.println("Current Thread:  " + Thread.currentThread().getName());
        });
        System.out.println("Main Thread: " + Thread.currentThread().getName());
        future.join();

    }

    @Test
    public void whenSuplyAsyncShouldRunOnAnotherThreadAndReturnResult() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            sleep(2000);
            System.out.println("Current Thread:  " + Thread.currentThread().getName());
            return "Result of asynchronous computation";
        });
        System.out.println("Main Thread: " + Thread.currentThread().getName());
        assertEquals(future.get(), "Result of asynchronous computation");
    }

    @Test
    public void whenThenApplyThenCalbackFunctionShouldBeCalledWhenResultIsReady() throws ExecutionException, InterruptedException {
        CompletableFuture<String> nameFuture = CompletableFuture.supplyAsync(() -> {
            sleep(1000);
            return "Mike";
        });

        CompletableFuture<String> greetingFuture = nameFuture.thenApply(name -> "Hello " + name);
        assertEquals(greetingFuture.get(), "Hello Mike");
    }

    @Test
    public void testThenApplyChainingMultipleTimes() throws ExecutionException, InterruptedException {
        CompletableFuture<String> nameFuture = CompletableFuture.supplyAsync(() -> {
            sleep(1000);
            return "Mike";
        });

        CompletableFuture<String> greetingFuture = nameFuture.thenApply(name -> "Hello " + name)
                .thenApply(text -> text + ", Welcome to EGS")
                .thenApply(text -> text + ", Nice to meet you");

        assertEquals(greetingFuture.get(), "Hello Mike, Welcome to EGS, Nice to meet you");
    }


    @Test
    public void whenThenComposeThenResultShouldBeFlattened() throws ExecutionException, InterruptedException {
        User user = new User("user1", "Mike", "card1");
        double creditRating = 163;
        UserService userServiceMock = Mockito.mock(UserService.class);
        Mockito.when(userServiceMock.getUserDetails("user1")).thenReturn(user);
        CreditRatingService creditRatingServiceMock = Mockito.mock(CreditRatingService.class);
        Mockito.when(creditRatingServiceMock.getCreditRating(user)).thenReturn(creditRating);

        Function<String, CompletableFuture<User>> getUserDetials = userId -> CompletableFuture.supplyAsync(() -> userServiceMock.getUserDetails(userId));
        Function<User, CompletableFuture<Double>> getCreditRatings = u -> CompletableFuture.supplyAsync(() -> creditRatingServiceMock.getCreditRating(u));

        CompletableFuture<Double> result = getUserDetials
                .apply("user1")
                .thenCompose(getCreditRatings);

        assertEquals((double) result.get(), creditRating);

    }

    @Test
    public void whenThenCombineThenFuturesShouldWorkIndependently() throws ExecutionException, InterruptedException {
        CompletableFuture<Double> weightInKgFuture = CompletableFuture.supplyAsync(() -> {
            sleep(1000);
            return 65.0;
        });

        CompletableFuture<Double> heightInCmFuture = CompletableFuture.supplyAsync(() -> {
            sleep(1000);
            return 177.8;
        });

        CompletableFuture<String> combinedFuture = weightInKgFuture.thenCombine(heightInCmFuture, (weight, height) -> "Weight: " + weight + ", Height: " + height);
        assertEquals(combinedFuture.get(),"Weight: 65.0, Height: 177.8");
    }

    @Test
    public void whenExceptionThrownThenShouldBeHandledProperly() throws InterruptedException, ExecutionException {
        int age = -1;
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            if (age < 0 ){
                throw new IllegalArgumentException("Age cant be negative ");
            }else if (age < 18) {
                return "Child";
            }else {
                return "Adult";
            }
        }).exceptionally(ex -> {throw new RuntimeException(ex);});

        assertThrows(ExecutionException.class,() ->  future.get());
    }




    private void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}