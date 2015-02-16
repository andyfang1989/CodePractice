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
	}
}
