package resources;

import resources.ISingleton;

public class Singleton_1 implements ISingleton {

	private static Singleton_1 inst = null;
	
	private Singleton_1() {}

	public static resources.ISingleton get() {
		if (inst == null) inst = new Singleton_1();
		return inst;
	}

}
