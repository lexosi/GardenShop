package gardenshop;

import java.util.List;

public class Find {

	public static String findShop(List<Shop> shops, String name) {
		Shop foundShop;
		
		foundShop = shops.stream()
				.filter(s -> s.getName().equals(name))
				.findFirst()
				.orElse(null);
		
		return foundShop.getName();
	}
	
	public static Product findProdById(Shop shop, int prodId) {
		Product product = shop.findKeys().stream()
				.filter(p -> p.getProdId() == prodId)
				.findFirst()
				.orElse(null);

		return product;
	}
	
}
