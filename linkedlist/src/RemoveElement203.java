public class RemoveElement203 {
	public ListNode removeElements(ListNode head, int val){
		while (head != null && head.val == val) {
			ListNode delNode =head;
			head = delNode.next;
			delNode.next = null;
		}
		if (head == null) {
			return null;
		}
		ListNode cur = head;
		while(cur.next != null){
			if (cur.next.val == val) {
				ListNode delListNode = cur.next;
				cur.next = delListNode.next;
				delListNode.next = null;
			}else {
				cur = cur.next;
			}
		}
		return head;
	}
	
	public ListNode removeElements2(ListNode head, int val){
		ListNode virtualNode = new ListNode(0);
		virtualNode.next = head;
		ListNode cur = virtualNode;
		while(cur.next != null){
			if (cur.next.val == val) {
				ListNode delNode = cur.next;
				cur.next = delNode.next;
				delNode.next = null;
			}else {
				cur = cur.next;
			}
		}
		ListNode ans = virtualNode.next;
		virtualNode.next = null; // ɾ����ڵ�
		return ans;
	}
}


