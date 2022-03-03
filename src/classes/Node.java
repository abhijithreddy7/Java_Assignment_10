package classes;

public class Node<E> {
    private E info = null;
    private Node<E> next = null;
    public Node() {}
    public Node(E value) {
        info = value;
    }
    public boolean hasNext() {
        return (next != null);
    }
    public Node<E> getNext() {
        return next;
    }
    public void setNext(Node<E> node) {
        next = node;
    }
    public E getInfo() {
        return info;
    }
    public E setInfo(E value) {
        E old = getInfo();
        info = value;
        return old;
    }
}