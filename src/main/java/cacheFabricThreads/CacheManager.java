package cacheFabricThreads;

import java.util.concurrent.Semaphore;

import cacheFabricJava.ICache;
import cacheFabricJava.ISingleton;
import cacheFabricJava.TopCache;

public class CacheManager {
	
	private ICache cache;
	private Semaphore mutex = new Semaphore(1);
	
	public CacheManager(int countLevel, int memorySize){
		cache = new TopCache(countLevel, memorySize);
	}
	
	public ISingleton get(String name){
		try {
			mutex.acquire();
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		ISingleton res = cache.get(name);
		mutex.release();
		return res;
	}
}
