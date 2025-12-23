package com.Practice.Thread;

public class DeadlockExample {

	static class Resource {
		private final String name;

		public Resource(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}
	}

	private final Resource resourceA = new Resource("Resource A");
	private final Resource resourceB = new Resource("Resource B");

	public DeadlockExample() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DeadlockExample d = new DeadlockExample();
		d.runTest();

	}

	void runTest() {
		Thread t1 = new Thread(() -> {
			synchronized (resourceA) {
				System.out.println("Thread1  locks resourceA");

				try {
					Thread.sleep(100);

				} catch (InterruptedException e) {
					// TODO: handle exception
				}
				System.out.println("T1 waits for resource B");
				synchronized (resourceB) {
					System.out.println("T1 locks resource B");

				}
			}
		}

		);

		Thread t2 = new Thread(() -> {
			synchronized (resourceB) {
				System.out.println("Thread2  locks resourceB");

				try {
					Thread.sleep(100);

				} catch (InterruptedException e) {
					// TODO: handle exception
				}
				System.out.println("T2 waits for resource A");
				synchronized (resourceA) {
					System.out.println("T2 locks resource A");

				}
			}
		}

		);
		t1.start();
		t2.start();

	}

}
