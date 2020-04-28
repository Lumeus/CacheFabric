package resources;

public class Fabric implements ICache {
	
	public Fabric() {
		System.out.println("Создан Fabric");
	}
	
	public ISingleton get(String name) {
		System.out.println("Вызван Fabric.get()");
		ISingleton res = null;
		// обращаемся к нужному классу
		switch (name) {
		case("0"):
			res = Singleton_0.get();
			break;
		case("1"):
			res = Singleton_1.get();
			break;
		}
		return res;
	}

	public void take(ISingleton obj) {
		System.out.println("Вызван Fabric.take()");
		}

	public void printer() {
		System.out.println("конец!\n");
	}
}
