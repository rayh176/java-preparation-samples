package org.example.nodes;

public class LinkedListReversed<T> {

    Node<T> head;

    static class Node<G> {

        int data;
        Node next;

        Node(int d)
        {
            data = d;
            next = null;
        }
    }

    public Node<T> reverseLinkedList(Node<T> linkedList){
        if (linkedList == null)
            return null;

        Node<T> secondNode = linkedList.next;

        Node<T> thirdNode = null;

        if (secondNode !=null)
            thirdNode = reverseLinkedList(secondNode);

        // swap elements
        Node<T> tmpNode = thirdNode;
        linkedList = tmpNode;
        linkedList.next = secondNode;
        secondNode.next = thirdNode;
        return linkedList;

    }

    public Node<T> reverseList(Node<T> head){

        Node<T> current = head;
        Node<T> prev = null;
        Node<T> next = null;
        while(current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        return head;
    }

    // prints content of double linked list
    void printList(Node<T> node)
    {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public static void main(String[] args)
    {
        LinkedListReversed<Integer> list = new LinkedListReversed();
        list.head = new Node(85);
        list.head.next = new Node(15);
        list.head.next.next = new Node(4);
        list.head.next.next.next = new Node(20);

        System.out.println("Given Linked list");
        list.printList(list.head);
        list.head = list.reverseList(list.head);
        System.out.println("");
        System.out.println("Reversed linked list ");
        list.printList(list.head);
    }
}
