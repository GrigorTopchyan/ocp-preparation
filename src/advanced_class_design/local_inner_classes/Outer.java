package advanced_class_design.local_inner_classes;

public class Outer {
    private int length = 5;

    public void calculate(){
        int width = 10;
        class Inner{
            public void multiply(){
                System.out.println(length * width);
            }
        }

        Inner inner = new Inner();
        inner.multiply();
    }
}

class App{
    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.calculate();
    }
}
