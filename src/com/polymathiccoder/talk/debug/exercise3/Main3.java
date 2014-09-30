package com.polymathiccoder.talk.debug.exercise3;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.util.Random;

/*
 * Memory leaks
 * Inspired by http://bugs.java.com/bugdatabase/view_bug.do?bug_id=4363937
 */
public class Main3 {
	public static void main(String[] args) throws InterruptedException, IOException {
		final MemoryLeaker memoryLeaker = new MemoryLeaker();
		memoryLeaker.leakMemory();
	}
	
	public static class MemoryLeaker {
		public void leakMemory() throws IOException {
			final File file = File.createTempFile("test", null);
			try (final ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file.getAbsolutePath(), true));) {
				while (true) {
					char[] random = new String(new BigInteger(9999999, new Random()).toString(32)).toCharArray();
					objectOutputStream.writeObject(random);
					objectOutputStream.flush();
				}
			}
		}
	}
}
