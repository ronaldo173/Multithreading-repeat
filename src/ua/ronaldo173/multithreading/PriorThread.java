package ua.ronaldo173.multithreading;

public class PriorThread extends Thread {
	public PriorThread(String name) {
		super(name);
	}

	@Override
	public void run() {
		for (int i = 0; i < 30; i++) {
			System.out.println(getName() + " " + i);

			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class Runner {
	public static void main(String[] args) {
		PriorThread min = new PriorThread("min");
		PriorThread max = new PriorThread("max");
		PriorThread norm = new PriorThread("norm");

		min.setPriority(Thread.MIN_PRIORITY);
		max.setPriority(Thread.MAX_PRIORITY);
		norm.setPriority(Thread.NORM_PRIORITY);

		min.start();
		norm.start();
		max.start();
	}
}
