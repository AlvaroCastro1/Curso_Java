package Animales;
import java.util.*;
import java.util.function.Predicate;

public class ListaAnimales{
    public static void main(String[] args) {

        // se crea una lista de animales
        List<Animal> animals = new ArrayList<Animal>();
        // se añaden algunos animales
        animals.add(new Animal("fish", false, true));
        animals.add(new Animal("Kangaroo",true, false));
        animals.add(new Animal("rabbit", true, false));
        animals.add(new Animal("turtle", false, true));
        animals.add(new Animal("Dog", true, true));




        System.out.println("Animales que saltan: ");
        //print(animals, new CheckSaltar());
        print(animals, a->a.canHop());
        System.out.println("Animales que Nadan: ");
        print(animals, a->a.canSwim());
        System.out.println("Animales que NO pueden saltar");
        print(animals, a->!a.canHop());
        System.out.println("Animales que NO pueden nadar");
        print(animals, a->!a.canSwim());
        System.out.println("Animales que pueden nadar y saltar");
        print(animals, a->a.canSwim() && a.canHop());
        System.out.println("Animales que NO pueden nadar y NI saltar");
        print(animals, a->!a.canSwim() && !a.canHop());
        System.out.println("Animales que SI pueden nadar y NO saltar");
        print(animals, a->a.canSwim() && !a.canHop());
        System.out.println("Animales que NO pueden nadar y SI saltar");
        print(animals, a->!a.canSwim() && a.canHop());
        System.out.println("Animales que pueden nadar O saltar");
        print(animals, a->a.canSwim() || a.canHop());
    }
      //private static void print(List<Animal>animals, chechkRasgo checker){

        // recibe la lista de animales y un objeto Predicate<Animal> que representa una condición de selección de animales.
        private static void print(List<Animal>animals,Predicate <Animal> checker){
            
        for(Animal animal_i: animals){
            if(checker.test(animal_i))
            System.out.println(animal_i+"");
    
        }
        System.out.println();
       
    }    
}
