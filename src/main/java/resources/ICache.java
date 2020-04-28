package resources;

public interface ICache {

	ISingleton get(String name);
	
	void take(ISingleton obj);
	
}
