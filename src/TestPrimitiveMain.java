
public class TestPrimitiveMain {
    public static void main(String[] args) {
    	System.out.println("Hello Github!");
    	TestGetBitsParityNaively();
    	TestGetBitsParityBetter();
    }
    
    public static void TestGetBitsParityNaively() {
    	System.out.println("TestGetBitsParityNaively starts");
    	long[] testSet = new long[1];
    	testSet[0] = 1L; 
    	System.out.println(PrimitiveUtil.getBitsParityNaively(testSet)); //true
    	testSet[0] = 3L;
    	System.out.println(PrimitiveUtil.getBitsParityNaively(testSet)); //false
    	testSet[0] = 15L;
    	System.out.println(PrimitiveUtil.getBitsParityNaively(testSet)); //false
    	testSet[0] = Long.MAX_VALUE;
    	System.out.println(PrimitiveUtil.getBitsParityNaively(testSet)); //true  	
    	System.out.println("TestGetBitsParityNaively ends");
    }
    
    public static void TestGetBitsParityBetter() {
    	System.out.println("TestGetBitsParityBetter starts");
    	long[] testSet = new long[1];
    	testSet[0] = 1L; 
    	System.out.println(PrimitiveUtil.getBitsParityBetter(testSet)); //true
    	testSet[0] = 3L;
    	System.out.println(PrimitiveUtil.getBitsParityBetter(testSet)); //false
    	testSet[0] = 15L;
    	System.out.println(PrimitiveUtil.getBitsParityBetter(testSet)); //false
    	testSet[0] = Long.MAX_VALUE;
    	System.out.println(PrimitiveUtil.getBitsParityBetter(testSet)); //true  
    	System.out.println("TestGetBitsParityBetter ends");
    }
}
