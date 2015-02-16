import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestHeap implements TestUtilMethods {

	@Override
	public void runTests() {
		System.out.println("TestHeap starts");
		testMaxHeap();
		testMinHeap();
		TestSortKSortedLists();
		System.out.println("TestHeap ends");
	}

	private void testMaxHeap() {
		System.out.println("testMaxHeap starts");
		MaxHeap<Integer> maxHeap = new MaxHeap<Integer>();
		assertNull(maxHeap.peek());
		assertNull(maxHeap.pop());
		assertTrue(maxHeap.isEmpty());
		maxHeap.push(1);
		assertTrue(maxHeap.peek() == 1);
		maxHeap.push(4);
		maxHeap.push(5);
		assertTrue(maxHeap.peek() == 5);
		assertTrue(maxHeap.pop() == 5);
		assertTrue(maxHeap.peek() == 4);
		maxHeap.pop();
		maxHeap.pop();
		assertTrue(maxHeap.isEmpty());
		System.out.println("testMaxHeap ends");
	}

	private void testMinHeap() {
		System.out.println("testMinHeap starts");
		MinHeap<Integer> minHeap = new MinHeap<Integer>();
		assertNull(minHeap.peek());
		assertNull(minHeap.pop());
		assertTrue(minHeap.isEmpty());
		minHeap.push(1);
		assertTrue(minHeap.peek() == 1);
		minHeap.push(4);
		minHeap.push(5);
		assertTrue(minHeap.peek() == 1);
		assertTrue(minHeap.pop() == 1);
		assertTrue(minHeap.peek() == 4);
		minHeap.pop();
		minHeap.pop();
		assertTrue(minHeap.isEmpty());
		System.out.println("testMinHeap ends");
	}
	
	private void TestSortKSortedLists() {
		System.out.println("TestSortKSortedLists starts");
		TradingInfo t1 = new TradingInfo(new Date(100000000L), 1.0);
		TradingInfo t2 = new TradingInfo(new Date(100000001L), 2.0);
		TradingInfo t3 = new TradingInfo(new Date(100000002L), 3.0);
		TradingInfo t4 = new TradingInfo(new Date(100000004L), 4.0);
		TradingInfo t5 = new TradingInfo(new Date(100000005L), 5.0);
		TradingInfo t6 = new TradingInfo(new Date(100000006L), 6.0);
		TradingInfo t7 = new TradingInfo(new Date(100000007L), 7.0);
		TradingInfo t8 = new TradingInfo(new Date(100000008L), 8.0);
		TradingInfo t9 = new TradingInfo(new Date(100000009L), 9.0);
		List<TradingInfo> l1 = new ArrayList<TradingInfo>();
		List<TradingInfo> l2 = new ArrayList<TradingInfo>();
		List<TradingInfo> l3 = new ArrayList<TradingInfo>();
		l1.add(t1);
		l1.add(t4);
		l1.add(t7);
		l2.add(t2);
		l2.add(t5);
		l2.add(t8);
		l3.add(t3);
		l3.add(t6);
		l3.add(t9);
		List<List<TradingInfo>> lists = new ArrayList<List<TradingInfo>>();
		lists.add(l1);
		lists.add(l2);
		lists.add(l3);
		List<TradingInfo> result = HeapUtil.sortKSortedLists(lists);
		double price = 1.0;
		for (TradingInfo t : result) {
		    assertTrue(t.getTradingPrice() == price);
		    price += 1.0;
		}
		System.out.println("TestSortKSortedLists ends");
	}
}
