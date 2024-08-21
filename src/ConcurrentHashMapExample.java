import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapExample {
    public static void main(String[] args) {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

        map.put("A", 1);
        map.put("B", 2);

        System.out.println("Initial Map: " + map);

        map.computeIfPresent("A", (key, val) -> val + 10);
        map.computeIfAbsent("C", key -> 5);

        System.out.println("Updated Map: " + map);
    }
}
