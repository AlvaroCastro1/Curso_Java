package Animales;
// interfaz funcional

// este es un Predicado
public interface chechkRasgo{
    boolean test(Animal a);
}

/*
java.util.function

una interfaz funcional 
es una interfaz que tiene un único método abstracto
 y se utiliza principalmente en el contexto de la programación funcional 
y el uso de expresiones lambda
 */ 


// existen las siguientes interfaces funcionales


/*
        prdicado test(T t)
            Predicate<T>: Representa una función que recibe un argumento de tipo T
            y devuelve un valor booleano.


        funcion apply(T t)
            Function<T, R>: Representa una función que recibe un argumento de tipo T
            y devuelve un resultado de tipo R. 
            Se utiliza para transformar un objeto de tipo T en otro objeto de tipo R.


        consumidor accept(T t)
            Consumer<T>: Se utiliza para realizar operaciones con un objeto de tipo T
            sin devolver un valor

        provedor get(T t)
            genera elementos


        Supplier<T>: Representa una función que no recibe argumentos
            y devuelve un resultado de tipo T.
            Se utiliza para obtener o generar valores sin argumentos.
 */

