package cacheFabricJava;

public class Singleton_1 implements ISingleton {

	private static Singleton_1 inst = null;
	private static int counter = 0;
	
	private Singleton_1() {
		//System.out.println("Вызван конструктор Singleton_1");
	}
	// популярность объекта
	public int getCounter() {
		//System.out.println("Вызван Singleton_1.getCounter()");
		return counter;
	}
	// увеличиваем популярность объекта
	public int upCounter() {
		//System.out.println("Вызван Singleton_1.upCounter()");
		counter++;
		return counter;
	}
	// возвращает имя объекта
	public String getName() {
		//System.out.println("Вызван Singleton_1.getName()");
		return "1";
	}
	// получение объекта синглтона
	public static Singleton_1 get() {
		//System.out.println("Вызван Singleton_1.get()");
		if (inst == null) inst = new Singleton_1();
		counter++;
		return inst;
	}

}
