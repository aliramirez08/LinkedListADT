import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CustomLinkedList {
    private Node head;

    // Node definition
    private class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Insert at the end
    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    // Delete first occurrence — updated to return success/failure
    public boolean delete(int data) {
        if (head == null) return false;

        // Deleting the head node
        if (head.data == data) {
            head = head.next;
            return true;
        }

        Node current = head;
        while (current.next != null && current.next.data != data) {
            current = current.next;
        }

        if (current.next == null) {
            return false; // Not found
        }

        current.next = current.next.next;
        return true; // Deleted
    }

    // Iterator method
    public Iterator<Integer> iterator() {
        return new LinkedListIterator();
    }

    // Inner iterator class
    private class LinkedListIterator implements Iterator<Integer> {
        private Node current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Integer next() {
            if (!hasNext()) throw new NoSuchElementException();
            int data = current.data;
            current = current.next;
            return data;
        }
    }

    // Load from file
    public void loadFromFile(String filename) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(filename));
        while (scanner.hasNextInt()) {
            insert(scanner.nextInt());
        }
        scanner.close();
    }
}
