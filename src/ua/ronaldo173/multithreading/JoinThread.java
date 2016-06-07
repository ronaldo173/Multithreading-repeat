package ua.ronaldo173.multithreading;

public class JoinThread extends Thread {
	public JoinThread(String name) {
		super(name);
	}

	public void run() {
		String nameT = getName();
		long timeout = 0;
		System.out.println("Start thread " + nameT);

		switch (nameT) {
		case "First":
			timeout = 5_000;
			break;
		case "Second":
			timeout = 1_000;
		}
		try {
			Thread.sleep(timeout);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("end of thread " + nameT);
	}
}

class JoinRunner{
	static{
		System.out.println("Main start...");
	}
	
	public static void main(String[] args) {
		Thread t1 = new JoinThread("First");
		Thread t2 = new JoinThread("Second");
		
		t1.start();
		t2.start();
		
		try {
			t1.join(500);//маин стоп пока не выполнется т1
			System.out.println(Thread.currentThread());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName());
	}
}