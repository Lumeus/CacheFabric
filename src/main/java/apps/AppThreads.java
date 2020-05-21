package apps;

import cacheFabricThreads.CacheManager;
import cacheFabricThreads.ClientThread;

public class AppThreads {

	public static void main(String[] args) {
		// создаём кэш через кэш-менеджер
		CacheManager cache = new CacheManager(1, 1);
		// создаём два потока-клиента
		Thread thread_0 = new Thread(new ClientThread(cache, 2000, "0"));
		Thread thread_1 = new Thread(new ClientThread(cache, 2000, "1"));
		// запускаем потоки
		thread_0.start();
		thread_1.start();
		// ждём 5000 миллисекунд
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// создаём ещё два потока-клиента
		Thread thread_2 = new Thread(new ClientThread(cache, 3000, "0"));
		Thread thread_3 = new Thread(new ClientThread(cache, 1000, "1"));
		// запускаем потоки
		thread_2.start();
		thread_3.start();
		// ждём 5000 миллисекунд
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// закрываем потоки
		thread_0.interrupt();
		thread_1.interrupt();
		thread_2.interrupt();
		thread_3.interrupt();
		System.out.println("Конец");
	}

}
