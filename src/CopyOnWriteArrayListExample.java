import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListExample {
    public static void main(String[] args) {
        List<String> list = new CopyOnWriteArrayList<>();

        list.add("A");
        list.add("B");

        System.out.println("Initial List: " + list);

        // Adding elements from another thread
        new Thread(() -> {
            list.add("C");
            System.out.println("List after modification: " + list);
        }).start();

        // Reading elements
        for (String element : list) {
            System.out.println("Element: " + element);
        }
    }
}
