package apps;

import cacheFabricThreads.CacheManager;
import cacheFabricThreads.ClientThread;

public class AppThreads {

	public static void main(String[] args) {
		CacheManager cache = new CacheManager(1, 1);

		Thread thread_0 = new Thread(new ClientThread(cache, 2000, "0"));
		Thread thread_1 = new Thread(new ClientThread(cache, 2000, "1"));

		thread_0.start();
		thread_1.start();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Thread thread_2 = new Thread(new ClientThread(cache, 3000, "0"));
		Thread thread_3 = new Thread(new ClientThread(cache, 1000, "1"));

		thread_2.start();
		thread_3.start();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		thread_0.interrupt();
		thread_1.interrupt();
		thread_2.interrupt();
		thread_3.interrupt();
		System.out.println("Конец");
	}

}
