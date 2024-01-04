package gardenshop;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import gardenshop.Product.ProdType;


public class MenuMngmt {

	// 1. Create Garden Shop
	public static void createGardenShop(List<Shop> shops) {
		Shop shop;
		String name, foundShop;
		
		name = Input_sc.enterStr("Enter the name of your Garden Shop to register it");
		foundShop = Find.findShop(shops, name);
		
		if(foundShop == null) {
			shop = new Shop(name);
			shops.add(shop);
			System.out.println("Shop garden create successfully");
		} else {
			System.out.println("This shop garden's name it's already registered. Please choose another name");
		}
	}
	
	// 2. Add Tree, Flower or Decoration to the shop's stock
	public static void addProductToStock(List<Shop> shops) {
		Shop shop;
		String name, foundShop;
		
		name = Input_sc.enterStr("Enter the name of your Garden Shop to add a product");
		foundShop = Find.findShop(shops, name);
		
		if(foundShop != null) {
			shop = new Shop(name);
			shop.addProduct();
		} else {
			System.out.println("Sorry, you need to register your shop garden before add any product");
		}
	}
	
	// 3. Remove Tree, Flower or Decoration from the shop's stock
	public static void removeProductFromStock(List<Shop> shops) {
		Shop shop;
		String name, foundShop;
		
		name = Input_sc.enterStr("Enter the name of your Garden Shop to remove a product");
		foundShop = Find.findShop(shops, name);
		
		if(foundShop != null) {
			shop = new Shop(name);
			int prodId, quantity;
			Product prodFound;

			prodId = Input_sc.enterInt("Enter the ID of the product you want to remove:");
			quantity = Input_sc.enterInt("Enter how many items of this product you want to remove:");
			
			prodFound = Find.findProdById(shop, prodId);
			shop.removeProduct(prodFound, quantity);
		} else {
			System.out.println("Sorry, you need to register your shop garden before remove any product");
		}
	}
	
	// 4. Show the stock of all products
	public static void showAllProdStock(List<Shop> shops) {
		Shop shop;
		String name, foundShop;
		
		name = Input_sc.enterStr("Enter the name of your Garden Shop to see all your stock");
		foundShop = Find.findShop(shops, name);
		
		if(foundShop != null) {
			shop = new Shop(name);
			if(!shop.getProductsStock().isEmpty()) {
				List<Product> allStockProducts = shop.findKeys();
				
				List<Product> treeStock = allStockProducts.stream()
						.filter(p -> p.getProdType() == ProdType.TREE)
						.toList();
	
				List<Product> flowerStock = allStockProducts.stream()
						.filter(p -> p.getProdType() == ProdType.FLOWER)
						.toList();
	
				List<Product> decorationStock = allStockProducts.stream()
						.filter(p -> p.getProdType() == ProdType.DECORATION)
						.toList();
	
				System.out.println("Tree Stock: " + treeStock);
				System.out.println("Flower Stock: " + flowerStock);
				System.out.println("Decoration Stock: " + decorationStock);
				
			} else {
				System.out.println("Your garden shop doesn't have any stock yet");
			}
		} else {
			System.out.println("Sorry, you need to register your shop garden before  see all your stock");
		}
	}
	
	// 5. Show stock quantities
	public static void showAllProdStockQty(List<Shop> shops) {
		Shop shop;
		String name, foundShop;
		
		name = Input_sc.enterStr("Enter the name of your Garden Shop to see all your stock quantities");
		foundShop = Find.findShop(shops, name);
		
		if(foundShop != null) {
			shop = new Shop(name);
			if(!shop.getProductsStock().isEmpty()) {
				
				Map<Product, Integer> allStock = new HashMap<Product, Integer>();
				allStock = shop.getProductsStock();
				
				for(Map.Entry<Product, Integer> entry : allStock.entrySet()) {
					System.out.println("Product: " + entry.getKey() + "Quantity: " + entry.getValue());
				}
				
			} else {
				System.out.println("Your garden shop doesn't have any stock yet");
			}
		} else {
			System.out.println("Sorry, you need to register your shop garden before  see all your stock quantities");
		}
	}
	
	// 6. Show total value of the Garden shop
	public static void showAllShopStockValue(Shop shop) {
		double totalShopValue = 0;

		if(!shop.getProductsStock().isEmpty()) {
			totalShopValue = shop.findKeys().stream().mapToDouble(Product::getPrice).sum();
			shop.setStockValue(totalShopValue);
			System.out.println("The total stock value of the shop is " + totalShopValue + "€");
		} else {
			System.out.println("The shop doesn't have a stock yet");
		}
	}
	
	// 7. Create sale's ticket with multiple objects	
	public void createTicket(Shop shop) {
		System.out.println("To create the ticket you will need to enter the product id and the quantity desired.");
		Ticket ticket = new Ticket();
		Product product;
		int idProduct;
		String continueAddProd;
		boolean saleFinished = false;
		
		while(!saleFinished) {
			idProduct = Input_sc.enterInt("Enter the Id of the product");
			product = Find.findProdById(shop, idProduct);
			
			shop.stockMngmt(ticket, product);
			
			continueAddProd = Input_sc.enterStr("Would you like to add another product? Type y/n");
			if(continueAddProd.equalsIgnoreCase("n")) {
				saleFinished = true;
				ticket.calculateTotalAmount();
			}
		}
		
		System.out.println("Ticket created successfully\n"
				+ "Shop name: " + shop.getName() + "\n"
				+ ticket.toString());
		
		shop.setTicketsHistory(ticket);
		
	}
	
	// 8. Show old sale's tickets
	public static void showOldSalesTickets(Shop shop) {
		
		if(!shop.getTicketsHistory().isEmpty()) {
			System.out.println("Ticket history:");
			shop.getTicketsHistory().forEach(System.out::println);
		} else {
			System.out.println("There is no ticket in our database yet");
		}
	}
	
	// 9. Show total amount made from sales
	public static void showTotalSalesAmount(Shop shop) {
		double totalAmountSales = 0;
		totalAmountSales = shop.findKeys().stream().mapToDouble(Product::getPrice).sum();

		System.out.println("The Total Amount of the " + shop.getName() + " is " + totalAmountSales + "€");
	}
	
}
