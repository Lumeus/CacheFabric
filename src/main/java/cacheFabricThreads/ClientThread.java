package cacheFabricThreads;

public class ClientThread implements Runnable {

	private CacheManager cache; // ссылка на кэш-менеджер
	private int time; // время сна
	private String name; // имя запрашиваемого объекта
	
	public ClientThread(CacheManager c, int t, String n){
		cache = c;
		time = t;
		name = n;
	}
	
	public void run() {
		while(true) {
			if (Thread.currentThread().isInterrupted()) break;
			// обращаемся к кэш-менеджеру 
			cache.get(name);
			System.out.println("Получен "+name);
			try{
				Thread.sleep(time);
			}catch(InterruptedException e) {
				break;
			}
		}

	}

}
