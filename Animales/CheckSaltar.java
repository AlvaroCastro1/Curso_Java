package Animales;
/*esta clase  tiene un método test
 que recibe un objeto Animal como argumento 
 y devuelve un valor booleano.
 Este método verifica si el animal puede saltar llamando al método canHop()
*/
public class CheckSaltar implements chechkRasgo{
    public boolean test(Animal a){
        return a.canHop();
    }
}