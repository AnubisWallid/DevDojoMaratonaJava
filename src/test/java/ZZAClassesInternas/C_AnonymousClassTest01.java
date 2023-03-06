package ZZAClassesInternas;


class Animal {
    public void walk() {
        System.out.println("Animal walking...");
    }
}
//class Dog extends Animal {
//    @Override
//    public void walk() {
//        System.out.println("Dog walking...");
//    }
//}

public class C_AnonymousClassTest01 {
    public static void main(String[] args) {
        Animal animal = new Animal() {
            @Override
            public void walk() {
                System.out.println("Walking in the Shadows...");
                jump();
            }
            public void jump(){
                System.out.println("Jumping anyway...");
            }
        };
        animal.walk();
//class Dog extends Animal {
//    @Override
//    public void walk() {
//        System.out.println("Dog walking...");
//    }
//}
    }
}

