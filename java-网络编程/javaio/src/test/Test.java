
public class Test implements A1{
    public void fun1() {
        c1.funC();
    }

    public static void main(String[] args) {
        new Test().fun1();
    }
}

interface A1 {
    C1 c1 = new C1();
    public void fun1();
}

class C1{
    public void funC(){
        System.out.println("haha");
    };
}