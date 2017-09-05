public class DeleteNode {
	 public void deleteNode(ListNode node){
		 if (node == null) 
			return ;
		 if (node.next == null) { // ���һ���ڵ�
			node = null;
			return;
		}
		 node.val = node.next.val;
		 ListNode delNode = node.next;
		 node.next = delNode.next;
		 delNode = null;
	 }
}
