/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10;
            sum %= 10;

            ListNode newNode = new ListNode(sum);
            current.next = newNode;
            current = current.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        // Example usage:
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

        AddTwoNumbers solution = new AddTwoNumbers();
        ListNode result = solution.addTwoNumbers(l1, l2);

        // Displaying the result
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
