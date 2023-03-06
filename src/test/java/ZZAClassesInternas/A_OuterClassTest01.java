package ZZAClassesInternas;

public class A_OuterClassTest01 {
    private String name = "Classe Pai \"Externa\"" ;
    class InnerClass {
        private String name = "Classe Filha \"Interna\"" ;
        public void printOuterClassAttribute(){
            System.out.println("name: " + name);
            System.out.println("this.name: " + this.name);
            System.out.println("A_OuterClassTest01.this.name: " + A_OuterClassTest01.this.name);
        }
    }
    public static void main(String[] args) {
        A_OuterClassTest01 outerClass = new A_OuterClassTest01();
//        A_OuterClassTest01.InnerClass innerClass = outerClass.new InnerClass();
        InnerClass inner = outerClass.new InnerClass();
        InnerClass inner2 = new A_OuterClassTest01().new InnerClass();
        inner.printOuterClassAttribute();
        inner2.printOuterClassAttribute();
    }
}
