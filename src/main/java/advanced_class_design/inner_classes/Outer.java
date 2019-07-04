package advanced_class_design.inner_classes;

public class Outer {

    protected class Inner{
        private String greeting = "Hi";

        public void go(){
            for(int i = 0; i < 3; i++){
                System.out.println(greeting);

            }
        }
    }

    public void callInner(){
        Inner inner = new Inner();
        inner.go();
    }


    public static void main(String[] args) {
//        Outer outer = new Outer();
//        outer.callInner();
        Outer outer = new Outer();
        Inner inner = outer.new Inner();
        inner.go();
    }
}
