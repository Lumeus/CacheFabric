package cacheFabricJava;

import java.util.ArrayList;

public class TopCache implements ICache {

	private ICache down;						// Ссылка на уровень ниже
	private ArrayList<ISingleton> memory;		// Массив синглтонов в кэше
	private int memorySize;						// Длинна массива
	private int minCounter = 0;					// Счетчик самого редкого
	private int maxCounter = 0;					// Счетчик самого частого
	
	public TopCache(int countLevel, int memorySize) { 
		System.out.println("Вызван конструктор TopCache");
		memory = new ArrayList<ISingleton>(memorySize); // создаём память кэша
		this.memorySize = memorySize;
		// создаём кэши нижнего уровня
		if (countLevel > 0) {
			down = new Cache(countLevel - 1, memorySize); 
		}
		else {
			down = new Fabric();
		}
		System.out.println("Создан TopCache");
	}
	
	public ISingleton get(String name) {
		System.out.println("Вызван TopCache.get()");
		ISingleton res = null;
		// просматриваем память кэша, если она не пуста
		for (int i = 0; i < memory.size(); i++) {
			if (memory.get(i).getName() == name) {
				res = memory.remove(i);
				res.upCounter();
				break;
			}
		}
		// если объект не был найден в памяти кэша, то ищем на следующем уровне кэша 
		if (res == null) res = down.get(name);
		take(res); // take(взять) - пытаемся разместить найденный объект в памяти кэша
		return res;
	}
	
	public void take(ISingleton obj) {
		System.out.println("Вызван TopCache.take()");
		ISingleton trash = null;
		boolean objAdded = false;
		// проверяем подходит ли объект к данному уровню кэша
		if (obj.getCounter() >= minCounter) {
			if (memory.size() == memorySize) {
				// последний объект в памяти кэша вытаскиваем, дабы освободить место для нового объекта
				trash = memory.remove(memorySize - 1);
			}
			// проходимся по памяти кэша
			for (int i = 0; i < memory.size(); i++) {
				if (memory.get(i).getCounter() <= obj.getCounter()) {
					memory.add(i, obj);
					objAdded = true;
					break;
				}
			}
			// добавляем объект в конец памяти кэша, если он не был ранее добавлен в память
			if (!objAdded) {
				memory.add(obj);
				objAdded = true;
			}
			// обновляем значения minCounter
			if (memory.size() == memorySize) {
				minCounter = memory.get(memorySize - 1).getCounter();
			}
			// лишний объект, если таковой имеется, отдаём кэшу следующего уровня
			if (trash != null) {
				down.take(trash);
			}
		}
		// отдаём объект кэшу следующего уровня, так как объект не подходит для данного уровня по частоте запросов
		else down.take(obj);
	}
	// выводим память в консоль
	public void printer() {
		System.out.print("\nthis lvl -> ");
		for	(int i = 0; i < memory.size();i++) {
			System.out.print(memory.get(i).getName() + " ");
		}
		System.out.print("\nnext lvl -> ");
		down.printer();
	}
}
