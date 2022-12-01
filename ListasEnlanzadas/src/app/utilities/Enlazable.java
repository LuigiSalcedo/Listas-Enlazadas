package app.utilities;

/**
 *
 * @author César Luigi Salcedo Espriella
 * @param <T>
 */
public interface Enlazable<T>
{
    public Enlazable next(); // Retonará el elemento siguiente de un elemento que pertenezca a una lista enlazada
    public void setNext(Enlazable nextElement); // Definir el siguiente elemento de un elemento que pertenezca a una lista enlazada
}
