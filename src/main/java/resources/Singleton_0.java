package resources;

import resources.ISingleton;

public class Singleton_0 implements ISingleton {

	private static Singleton_0 inst = null;
	
	private Singleton_0() {}

	public static resources.ISingleton get() {
		if (inst == null) inst = new Singleton_0();
		return inst;
	}

}
