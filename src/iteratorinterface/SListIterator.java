package iteratorinterface;

public interface SListIterator<E> {
    public boolean hasNext();
    public E next();
    public void add(E ele);
    public void remove();
}