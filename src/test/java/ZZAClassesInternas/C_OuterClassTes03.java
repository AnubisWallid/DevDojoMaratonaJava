package ZZAClassesInternas;

public class C_OuterClassTes03 {
    private String name = "Wallid Santana";

    static class Nested {
        void print(){
            System.out.println(
                    new C_OuterClassTes03().name
            );
        }
    }

    public static void main(String[] args) {
        Nested nested = new Nested();
        nested.print();
    }
}
