public class ReverseList206 {
	public static ListNode reverseList(ListNode head){
		ListNode pre = null;
		ListNode cur = head;
		while (cur != null) { // ѭ������ʽ
			ListNode next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		return pre;
	}
	
	public static ListNode createList(int[] arr,int n) {
		if (n == 0) {
			return null;
		}
		ListNode head = new ListNode(arr[0]);
		ListNode cur = head;
		for(int i=1;i<n;i++){
			cur.next = new ListNode(arr[i]);
			cur = cur.next;
		}
		return head;
	}
	
	public static void printList(ListNode head) {
		ListNode cur = head;
		while (cur != null) {
			System.out.print(cur.val + "->");
			cur = cur.next;
		}
		System.out.println("null");
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		ListNode head = createList(arr, arr.length);
		printList(head);
		ListNode head2 = reverseList(head);
		printList(head2);
	}

}

//class ListNode {
//    int val;
//    ListNode next;
//    ListNode(int x) { val = x; }
//}
