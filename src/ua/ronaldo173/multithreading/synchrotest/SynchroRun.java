package ua.ronaldo173.multithreading.synchrotest;

public class SynchroRun {

	public static void main(String[] args) {
		Resource rs = null;

		try {
			rs = new Resource("result.txt");

			Thread t1 = new SyncThread("FIRST", rs);
			Thread t2 = new SyncThread("SECOND", rs);

			t1.start();
			t2.start();
			t1.join();
			t2.join();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rs.close();
		}
	}
}
