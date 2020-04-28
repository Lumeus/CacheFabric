package apps;

import resources.ICache; // подключили итерфейс кэшей
import resources.ISingleton; // подключили итерфейс синглтонов
import resources.TopCache; // подключили класс топКэш

public class App {

	public static void main(String[] args) {
		// создаём объект кэша и присваиваем ему двухуровненвый кэш длиной 1
		ICache a = new TopCache(1, 1); 
		// создаём объект типа синглтон и запрашиваем у кэша методом гет объект с именем 1
		ISingleton b = a.get("1"); 
		// запрашиваем у кэша методом гет объект с именем 0
		b = a.get("0");
		a.printer(); // выводим память кэша
	}

}
