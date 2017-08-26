package linkedlist;

public class AddTwoNumbers {
	/*
	 * 逆序存储的两个链表，每个节点的值都为一位数，返回链表每个节点的值仍为一位数。
	 */
	public static ListNode addTwoNumbers(ListNode l1,ListNode l2) {
		ListNode virNode = new ListNode(0);
		ListNode cur = virNode; // 当前节点
		int carry = 0;
		while (l1!=null || l2!=null) {
			int value = 0;
			if (l1 == null) {
				value = l2.val + carry;
				l2 = l2.next;
			}else if (l2 == null) {
				value = l1.val + carry;
				l1 = l1.next;
			}else {
				value = l1.val + l2.val + carry;
				l1 = l1.next;
				l2 = l2.next;
			}
			if (value >= 10) {
				value %= 10;
				carry = 1;
			}else {
				carry = 0;
			}
			cur.next = new ListNode(value);
			cur = cur.next;
		}
		if (carry == 1) {
			cur.next = new ListNode(1);
			cur = cur.next;
		}
		return virNode.next;
	}
	
	public static void printList(ListNode head) {
		while (head != null) {
			if (head.next == null) {
				System.out.print(head.val);
			}else{
				System.out.print(head.val + "->");
			}
			head = head.next;
		}
	}
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(5);
		ListNode l2 = new ListNode(5);
		ListNode ans = addTwoNumbers(l1, l2);
		printList(ans);
	}
}