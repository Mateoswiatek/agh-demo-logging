package pl.agh.demo.logging;

public class Main {
    public static void main(String[] args) {
        System.out.println("Wykonano mnie!");
        Person person = new Person(1L, "Mateusz", 23);
        f(person);
    }

    public static void f(Person person) {
        System.out.println("Main.f - invoked. personId:" + person.id());

        boolean warunek = true;
        if(warunek) {
            System.out.println("Spełniono");
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    try{
                        System.out.println("i: " + i + " j: " + j);
                    } catch (Exception e){
                        System.err.println("Błąd" + e.getMessage());
                    }
                }
            }
        }
    }
}
