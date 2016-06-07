package ua.ronaldo173.multithreading;

public class ExceptionThread extends Thread {

	public void run(){
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("end of " + getName());
	}
}

class ExceptionDemo{
	public static void main(String[] args) throws InterruptedException {
		new ExceptionThread().start();
		throw new RuntimeException();
	}
}
enum Aaa{
	b;
}