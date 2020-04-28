package resources;

import java.util.ArrayList;

public class Cache implements ICache {

	private ICache down;						// Ссылка на уровень ниже
	private ArrayList<ISingleton> memory;		// Массив синглтонов в кэше
	private int memorySize;						// Длинна массива
	private int minCounter = 0;					// Счетчик самого редкого
	private int maxCounter = 0;					// Счетчик самого частого
	
	public Cache(int countLevel, int memorySize) {
		memory = new ArrayList<ISingleton>(memorySize);
		this.memorySize = memorySize;
		if (countLevel > 0) {
			down = new Cache(countLevel - 1, memorySize);
		}
		else {
			down = new Fabric();
		}
		System.out.println("Создан Cache");
	}
	
	public ISingleton get(String name) {
		System.out.println("Вызван Cache.get()");
		ISingleton res = null;
		for (int i = 0; i < memory.size(); i++) {
			if (memory.get(i).getName() == name) {
				res = memory.remove(i);
				res.upCounter();
				break;
			}
		}
		if (res == null) res = down.get(name);
		return res;
	}
	
	public void take(ISingleton obj) {
		System.out.println("Вызван Cache.take()");
		ISingleton trash = null;
		boolean objAdded = false;
		if (obj.getCounter() >= minCounter) {
			if (memory.size() == memorySize) {
				trash = memory.remove(memorySize - 1);
			}
			for (int i = 0; i < memory.size(); i++) {
				if (memory.get(i).getCounter() <= obj.getCounter()) {
					memory.add(i, obj);
					objAdded = true;
					break;
				}
			}
			if (!objAdded) {
				memory.add(obj);
				objAdded = true;
			}
			if (memory.size() == memorySize) {
				minCounter = memory.get(memorySize - 1).getCounter();
			}
			if (trash != null) {
				down.take(trash);
			}
		}
		else down.take(obj);
	}

}
