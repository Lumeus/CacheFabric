package cacheFabricThreads;

import java.util.concurrent.Semaphore;

import cacheFabricJava.ICache;
import cacheFabricJava.ISingleton;
import cacheFabricJava.TopCache;

public class CacheManager {
	
	private ICache cache; // ссылка на кэш
	private Semaphore mutex = new Semaphore(1); // семафор мьютекс
	
	public CacheManager(int countLevel, int memorySize){
		// создаём кэш
		cache = new TopCache(countLevel, memorySize);
	}
	
	public ISingleton get(String name){
		// пытаемся войти в разделяемую секцию
		try {
			mutex.acquire();
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		// запрашиваем нужный объект у кэша
		ISingleton res = cache.get(name);
		// выходим из разделяемой секции
		mutex.release();
		return res;
	}
}
