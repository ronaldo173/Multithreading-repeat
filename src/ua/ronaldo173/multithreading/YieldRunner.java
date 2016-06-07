package ua.ronaldo173.multithreading;

public class YieldRunner {

	public static void main(String[] args) {
		Object monitor = new Object();

		Thread thread1 = new Thread() {
			public void run() {
				System.out.println("start 1");
				try {
					synchronized (monitor) {
						System.out.println("1 waiting...");
						monitor.wait();
						System.out.println("1 wake up...");
						System.out.println(Thread.currentThread().isDaemon());
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("end1");
			}
		};

		Thread thread2 = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("start2");
				try {
					Thread.sleep(3000);
					
					synchronized (monitor) {
						monitor.notifyAll();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("end2");
			}
		});
		
		thread1.setDaemon(true);
		thread1.start();
		thread2.start();
	}
}
