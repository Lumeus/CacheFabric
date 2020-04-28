package apps;

import resources.ICache;
import resources.ISingleton;
import resources.TopCache;

public class App {

	public static void main(String[] args) {
		
		ICache a = new TopCache(0, 1);
		ISingleton b = a.get("1");
		b = a.get("0");

	}

}
