package app;
import app.utilities.ListaEnlazada;
import app.utilities.Node;

/**
 *
 * @author César Luigi Salcedo Espriella (Luigi Salcedo)
 */
public class App 
{
    public static void showInfo(ListaEnlazada myList, String message)
    {
        System.out.println(message);
        
        // Mostramos la lista
        System.out.println(myList);
        
        // Mostramos al primero y al ultimo
        System.out.println("Primero: " + myList.getFirst() + " | Ultimo: " + myList.getLast());

        System.out.println("________________________________\n");
    }
    
    /*
     *  Prueba de funcionamiento
     */
    public static void main(String[] args) 
    {
        ListaEnlazada<Node> myList = new ListaEnlazada(); // Creación de la lista
        
        // Agregamos el primer elemento
        myList.addLast(new Node("1"));
        
        showInfo(myList, "Agregamos un primer elemento con el método addLast");
        
        // Agregamos un elemento cómo primero
        myList.addFirst(new Node("-1"));
        
        showInfo(myList, "Agregamos un elemento con el método addFist");
        
        // Insertamos en el medio
        myList.addAfter(new Node("0"), myList.getFirst());
        
        showInfo(myList, "Insertamos un elemento con el método addAfter");

        // Agregamos después del ultimo.
        myList.addAfter(new Node("2"), myList.getLast());
        
        showInfo(myList, "Agregamos un elemento de ultimo con el método addAfter");
        
        // Eliminamos al primero
        myList.removeFirst();
        
        showInfo(myList, "Eliminamos al primer elemento");
        
        // Eliminamos al ultimo
        myList.removeLast();
        
        showInfo(myList, "Eliminamos al utltimo elemento");
        
        // Obtenemos al primero
        Node n = myList.getFirst();
        
        // Obtenemos al ultimo
        Node f = myList.getLast(); 
        
        // Eliminamos al primero
        myList.removeFirst();
        
        showInfo(myList, "Eliminamos al primer elemento");
        
        System.out.println("La lista contiene a " + n + "?: " + myList.contains(n));
        System.out.println("La lista contiene a " + f + "?: " + myList.contains(f));
    }    
}
