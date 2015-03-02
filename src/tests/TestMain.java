package tests;

public class TestMain {
	public static void main(String[] args) {
		TestPrimitive testPrimitive = new TestPrimitive();
		testPrimitive.runTests();
		TestArray testArray = new TestArray();
		testArray.runTests();
		TestString testString = new TestString();
		testString.runTests();
		TestLinkedList testLinkedList = new TestLinkedList();
		testLinkedList.runTests();
		TestStackQueue testStackQueue = new TestStackQueue();
		testStackQueue.runTests();
		TestBinaryTree testBinaryTree = new TestBinaryTree();
		testBinaryTree.runTests();
		TestHeap testHeap = new TestHeap();
		testHeap.runTests();
		TestSearch testSearch = new TestSearch();
		testSearch.runTests();
		TestHash testHash = new TestHash();
		testHash.runTests();
		TestSort testSort = new TestSort();
		testSort.runTests();
		TestRecursion testRecursion = new TestRecursion();
		testRecursion.runTests();
		TestDP testDP = new TestDP();
		testDP.runTests();
		TestGreedy testGreedy = new TestGreedy();
		testGreedy.runTests();
	}
}
