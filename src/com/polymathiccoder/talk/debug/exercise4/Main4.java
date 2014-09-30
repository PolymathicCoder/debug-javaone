package com.polymathiccoder.talk.debug.exercise4;

public class Main4 {
	public static void main(String[] args) {
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (final InterruptedException interruptedException) {
			}
			
			new Thread() {
				@Override
				public void run() {
					try {
						Thread.sleep(10);
					} catch (final InterruptedException interruptedException) {
					}
				}
			}.start();
		}
	}
}
