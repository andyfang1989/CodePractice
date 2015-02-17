package tests;
import static org.junit.Assert.*;
import datastructure.ListNode;
import utils.LinkedListUtil;

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
		first.setNext(new ListNode(5));
		ListNode result1 = LinkedListUtil.mergeAscendingSinglyLinkedList(first, second);
		String resultString = "";
		while (result1 != null) {
			resultString += result1.getVal();
			result1 = result1.getNext();
		}
		assertEquals(resultString, "125");
		first = new ListNode(1);
		second = new ListNode(2);
		second.setNext(new ListNode(7));
	    ListNode result2 = LinkedListUtil.mergeAscendingSinglyLinkedList(first, second);
	    resultString = "";
	    while(result2 != null) {
	    	resultString += result2.getVal();
	    	result2 = result2.getNext();
	    }
	    assertEquals(resultString, "127");
	    System.out.println("TestMergeAscendingSinglyLinkedList ends");
	}
	
	private void TestReverseSinglyLinkedList() {
		System.out.println("TestReverseSinglyLinkedList starts");
		ListNode first = new ListNode(0);
		ListNode second = new ListNode(1);
		ListNode third = new ListNode(2);
		first.setNext(second);
		second.setNext(third);
		ListNode result = LinkedListUtil.reverseSinglyLinkedList(first);
		String resultString = "";
		while(result != null) {
	    	resultString += result.getVal();
	    	result = result.getNext();
	    }
		assertEquals(resultString, "210");
		System.out.println("TestReverseSinglyLinkedList ends");
	}
	
	private void TestCheckCycle() {
		System.out.println("TestCheckCycle starts");
		ListNode first = new ListNode(0);
		assertNull(LinkedListUtil.checkCycle(first));
		ListNode second = new ListNode(1);
		first.setNext(second);
		assertNull(LinkedListUtil.checkCycle(first));
		ListNode third = new ListNode(2);
		second.setNext(third);
		third.setNext(second);
		assertEquals(second, LinkedListUtil.checkCycle(first));
		System.out.println("TestCheckCycle ends");
	}
}
