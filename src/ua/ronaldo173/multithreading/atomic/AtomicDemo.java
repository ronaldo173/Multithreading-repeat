package ua.ronaldo173.multithreading.atomic;

import java.util.concurrent.atomic.AtomicLong;

public class AtomicDemo {

	public static void main(String[] args) {
		Market market = new Market(new AtomicLong(100));
		market.start();

		for (int i = 0; i < 30; i++) {
			new Broker(market).start();
		}
	}
}
