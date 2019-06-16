package advanced_class_design.inner_classes;

class A {
    private int x = 10;

    class B{
        private int x = 20;

        class C {
            private int x = 30;

            public void allTheX(){
                System.out.println(x);
                System.out.println(this.x);
                System.out.println(C.this.x);
                System.out.println(B.this.x);
                System.out.println(A.this.x);
            }
        }
    }
}

public class App{
    public static void main(String[] args) {
        A a = new A();
        A.B b = a.new B();
        A.B.C c = b.new C();
        c.allTheX();
    }
}
