package tests;

import static org.junit.Assert.*;
import datastructure.LRUCache;
import utils.HashUtil;

public class TestHash implements TestUtilMethods {
	@Override
	public void runTests() {
		System.out.println("TestHash starts");
		TestCheckAnagram();
		TestLRUCache();
		System.out.println("TestHash ends");
	}

	private void TestCheckAnagram() {
		System.out.println("TestCheckAnagram starts");
		assertTrue(HashUtil.checkAnagram("aac", "aca"));
		assertFalse(HashUtil.checkAnagram("aac", "acaa"));
		assertFalse(HashUtil.checkAnagram("aacc", "acaa"));
		System.out.println("TestCheckAnagram ends");
	}

	private void TestLRUCache() {
		System.out.println("TestLRUCache starts");
		LRUCache cache = new LRUCache(1);
		cache.add("1", 1);
		cache.printCache();
		cache.add("2", 2);
		cache.printCache();
		cache = new LRUCache(4);
		cache.add("1", 1);
		cache.add("2", 2);
		cache.add("4", 4);
		cache.printCache();
		cache.add("5", 5);
		cache.add("6", 6);
		cache.printCache();
		cache.getPrice("2");
		cache.printCache();
		System.out.println("TestLRUCache ends");
	}
}
