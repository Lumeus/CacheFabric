package resources;

public interface ISingleton {
	
	default int getCounter() {
		return 0;
	}
	
	int upCounter();
	
	default String getName() {
		return "";
	}
	
}
