import java.util.Map;
import java.util.HashMap;

public class CopyListWithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode token = new RandomListNode(0);
        token.next = head;
        head = token;
        RandomListNode copyHead = new RandomListNode(0);
        RandomListNode copyTail = copyHead;
        Map<RandomListNode, RandomListNode> map 
            = new HashMap<RandomListNode, RandomListNode>();
        map.put(null, null);

        for (RandomListNode ptr = head; ptr != null; ptr = ptr.next) {
            if (!map.containsKey(ptr.next)) {
                map.put(ptr.next, new RandomListNode(ptr.next.label));
            }
            if (!map.containsKey(ptr.random) && ptr.random != null) {
                map.put(ptr.random, new RandomListNode(ptr.random.label));
            }
            copyTail.next = map.get(ptr.next);
            copyTail.random = map.get(ptr.random);
            copyTail = copyTail.next;
        }
        return copyHead.next;
    }
}
