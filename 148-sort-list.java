class Solution {
  public ListNode sortList(ListNode head) {
    // merge sort
    // find mid using fast & slow pointers

    if (head == null || head.next == null)
      return head;

    ListNode mid = getMid(head);
    ListNode left = sortList(head);
    ListNode right = sortList(mid);

    return merge(left, right);
  }

  private ListNode getMid(ListNode head) {
    ListNode slow = head, fast = head, prev = null;

    while (fast != null && fast.next != null) {
      prev = slow;
      slow = slow.next;
      fast = fast.next.next;
    }
    prev.next = null;
    return slow;
  }

  private ListNode merge(ListNode a, ListNode b) {
    ListNode dummy = new ListNode(0);
    ListNode tail = dummy;

    while (a != null && b != null) {
      if (a.val <= b.val) {
        tail.next = a;
        a = a.next;
      } else {
        tail.next = b;
        b = b.next;
      }
      tail = tail.next;
    }

    tail.next = (a != null) ? a : b;
    return dummy.next;
  }
}