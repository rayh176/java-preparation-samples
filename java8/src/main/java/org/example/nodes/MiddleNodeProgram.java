package org.example.nodes;

/**
 * Find the middleNode
 */
public class MiddleNodeProgram<T> {
    private Node<T> head;

    public void populate(T data) {
        if (head == null)
            head = new Node(data, null);
        else {
            Node<T> tempNode = head;
            Node<T> current = head.next;
            while(current != null) {
                tempNode = current;
                current = current.next;
            }
            tempNode.next = new Node<>(data, null);
        }

    }

    public int findMiddleNode() {
        int counter = 0;
        Node<T> current = head;
        Node<T> middleNode = current;
        while (current.next != null) {
            if (counter++ % 2 == 0) {
                middleNode = current;
            }
            current = current.next;
        }
        int middleCounter = counter / 2;
        return middleCounter;
    }

    private class Node<T> {
        private Node<T> next;
        private T data;

        Node(T data, Node next){
            this.data = data;
            this.next = next;
        }
    }


}
