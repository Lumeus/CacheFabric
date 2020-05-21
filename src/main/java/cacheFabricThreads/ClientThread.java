package cacheFabricThreads;

public class ClientThread implements Runnable {

	private CacheManager cache;
	private int time;
	private String name;
	
	public ClientThread(CacheManager c, int t, String n){
		cache = c;
		time = t;
		name = n;
	}
	
	public void run() {
		while(true) {
			if (Thread.currentThread().isInterrupted()) break;
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
