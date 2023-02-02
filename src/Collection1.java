import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

public class Collection1 {
    public static void main(String[] args) {
       
        // created on heap (in the form of object)
        List<Integer> list = new ArrayList<>();

        // Add
        list.add(0);
        list.add(2);
        list.add(3);

        System.out.println(list);

        // get
        System.out.println(list.get(0));

        // size
        System.out.println(list.size());

        // set value at index
        list.set(0, 9);
        System.out.println(list);

        // add an element at index
        list.add(1, 12);
        System.out.println(list);

        // Collections class which contains all collection classes like ArrayList
        // LinkedList Map HashMap
        Collections.sort(list);

        System.out.println("Sorted list");
        for (var l : list) {
            System.out.print(l + " ");
        }

        System.out.println();

        // Implementing stack Collection Interface
        Deque<String> stack = new ArrayDeque<>();

        stack.push("Ahmad");
        stack.push("john");
        stack.push("Hello");

        Iterator<String> it = stack.iterator();

        while (it.hasNext()) {
            System.out.println(it.next() + " ");
        }

        // System.out.println(stack.pop())
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());


        // Queue
        Queue<Integer> queue = new LinkedList<>();

        queue.add(12);
        queue.offer(45);
        queue.offer(88);

        var it1 = queue.iterator();

        while (it1.hasNext()) {
            System.out.println(it1.next());
        }

        // removing an element
        System.out.println(queue.poll());
        System.out.println(queue.size());

        
        // Priority Queue

        // Min Heap
        // Queue<Integer> pq = new PriorityQueue<>();

        // Max Heap
        Queue<Integer> pq= new PriorityQueue<>(Comparator.reverseOrder());

        pq.offer(44);
        pq.offer(12);
        pq.offer(89);
        pq.offer(-1);
        pq.offer(99);

        System.out.println(pq);
        pq.poll();
        System.out.println(pq);


        // Array deque
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.offer(12);
        deque.offer(44);

        System.out.println(deque);

        deque.offerFirst(1);
        deque.offerLast(19);
        deque.push(100);

        System.out.println(deque);

        System.out.println(deque.pollLast());
        System.out.println(deque);


        // Set
        Set<Integer> set = new HashSet<>(); // O(1)
        set.add(12);
        set.add(9);
        set.add(14);
        set.add(100);

        System.out.println(set);

        System.out.println(set.contains(12));
        set.clear();
        System.out.println(set.size());


        Set<Integer> set1 = new LinkedHashSet<>(); // O(N)
        set1.add(12);
        set1.add(9);
        set1.add(14);
        set1.add(100);

        System.out.println(set1);


        Set<Integer> set2 = new TreeSet<>(); // O(log n)
        set2.add(12);
        set2.add(9);
        set2.add(14);
        set2.add(100);
        System.out.println(set2);


        // Map Interface
        Map<String, Integer> map = new HashMap<>(); // Unordered HashMap O(1)

        map.put("Hello", 1);
        map.put("Hi", 2);
        map.put("Something", 19);

        System.out.println(map);
        
        
        for (Map.Entry<String, Integer> e: map.entrySet()) {
            System.out.println(e);

            // System.out.println(e.getKey());
            // System.out.println(e.getValue());
        }

        for (var key: map.keySet()) {
            System.out.println(key);
        }

        for (var value: map.values()) {
            System.out.println(value);
        }

        map.remove("Hello");
        System.out.println(map);

        System.out.println(map.containsValue(12));
    }
}
