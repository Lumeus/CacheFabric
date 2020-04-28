package resources;

public interface ICache {

	ISingleton get(String name); // получение объекта по имени
	
	void take(ISingleton obj); // помещение объекта в память кэша
	
	void printer(); // выводим память кэша
	
}
