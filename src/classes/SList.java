

package classes;

import iteratorinterface.SListIterator;

public class SList<E> {
    private Node<E> head = new Node<E>();
    public String toString() { // based on iteratorinterface.SListIterator
        SListIterator<E> ite = iterator();
        StringBuilder result = new StringBuilder("{");
        while (ite.hasNext()) {
            result.append(ite.next().toString());
            if (ite.hasNext()) {
                result.append("->");
            }
        }
        result.append("}");
        return result.toString();
    }
    public SListIterator<E> iterator() {
        return new SListIterator<E>() {
            private Node<E> cursor = head;
            private Node<E> previous = null;
            public boolean hasNext() {
                return cursor.hasNext();
            }
            public E next() {
                if (!hasNext()) {
                    throw new RuntimeException("Doesn't have next element!");
                }
                previous = cursor;
                cursor = cursor.getNext();
                return cursor.getInfo();
            }
            public void add(E ele) {
                Node<E> nextNode = cursor.getNext();
                Node<E> newNode = new Node<E>(ele);
                cursor.setNext(newNode);
                newNode.setNext(nextNode);
                previous = cursor;
                cursor = newNode;
            }
            public void remove() {
                if (cursor == head) {
                    throw new RuntimeException("Cursor is at head!");
                }
                if (cursor == previous) {
                    throw new RuntimeException("can only be made once per call to next!");
                }
                previous.setNext(cursor.getNext());
                cursor.setNext(null);
                cursor = previous;
            }
        };
    }
    public int size() {
        SListIterator<E> ite = iterator();
        int size = 0;
        while (ite.hasNext()) {
            ite.next();
            size++;
        }
        return size;
    }
}