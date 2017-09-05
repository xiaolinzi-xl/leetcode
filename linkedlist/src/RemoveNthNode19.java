public class RemoveNthNode19 {
	public ListNode removeNthFromEnd(ListNode head, int n){
		int length = 0;
		ListNode virNode = new ListNode(0);
		virNode.next = head;
		ListNode cur = virNode;
		while(cur != null){
			length++;
			cur = cur.next;
		}
		int key = length - n;
		if (key < 1 || key > length-1) {
			return virNode.next;
		} 
		cur = virNode;
		for(int i=2;i<=key;i++){
			cur = cur.next;
		}
		ListNode delNode = cur.next;
		cur.next = delNode.next;
		delNode = null;
		return virNode.next;
	}
	
	public ListNode removeNthFromEnd2(ListNode head, int n){
		ListNode virNode = new ListNode(0);
		virNode.next = head;
		ListNode p = virNode;
		ListNode q = virNode;
		
		for(int i=0;i<n+1;i++){
			q = q.next;
		}
		while (q != null) {
			p = p.next;
			q = q.next;
		}
		ListNode deListNode = p.next;
		p.next = deListNode.next;
		deListNode = null;
		return virNode.next;
	}
}
