import java.io.FileNotFoundException;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        CustomLinkedList linkedList = new CustomLinkedList();

        try {
            linkedList.loadFromFile("input.txt");
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            return;
        }

        System.out.println("Linked list elements:");
        Iterator<Integer> iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }

        System.out.println("\nDeleting 2...");
        linkedList.delete(2);

        System.out.println("Linked list after deletion:");
        iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}
