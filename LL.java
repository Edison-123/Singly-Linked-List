/**
 * A simple implementation of a Singly Linked List in Java.
 * Supports insertion, deletion, and display operations.
 * @author <Thomas Alba Edison A>
 */
public class LL {
    private Node head;
    private Node tail;
    private int size;

    public LL() {
        size = 0;
    }

    /** Insert at the beginning */
    public void insertFirst(int value) {
        Node node = new Node(value);
        node.next = head;
        head = node;

        if (tail == null) {
            tail = head;
        }
        size++;
    }

    /** Insert at the end */
    public void insertLast(int value) {
        if (tail == null) {
            insertFirst(value);
            return;
        }
        Node node = new Node(value);
        tail.next = node;
        tail = node;
        size++;
    }

    /** Insert at specific index */
    public void insert(int value, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }

        if (index == 0) {
            insertFirst(value);
            return;
        }

        if (index == size) {
            insertLast(value);
            return;
        }

        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }

        Node node = new Node(value);
        node.next = temp.next;
        temp.next = node;
        size++;
    }

    /** Insert after a target value */
    public void insertAfter(int targetValue, int newValue) {
        Node temp = head;

        while (temp != null && temp.value != targetValue) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Value " + targetValue + " not found in the list.");
            return;
        }

        Node node = new Node(newValue);
        node.next = temp.next;
        temp.next = node;

        if (temp == tail) {
            tail = node;
        }

        size++;
    }

    /** Insert before a target value */
    public void insertBefore(int targetValue, int newValue) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (head.value == targetValue) {
            insertFirst(newValue);
            return;
        }

        Node prev = null;
        Node curr = head;
        while (curr != null && curr.value != targetValue) {
            prev = curr;
            curr = curr.next;
        }

        if (curr == null) {
            System.out.println("Value " + targetValue + " not found in the list.");
            return;
        }

        Node node = new Node(newValue);
        prev.next = node;
        node.next = curr;
        size++;
    }

    /** Delete first node */
    public void deleteFirst() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        head = head.next;
        size--;
        if (head == null) {
            tail = null;
        }
    }

    /** Delete last node */
    public void deleteLast() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (head.next == null) {
            head = null;
            tail = null;
            size--;
            return;
        }

        Node curr = head;
        for (int i = 1; i < size - 1; i++) {
            curr = curr.next;
        }
        curr.next = null;
        tail = curr;
        size--;
    }

    /** Delete node by value */
    public void delete(int value) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (head.value == value) {
            deleteFirst();
            return;
        }

        Node prev = null;
        Node curr = head;
        while (curr != null && curr.value != value) {
            prev = curr;
            curr = curr.next;
        }

        if (curr == null) {
            System.out.println("Value " + value + " not found.");
            return;
        }

        if (curr == tail) {
            deleteLast();
            return;
        }

        prev.next = curr.next;
        size--;
    }

    /** Display the list */
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    /** Node class (inner private class) */
    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
