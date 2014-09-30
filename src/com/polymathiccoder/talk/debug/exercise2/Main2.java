package com.polymathiccoder.talk.debug.exercise2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * Frog vs. Snake is inspired by http://news.nationalgeographic.com/news/2008/10/photogalleries/best-animal-wildlife-photos/photo4.html
 */
public class Main2 {
	public static void main(String[] args) {
		final Lock snakeJaw = new ReentrantLock();
		final Lock frogJaw = new ReentrantLock();
		
		final Runnable snake = new Runnable() {
			public void run() {
				try {
					System.out.println("The snake sees the frog");
					Thread.sleep(40);
					
					snakeJaw.lock();
					
					System.out.println("The snake opens wide and strikes the frog");
					Thread.sleep(50);
					
					System.out.println("The snake misses the frog's head and bites its lower jaw");
					System.out.println("The snake is trying to swallow the frog...");
					frogJaw.lock();
					
					frogJaw.unlock();
					System.out.println("The snake swallows the frog");
	
					snakeJaw.unlock();
					System.out.println("The snake ate the frog");
				} catch (final InterruptedException interruptedException) {
				}
			}
		};
		
		final Runnable frog = new Runnable() {
			public void run() {
				try {
					System.out.println("The frog sees the snake");
					Thread.sleep(50);
								
					frogJaw.lock();
					
					System.out.println("The frog opens wide to fend off the snake");
					Thread.sleep(50);
					
					System.out.println("The frog grabs the snake's with its right manus");
					System.out.println("The frog is trying to pull off the snake...");
					snakeJaw.lock();
					
					snakeJaw.unlock();
					System.out.println("The frog pulls off the snake");
					
					frogJaw.unlock();
					System.out.println("The forg escapes");
				} catch (final InterruptedException interruptedException) {
				}
			}
		};
		
		ExecutorService theWild = Executors.newFixedThreadPool(2);
		theWild.submit(frog);
		theWild.submit(snake);
		theWild.shutdown();
	}
}
