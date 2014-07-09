import java.util.Map;
import java.util.HashMap;

public class LRUCache {
    private class CacheNode {
        private int key;
        private int value;

        private CacheNode prev;
        private CacheNode next;

        public CacheNode(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }

    private int capacity;
    private int numNodes;

    private CacheNode head;
    private CacheNode tail;

    private Map<Integer, CacheNode> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        numNodes = 0;

        head = new CacheNode(0, 0);
        tail = new CacheNode(0, 0);
        head.prev = null;
        head.next = tail;
        tail.prev = head;
        tail.next = null;

        map = new HashMap<Integer, CacheNode>();
    }

    public int get(int key) {
        if (capacity == 0) {
            return -1;
        }
        CacheNode curr = map.get(key);
        if (curr == null) {
            return -1;
        }
        //remove from list
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;

        //add after head
        curr.next = head.next;
        head.next.prev = curr;
        curr.prev = head;
        head.next = curr;
        return curr.value;
    }

    public void set(int key, int value) {
        if (capacity == 0) {
            return;
        }
        CacheNode curr = map.get(key);
        if (curr != null) {
            curr.prev.next = curr.next;
            curr.next.prev = curr.prev;
            curr.value = value;
            --numNodes;
        } else {
            curr = new CacheNode(key, value);
            map.put(key, curr);
        }
        if (numNodes == capacity) {
            CacheNode temp = tail.prev;
            map.remove(temp.key);
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
            --numNodes;
        }
        curr.next = head.next;
        head.next.prev = curr;
        curr.prev = head;
        head.next = curr;
        ++numNodes;
        return;
    }

    public static void main(String[] args) {
        LRUCache solver = null;
        solver = new LRUCache(2);
        solver.set(2, 1);
        solver.set(2, 2);
        System.out.println(solver.get(2));
        solver.set(1, 1);
        solver.set(4, 1);
        System.out.println(solver.get(2));

        solver = new LRUCache(2);
        System.out.println(solver.get(2));
        solver.set(2, 6);
        System.out.println(solver.get(1));
        solver.set(1, 5);
        solver.set(1, 2);
        System.out.println(solver.get(1));
        System.out.println(solver.get(2));
    }
}
