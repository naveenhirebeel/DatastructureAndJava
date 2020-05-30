package com.datastructure.thread;

public class EvenOdd {

	public static void main(String[] args) {
		SharedObject sharedObject = new SharedObject();
		Thread et = new Thread(new EvenThread(sharedObject));
		Thread ot = new Thread(new OddThread(sharedObject));

		et.start();
		ot.start();
	}
}

class SharedObject {
	Integer i = 0;

	public synchronized void printEven() {

		if (i % 2 == 0) {
			System.out.println("Even \t" + i);
			i++;
			this.notify();
		} else {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public synchronized void printOdd() {

		if (i % 2 != 0) {
			System.out.println("odd \t" + i);
			i++;
			this.notify();
		} else {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class EvenThread implements Runnable {

	SharedObject sharedObject;

	public EvenThread(SharedObject sharedObject) {
		this.sharedObject = sharedObject;
	}

	public void run() {
		while (sharedObject.i <= 100) {
			sharedObject.printEven();
		}
		System.out.println("Even End");
	}
}

class OddThread implements Runnable {

	SharedObject sharedObject;

	public OddThread(SharedObject sharedObject) {
		this.sharedObject = sharedObject;
	}

	public void run() {
		while (sharedObject.i < 100) {
			sharedObject.printOdd();
		}
		System.out.println("Odd End");
	}
}