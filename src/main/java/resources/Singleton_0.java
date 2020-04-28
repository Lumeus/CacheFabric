package resources;

import resources.ISingleton;

public class Singleton_0 implements ISingleton {

	private static Singleton_0 inst = null;
	private static int counter = 0;
	
	private Singleton_0() {
		//System.out.println("Вызван конструктор Singleton_0");
	}
	// популярность объекта
	public int getCounter() {
		//System.out.println("Вызван Singleton_0.getCounter()");
		return counter;
	}
	// увеличиваем популярность объекта
	public int upCounter() {
		//System.out.println("Вызван Singleton_0.upCounter()");
		counter++;
		return counter;
	}
	// возвращает имя объекта
	public String getName() {
		//System.out.println("Вызван Singleton_0.getName()");
		return "0";
	}
	// получение объекта синглтона
	public static Singleton_0 get() {
		//System.out.println("Вызван Singleton_0.get()");
		if (inst == null) inst = new Singleton_0();
		counter++;
		return inst;
	}

}
