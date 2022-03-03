package classes;

import iteratorinterface.SListIterator;

public class Main {
    public static void main(String[] args) {

        SList<String> sl = new SList<String>();
        System.out.println(sl);


        SListIterator<String> sIterator = sl.iterator();
        sIterator.add("One");
        sIterator.add("Two");
        sIterator.add("Three");

        System.out.println(sIterator.hasNext());
        System.out.println(sl);


        sIterator = sl.iterator();
        sIterator.add("Four");


        for(; sIterator.hasNext();)
            System.out.println(sIterator.next());
        System.out.println(sl);


        sIterator = sl.iterator();
        System.out.println(sIterator.next());

        sIterator.remove();


        System.out.println(sIterator.next());
        System.out.println(sl);
    }
}