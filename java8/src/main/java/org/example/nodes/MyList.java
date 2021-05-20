package org.example.nodes;

public class MyList<D> {

    private Node<D> head;

    public void offer(D value) {
        if (head == null) {
            head = new Node<D>(value, null);
        } else {
            // Else traverse till the last node
            // and insert the new_node there

            Node<D> current = head;
            while(current.next != null) {
               // pos = current;
                current = current.next;
            }
            current.next = new Node(value, null);
        }
    }

    public D get(int index) {
        if (index == 0 ){
            return head.value;
        }
        int counter = 1;
        Node<D> tmp = head.next;
        while (counter++ < index) {
            if (tmp == null)
                break;
            tmp = tmp.next;
        }
        if (tmp != null)
            return tmp.value;
        return null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    static class Node<T> {
        private Node<T> next;
        private final T value;
        public Node(final T value, final Node<T> next)
        {
            this.value = value;
            this.next = next;
        }
    }
}
