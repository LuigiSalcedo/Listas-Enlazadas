package app.utilities;

/**
 *
 * @author César Luigi Salcedo Espriella (Luigi Salcedo)
 */
public class Node implements Enlazable
{
    private String name;
    private Node next;
    
    // Constructores
    
    // Constructor nulo
    public Node()
    {
        
    }
    
    // Constructor con nombre
    public Node(String name)
    {
        this.name = name;
    }
    
    // Setters
    public void setName(String name)
    {
        this.name = name;
    }
    
    // Getters
    public String getName()
    {
        return name;
    }
    
    /*
     *  Sobremontura del método "next()" de la interface "Enlazable".
     */
    @Override
    public Enlazable next() 
    {
        return next;
    }

    /*
     *  Sobremontura del método "nextNext(Enlazable)" de la interface "Enlazable".
     */
    @Override
    public void setNext(Enlazable nextElement) 
    {
        next = (Node)nextElement;
    }
    
    /*
     *  Sobremontura del método: "toString()".
     */
    @Override
    public String toString()
    {
        return name;
    }
}
