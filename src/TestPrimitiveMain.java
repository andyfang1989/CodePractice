import static org.junit.Assert.*;

public class TestPrimitiveMain {
    public static void main(String[] args) {
    	System.out.println("Hello Github!");
    	TestGetBitsParityNaively();
    	TestGetBitsParityBetter();
    	TestPow();
    	TestConvertBase();
    }
    
    public static void TestGetBitsParityNaively() {
    	System.out.println("TestGetBitsParityNaively Starts");
    	long[] testSet = new long[1];
    	testSet[0] = 1L; 
    	assertTrue(PrimitiveUtil.getBitsParityNaively(testSet));
    	testSet[0] = 3L;
    	assertFalse(PrimitiveUtil.getBitsParityNaively(testSet));
    	testSet[0] = 15L;
    	assertFalse(PrimitiveUtil.getBitsParityNaively(testSet));
    	testSet[0] = Long.MAX_VALUE;
    	assertTrue(PrimitiveUtil.getBitsParityNaively(testSet));	
    	System.out.println("TestGetBitsParityNaively Passes");
    }
    
    public static void TestGetBitsParityBetter() {
    	System.out.println("TestGetBitsParityBetter Starts");
    	long[] testSet = new long[1];
    	testSet[0] = 1L; 
    	assertTrue(PrimitiveUtil.getBitsParityNaively(testSet));
    	testSet[0] = 3L;
    	assertFalse(PrimitiveUtil.getBitsParityNaively(testSet));
    	testSet[0] = 15L;
    	assertFalse(PrimitiveUtil.getBitsParityNaively(testSet));
    	testSet[0] = Long.MAX_VALUE;
    	assertTrue(PrimitiveUtil.getBitsParityNaively(testSet));
    	System.out.println("TestGetBitsParityBetter Passes");
    }
    
    public static void TestPow() {
    	System.out.println("TestPow Starts");
    	assertEquals(1.0, PrimitiveUtil.pow(1.2, 0), 0.00001);
    	assertEquals(1.2, PrimitiveUtil.pow(1.2, 1), 0.00001);
    	assertEquals(2.0736, PrimitiveUtil.pow(1.2, 4), 0.00001);
    	assertEquals(0.48225308642, PrimitiveUtil.pow(1.2, -4), 0.00001);
    	assertEquals(2.48832, PrimitiveUtil.pow(1.2, 5), 0.00001);
    	assertEquals(0.40187757201, PrimitiveUtil.pow(1.2, -5), 0.00001);
    	System.out.println("TestPow Passes");
    }
    
    public static void TestConvertBase() {
    	System.out.println("TestConvertBase Starts");
    	assertEquals("7", PrimitiveUtil.convertBase(2, 10, "111"));
    	assertEquals("-7", PrimitiveUtil.convertBase(2, 10, "-111"));
    	assertEquals("10", PrimitiveUtil.convertBase(2, 7, "111"));
    	assertEquals("-10", PrimitiveUtil.convertBase(2, 7, "-111"));
    	assertEquals("F", PrimitiveUtil.convertBase(2, 16, "1111"));
    	assertEquals("-F", PrimitiveUtil.convertBase(2, 16, "-1111"));
    	assertEquals("1111", PrimitiveUtil.convertBase(16, 2, "F"));
    	assertEquals("-1111", PrimitiveUtil.convertBase(16, 2, "-F"));
    	System.out.println("TestConvertBase Ends");
    }
}
