package app.utilities;

/**
 *
 * @author César Luigi Salcedo Espriella (Luigi Salcedo)
 * @param <T>
 */
public class ListaEnlazada<T> 
{
    // Atributos
    private Enlazable first;
    private Enlazable last;
    protected int len;
    
    // Constructores
    
    // Constructos nulo
    public ListaEnlazada()
    {
        len = 0;
        first = null;
        last = null;
    }
    
    // Constructo con elemento inicial
    public ListaEnlazada(Enlazable firstElement)
    {
        first = firstElement;
        last = firstElement;
        first.setNext(null);
        len = 1;
    }
    
    // Constructor con inicio y final
    public ListaEnlazada(Enlazable firstElement, Enlazable lastElement)
    {
        first = firstElement;
        last = lastElement;
        
        // Definimos el puntero
        first.setNext(lastElement);
        last.setNext(null);
        len = 2;
    }
    
    // MÉTODOS 
    
    /*
     *  Método "T getFirst()": Retonará el primer elemento de la lista.
     */
    public T getFirst()
    {
        return (T)first;
    }
    
    /*
     *  Método "T getLast()": Retonará el ultimo elemento de la lista.
     */
    public T getLast()
    {
        return (T)last;
    }
    
    /*
     *  Método "T get(int)": Retonará el elemento de la i-ésima posición desde el inicio hacia el final.
     */
    public T get(int x)
    {
        // Si el valor recibido es más corto que 0 pero más largo que la lista entonces -> null.
        if(x < 0 || x >= len) return null;
        
        // De lo contrario lo buscamos.
        Enlazable element = first;
        
        // Nos movemos entre los siguiente obteniendo los siguientes.
        for(int i = 0; i < x; i++)
        {
            element = element.next();
        }
        
        return (T)element;
    }
    
    /*
     *  Método: "contains(Enlazable)": Método boolean retornará true si el elemento recibido cómo paramétro hace parte la lista,
     *  de lo contrario retonará false.
     */
    
    public boolean contains(Enlazable element)
    {
        // Elemento que se encargará de recorrer la lista.
        Enlazable s = first;
        
        // Buscamos mientras no hayamos llegado al final.
        while(s != null)
        {
            // Si encontramos el elemento entonces está en la lista.
            if(s == element) return true;
            
            // De lo contrario seguimos buscando.
            s = s.next();
        }
        
        // Si no lo encontramos entonces no está en la lista.
        return false;
    }
    
    /*
     *  Método: "addAfter(Enlazable, Enlazable)":  Agregará un elemento después que otro dentro de la lista, siempre y cuando este ultimo exista.
     */
    
    public void addAfter(Enlazable newElement, Enlazable element)
    {
        // Si el elemento no hace parte de la lista omitimos el agregar.
        if(!contains(element))
        {
            return;
        }
        
        // Verificamos si el elemento va a ser asignado después del ultimo.
        if(element == last)
        {
            // De ser así agregamos de ultimo.
            addLast(newElement);
            return;
        }
        
        // Hacemos que el nuevo apunte a donde apunta el actual
        newElement.setNext(element.next());
        
        // Hacemos que el actual apunte al nuevo
        element.setNext(newElement);
        
        // Aumentamos el tamaño de la lista
        len++;
    }
    
    /*
     *  Método: "addFirst(Enlazable)": Agregará de primero al elemento recibido cómo parámetro.
     */
    public void addFirst(Enlazable newElement)
    {
        // Hacemos que el nuevo elemento apunte al primero.
        newElement.setNext(first);
        
        // Reemplazamos el primero.
        first = newElement;
        
        // Aumentamos el tamaño de la lista.
        len++;
        
        // Verificamos si hay sólo dos elementos.
        if(len == 2)
        {
            // Hacemos que el siguiente del agregado sea el ultimo.
            last = newElement.next();
            return;
        }
        
        // Verificamos si el primero agregadon
        if(len == 1)
        {
            // Hacemos que el primer elemento sea el ultimo también.
            last = first;
            first.setNext(null);
        }
    }
    
    /*
     *  Método: "addLast(Enlazable)": Agregará de ultimo al elemento recibido cómo parámetro
     */
    public void addLast(Enlazable newElement)
    {
        // Verificamos si es el primer elemento agregado
        if(len == 0)
        {
            // De ser así lo agreamos cómo el primero
            addFirst(newElement);
            return;
        }
        
        // Hacemos que el ultimo actual apunte a este.
        last.setNext(newElement);
        
        // Hacemos que el nuevo apunte a null
        newElement.setNext(null);
        
        // Convertimos el nuevo en el ultimo
        last = newElement;
        
        len++; // Aumentamos el tamaño de la lista
    }
    
    /*
     * Método: "remove(Enlazable)": Eliminará al elemento el elemento recibido de la lista.
     */
    public void remove(Enlazable element)
    {
        // Si la lista no contiene al elemento no eliminamos nada puesto que puede ocurrir un "NullPointerException".
        if(!contains(element)) return;
        
        // Verificamos si queremos eliminar al primero.
        if(element == first)
        {
            removeFirst();
            return;
        }
        
        // Verificamos si queremos eliminar al ultimo.
        if(element == last)
        {
            removeLast();
            return;
        }
        
        Enlazable antecesor = first; // El elemento que contendrá al antencesor
        
        // Buscamos cual es el antecesor
        while(antecesor.next() != element)
        {
            // Nos movemos usando los siguiente
            antecesor = antecesor.next();
        }
        
        // Una vez encontrado re-organizamos los punteros.
        antecesor.setNext(element.next());
        element.setNext(null);
        
        // Disminuimos la lista
        len--;
    }
    
    /*
     *  Método "removeFirst()": Remueve el primer elemento de la lista.
     */
    public void removeFirst()
    {
        // Verificamos que la lista no esté vacia
        if(len == 0) return;
        
        first = first.next();
        len--;
    }
    
    /*
     *  Método "removeLast()": Remueve el primer ultimo elemento de la lista.
     */
    public void removeLast()
    {
        // Verificamos que la lista no esté vacia
        if(len == 0) return;
        
        Enlazable buscador = first; // Buscamos cual elemento apunta a nulo.
        while(buscador.next() != last)
        {
            // Nos movemos entre los elementos de la lista
            buscador = buscador.next();
        }
        
        // Una vez encontrado lo hacemos el ultimo
        last = buscador;
        last.setNext(null);
        len--;
    }
    
    /*
     *  Método: "getPosition(Enlazable)": Obtendrá la posición de un elemento.
     */
    public int getPosition(Enlazable element)
    {
        int i = 0; // Posición en la que estamos
        Enlazable buscador = first; // Elemento que usaremos para movernos
        
        // Nos moveremos mientras no desbordemos la lista.
        while(buscador != null)
        {
            // Verificamos si lo encontramos
            if(buscador == element)
            {
                return i;
            }
            
            // Si no aumentamos la posición de busqueda
            i++;
            
            // Nos movemosa atravez de la lista.
            buscador = buscador.next();
        }
        
        // Si buscador es null entonces el elemento no está en la lista.
        return -1;
    }
    
    /*
     *  Método "length()": Retorna el número de elemento pertenecientes a la lista.
     */
    public int length()
    {
        return len;
    }
    
    /*
     *  Sobremontura del método "toString()".
     */
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        Enlazable escritor = first;
        
        while(escritor != null)
        {
            sb.append(escritor.toString());
            if(escritor != last)
            {
                sb.append(" -> ");
            }
            escritor = escritor.next();
        }
        return sb.toString();
    }
}
