import java.io.FileNotFoundException;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        CustomLinkedList linkedList = new CustomLinkedList();

        // Load values from file
        try {
            linkedList.loadFromFile("input.txt");
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            return;
        }

        // Print elements before deletion
        System.out.println("Linked list elements:");
        Iterator<Integer> iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }

        // Try to delete a value and print result
        System.out.println("\n\nDeleting 2...");
        boolean deleted = linkedList.delete(2);
        if (deleted) {
            System.out.println("Element 2 deleted successfully.");
        } else {
            System.out.println("Element 2 not found in the list.");
        }

        // Print elements after deletion
        System.out.println("\nLinked list after deletion:");
        iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }

        System.out.println();
    }
}
