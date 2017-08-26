package linkedlist;

public class MergeTwoSortedLists {
	public static ListNode mergeTwoLists(ListNode l1,ListNode l2) {
		ListNode virNode = new ListNode(0);
		ListNode cur = virNode;
		while (l1!=null || l2!=null) {
			if (l1 == null) {
				cur.next = l2;
				l2 = l2.next;
				cur = cur.next;
			}else if (l2 == null) {
				cur.next = l1;
				l1 = l1.next;
				cur = cur.next;
			}else {
				if (l1.val <= l2.val) {
					cur.next = l1;
					l1 = l1.next;
					cur = cur.next;
				}else {
					cur.next = l2;
					l2 = l2.next;
					cur = cur.next;
				}
			}
		}
		return virNode.next;
	}
}
