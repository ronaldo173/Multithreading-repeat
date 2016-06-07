package ua.ronaldo173.multithreading;

public class PriorThread extends Thread {
	public PriorThread(String name) {
		super(name);
	}

	public PriorThread(ThreadGroup tg, String name) {
		super(tg, name);
	}

	@Override
	public void run() {
		for (int i = 0; i < 30; i++) {
			System.out.println(getPriority() + " " + getName() + " " + i + ".." + getThreadGroup());

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
		ThreadGroup tg = new ThreadGroup("My group1");

		PriorThread min = new PriorThread(tg, "min");
		PriorThread max = new PriorThread(tg, "max");
		PriorThread norm = new PriorThread(tg, "norm");

		min.setPriority(Thread.MIN_PRIORITY);
		max.setPriority(Thread.MAX_PRIORITY);
		norm.setPriority(Thread.NORM_PRIORITY);

		tg.setMaxPriority(6);
		min.start();
		norm.start();
		max.start();
	}
}
