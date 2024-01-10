import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class RandomListNode {
    int label;
    RandomListNode next, random;

    RandomListNode(int x) {
        this.label = x;
    }
}

public class Solution {
    public RandomListNode copyRandomList_1(RandomListNode head) {
        if (head == null)
            return null;
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode dummy = new RandomListNode(-1);
        RandomListNode curNew = dummy, cur = head;
        while (cur != null) {
            if (!map.containsKey(cur)) {
                map.put(cur, new RandomListNode(cur.label));
            }
            if (cur.random != null && !map.containsKey(cur.random)) {
                map.put(cur.random, new RandomListNode(cur.random.label));
            }
            curNew.next = map.get(cur);
            curNew.next.random = map.get(cur.random);
            curNew = curNew.next;
            cur = cur.next;
        }
        return dummy.next;
    }

    public RandomListNode copyRandomList_2(RandomListNode head) {
        if (head == null)
            return null;
        RandomListNode cur = head;
        while (cur != null) {
            RandomListNode newnode = new RandomListNode(cur.label);
            newnode.next = cur.next;
            cur.next = newnode;
            cur = cur.next.next;
        }
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        RandomListNode dummy = new RandomListNode(-1);
        RandomListNode curNew = dummy;
        cur = head;
        while (cur != null) {
            curNew.next = cur.next;
            curNew = curNew.next;
            cur.next = cur.next.next;
            cur = cur.next;
        }
        return dummy.next;
    }

    public RandomListNode copyRandomList_3(RandomListNode head) {
        if (head == null)
            return null;
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        return copy(head, map);
    }

    private RandomListNode copy(RandomListNode root, HashMap<RandomListNode, RandomListNode> map) {
        if (root == null) return null;
        if (map.containsKey(root)) {
            return map.get(root);
        }
        RandomListNode newnode = new RandomListNode(root.label);
        map.put(root, newnode);
        newnode.next = copy(root.next, map);
        newnode.random = copy(root.random, map);
        return newnode;
    }

public RandomListNode copyRandomList_4(RandomListNode head) {
        if (head == null) return null;
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        Queue<RandomListNode> queue = new LinkedList<>();
        q
