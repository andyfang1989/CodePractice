import static org.junit.Assert.*;

public class TestLinkedList implements TestUtilMethods {

	@Override
	public void runTests() {
		System.out.println("TestLinkedList starts");
		TestMergeAscendingSinglyLinkedList();
		TestReverseSinglyLinkedList();
		TestCheckCycle();
		System.out.println("TestLinkedList ends");
	}
	
	private void TestMergeAscendingSinglyLinkedList() {
		System.out.println("TestMergeAscendingSinglyLinkedList starts");
		ListNode first = new ListNode(1);
		ListNode second = new ListNode(2);
		first.next = new ListNode(5);
		ListNode result1 = LinkedListUtil.mergeAscendingSinglyLinkedList(first, second);
		String resultString = "";
		while (result1 != null) {
			resultString += result1.val;
			result1 = result1.next;
		}
		assertEquals(resultString, "125");
		first = new ListNode(1);
		second = new ListNode(2);
		second.next = new ListNode(7);
	    ListNode result2 = LinkedListUtil.mergeAscendingSinglyLinkedList(first, second);
	    resultString = "";
	    while(result2 != null) {
	    	resultString += result2.val;
	    	result2 = result2.next;
	    }
	    assertEquals(resultString, "127");
	    System.out.println("TestMergeAscendingSinglyLinkedList ends");
	}
	
	private void TestReverseSinglyLinkedList() {
		System.out.println("TestReverseSinglyLinkedList starts");
		ListNode first = new ListNode(0);
		ListNode second = new ListNode(1);
		ListNode third = new ListNode(2);
		first.next = second;
		second.next = third;
		ListNode result = LinkedListUtil.reverseSinglyLinkedList(first);
		String resultString = "";
		while(result != null) {
	    	resultString += result.val;
	    	result = result.next;
	    }
		assertEquals(resultString, "210");
		System.out.println("TestReverseSinglyLinkedList ends");
	}
	
	private void TestCheckCycle() {
		System.out.println("TestCheckCycle starts");
		ListNode first = new ListNode(0);
		assertNull(LinkedListUtil.checkCycle(first));
		ListNode second = new ListNode(1);
		first.next = second;
		assertNull(LinkedListUtil.checkCycle(first));
		ListNode third = new ListNode(2);
		second.next = third;
		third.next = second;
		assertEquals(second, LinkedListUtil.checkCycle(first));
		System.out.println("TestCheckCycle ends");
	}
}
