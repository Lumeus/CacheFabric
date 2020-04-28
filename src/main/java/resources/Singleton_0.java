package resources;

import resources.ISingleton;

public class Singleton_0 implements ISingleton {

	private static Singleton_0 inst = null;
	private static int counter = 0;
	
	private Singleton_0() {}

	public int getCounter() {
		return counter;
	}
	
	public int upCounter() {
		counter++;
		return counter;
	}
	
	public String getName() {
		return "0";
	}
	
	public static Singleton_0 get() {
		if (inst == null) inst = new Singleton_0();
		counter++;
		return inst;
	}

}
