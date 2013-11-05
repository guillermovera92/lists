package org.macalester.edu.comp124.lists;

/**
 * TODO:
 * 1) Complete the get() method (unit test 1 and 2 should pass).
 * 2) Complete the add(i, E) method (unit tests 1 - 3 should pass).
 * @author Shilad
 *
 * @param <E>
 */
public class MyLinkedList<E> {
    private MyLinkedNode<E> head;
    private MyLinkedNode<E> tail;
    private int numElements = 0;

    public MyLinkedList() {
        head = new MyLinkedNode<E>(null);
        tail = new MyLinkedNode<E>(null);
        clear();
    }

    public E get(int i) {
        E value = null;
        MyLinkedNode<E> currentNode = head;
        for (int j = 0; j <= i; j++){
            currentNode = currentNode.getNext();
        }
        value = currentNode.getValue();
        return value;
    }

    public void add(E s) {
        MyLinkedNode<E> newNext = tail;
        MyLinkedNode<E> newPrev = tail.getPrev();
        MyLinkedNode<E> newNode = new MyLinkedNode<E>(s);
        newNext.setPrev(newNode);
        newNode.setPrev(newPrev);
        newPrev.setNext(newNode);
        newNode.setNext(newNext);
        numElements++;
    }

    public void add(int i, E s) {
        MyLinkedNode<E> currentNode = head;
        MyLinkedNode<E> newNode = new MyLinkedNode<E>(s);
            for (int j = 0; j < i; j++){
                currentNode = currentNode.getNext();
        }
        newNode.setNext(currentNode.getNext());
        newNode.setPrev(currentNode);
        currentNode.setNext(newNode);
        currentNode.getNext().setPrev(newNode);
        numElements++;
    }

    public int size() {
        return numElements;
    }

    public void clear() {
        // set head's next to the tail
        head.setNext(tail);
        head.setPrev(null);

        // set tails prev to the head
        tail.setPrev(head);
        tail.setNext(null);
        numElements = 0;
    }
}
