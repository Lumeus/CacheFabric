package resources;

import resources.ISingleton;

public class Singleton_1 implements ISingleton {

	private static Singleton_1 inst = null;
	private static int counter = 0;
	
	private Singleton_1() {}

	public int getCounter() {
		return counter;
	}
	
	public int upCounter() {
		counter++;
		return counter;
	}

	public String getName() {
		return "1";
	}
	
	public static Singleton_1 get() {
		if (inst == null) inst = new Singleton_1();
		counter++;
		return inst;
	}

}
