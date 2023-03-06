package ZZAClassesInternas;

public class B_OuterClassTest02 {
    private String name = "Classe Pai";

    void printClasseExterna() {
        final String nametwo = "Dentro do Metodo";
        class ClassDentroMetodo {
            public void printDaClasseInterna() {
                System.out.println(name + " | " + nametwo);
            }
        }
//        new ClassDentroMetodo().printDaClasseInterna();
        ClassDentroMetodo classeMetodo = new ClassDentroMetodo();
        classeMetodo.printDaClasseInterna();
    }


    public static void main(String[] args) {
        B_OuterClassTest02 outerClassTest02 = new B_OuterClassTest02();
        outerClassTest02.printClasseExterna();
    }
}
