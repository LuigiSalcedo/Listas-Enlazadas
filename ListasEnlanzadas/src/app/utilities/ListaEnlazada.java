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
        last = null;
        first.setNext(last);
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
        
        // De lo contrario:
        
        // Verificamos si el elemento es el ultimo.
        if(element == last)
        {
            // De ser así lo agregamos cómo el ultimo.
            addLast(newElement);
            return;
        }
        
        // Verificamos si el elemento es el primero.
        if(element == first)
        {
            addFirst(newElement);
            return;
        }
        
        // Si no es ninguna de las anterior insertamos en le medio.
        
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
    }
    
    /*
     *  Método: "addLast(Enlazable)": Agregará de ultimo al elemento recibido cómo parámetro
     */
    public void addLast(Enlazable newElement)
    {
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
        }
        return sb.toString();
    }
}
