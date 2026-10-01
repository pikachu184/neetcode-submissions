/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        List<Integer> arr = new ArrayList<>();
        ListNode cur = head;

        while (cur != null) {
            if (cur.val != val) {
                arr.add(cur.val);
            }
            cur = cur.next;
        }

        if (arr.isEmpty()) {
            return null;
        }

        ListNode res = new ListNode(arr.get(0));
        cur = res;
        for (int i = 1; i < arr.size(); i++) {
            ListNode node = new ListNode(arr.get(i));
            cur.next = node;
            cur = cur.next;
        }

        return res;
    }
}