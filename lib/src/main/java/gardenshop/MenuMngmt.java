package gardenshop;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import gardenshop.enums.ProdType;


public class MenuMngmt {

	// 1. Add Tree, Flower or Decoration to the shop's stock
	public static void addProductToStock(Shop shop) {
		shop.addProduct();
	}
	
	// 2. Remove Tree, Flower or Decoration from the shop's stock
	public static void removeProductFromStock(Shop shop) {
		int prodId, quantity;
		Product prodFound;

		prodId = Input_sc.enterInt("Enter the ID of the product you want to remove:");
		quantity = Input_sc.enterInt("Enter how many items of this product you want to remove:");
		
		prodFound = Find.findProdById(shop, prodId);
		shop.removeProduct(prodFound, quantity);
	}
	
	// 3. Show the stock of all products
	public static void showAllProdStock(Shop shop) {

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
	}
	
	// 4. Show stock quantities
	public static void showAllProdStockQty(Shop shop) {
		
		if(!shop.getProductsStock().isEmpty()) {
			
			Map<Product, Integer> allStock = new HashMap<Product, Integer>();
			allStock = shop.getProductsStock();
			
			for(Map.Entry<Product, Integer> entry : allStock.entrySet()) {
				System.out.println("Product: " + entry.getKey() + "Quantity: " + entry.getValue());
			}
			
		} else {
			System.out.println("Your garden shop doesn't have any stock yet");
		}
	}
	
	// 5. Show total value of the Garden shop
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
	
	// 6. Create sale's ticket with multiple objects	
	public static void createTicket(Shop shop) {
		System.out.println("To create the ticket you will need to enter the product id and the quantity desired.");
		Ticket ticket = new Ticket();
		Product product;
		int idProduct;
		Character continueAddProd;
		boolean saleFinished = false;
		
		while(!saleFinished) {
			idProduct = Input_sc.enterInt("Enter the Id of the product");
			product = Find.findProdById(shop, idProduct);
			
			ticket = shop.stockMngmt(ticket, product);
			
			continueAddProd = Input_sc.readChar("Would you like to add another product? Type y/n");
			if(continueAddProd == 'n') {
				saleFinished = true;
				ticket.calculateTotalAmount();
			} else {
				saleFinished = false;
			}
		}
		
		System.out.println("Ticket created successfully\n"
				+ "Shop name: " + shop.getName() + "\n"
				+ ticket.toString());
		
		shop.setTicketsHistory(ticket);
		ManageData.saveTicket(ticket);
	}
	
	// 7. Show old sale's tickets
	public static void showOldSalesTickets(Shop shop) {
		
		if(!shop.getTicketsHistory().isEmpty()) {
			System.out.println("Ticket history:");
			shop.getTicketsHistory().forEach(System.out::println);
		} else {
			System.out.println("There is no ticket in our database yet");
		}
	}
	
	// 8. Show total amount made from sales
	public static void showTotalSalesAmount(Shop shop) {
		double totalAmountSales = 0;
		
		totalAmountSales = shop.getTicketsHistory().stream().mapToDouble(Ticket::getTotalSaleAmount).sum();
		System.out.println("The Total Amount of the " + shop.getName() + " is " + totalAmountSales + "€");
	}
	
}
