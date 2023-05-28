import java.util.*;

public class Lambda1{

    public static void main(String[] args){
        lambdaString();
        //lambda2();
        //lambda3();
        //lambda4();
    }//main

    public static void lambdaString(){
        ArrayList<String> arr = new ArrayList<String>();
        // se agregan las siguientes palabras
        arr.add("Hola");
        arr.add("Mundo");
        arr.add("Lambda");
        arr.add("Paradigmas");

        System.out.println("\nArreglo original: \n" +arr);
        //recibe el arreglo y lo pasa a cada elemento en letras mayusculas
        arr.replaceAll( s->s.toUpperCase() );
        //muestra los elementos con las letras mayusculas 
        System.out.println("\nMayusculas: \n" +arr);
    }

    public static void lambda2(){
        // var permite al compilador identificar automáticamente el tipo de dato basándose en la expresión de inicialización.
        var arr2 = new ArrayList<Integer>();
        // y se llena con 40 números enteros generados aleatoriamente entre 0 y 9.
        for( int i=0; i<40; i++)
            arr2.add( (new Random()).nextInt(10) );
        // imprime el arreglo
        System.out.println("\nEnteros: \n" +arr2);
        // despues va a reemplazar a cada elemento por si mismo pero elevado al cuadrado
        arr2.replaceAll( n-> (int)Math.pow(n,2) );
        System.out.println("\nEnteros Cuadrado: \n" +arr2);
    }

    public static void lambda3(){
        ArrayList<String> arr = new ArrayList<String>();
        arr.add("Hola");
        arr.add("Mundo");
        arr.add("Lambda");
        arr.add("Paradigmas");

        System.out.println("\nArreglo original: \n" +arr);
        // quita a todo elemento que se igual a "Mundo"
        arr.removeIf( s->s.equals("Mundo") );
        System.out.println("\nSin mundo: \n" +arr);
        //elimina cualquier elemento del arrylist sí la longitud es menor que 5
        arr.removeIf( s->s.length() < 5 );
        System.out.println("\n: \n" +arr);

    }

    public static void lambda4(){
        ArrayList<String> arr = new ArrayList<String>();
        arr.add("Hola");        arr.add("aguacate");
        arr.add("Mundo");       arr.add("estudiante");
        arr.add("Lambda");
        arr.add("Paradigmas");

        System.out.println("\nArreglo original: \n" +arr);
        // se eliminaran a los elem que cumplan la condicion 
        // la funcion lambda hace que por cada elemento divide en subcadenas tomando en cuenta como separador la letra "a"
        // y SÍ tiene mas de dos letras "a" lo elimina
        arr.removeIf( s -> { String a[] = s.split("a");
                             return (a.length>2);
                         } );
        System.out.println("\nPalabras a: \n" +arr);
    }
}//class
