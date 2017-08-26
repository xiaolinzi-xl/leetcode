package linkedlist;

public class SwapNode24 {
	 public ListNode swapPairs(ListNode head) {
		 ListNode virNode = new ListNode(0);
		 virNode.next = head;
		 ListNode p = virNode;
		 while(p.next != null && p.next.next != null){
			 ListNode node1 = p.next;
			 ListNode node2 = node1.next;
			 ListNode next = node2.next;
			 
			 node2.next = node1;
			 node1.next = next;
			 p.next = node2;
			 
			 p = node1;
		 }
		 ListNode ans = virNode.next;
		 virNode.next = null;
		 return ans;
	 }
}
