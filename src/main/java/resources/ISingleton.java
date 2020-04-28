package resources;

public interface ISingleton {
	
	default int getCounter() {
		return 0;
	} // получение популярности объекта
	
	int upCounter(); // увеличение популяности объекта
	
	default String getName() {
		return "";
	} // получение имени объекта
	
}
