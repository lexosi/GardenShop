package gardenshop;

import java.util.ArrayList;
import java.util.List;

public class Menu {

	static List<Shop> shops = new ArrayList<Shop>();

	
	public Menu() {
//		shops = ManageData.loadData();
	}

	
	public void startApp() {
		// 0. Create Garden Shop
		Shop shop = null;
		Shop foundShop;
		String name;
		
		name = Input_sc.enterStr("Enter the name of your Garden Shop to register it");
		foundShop = Find.findShop(shops, name);
		
		if(foundShop == null) {
			shop = new Shop(name);
			shops.add(shop);
			System.out.println("Garden Shop create successfully\n");
		} else {
			System.out.println("Your Garden Shop has already been registered\n");
		}
		
		System.out.println("Welcome to the " + name + " Shop App Menu");
		startMenu(shop);
	}

	
	public void startMenu(Shop shop) {
		boolean quit = false;
		
		do {
			switch(showMenu()) {
			case 0 -> quit = true;
			case 1 -> MenuMngmt.addProductToStock(shop);
			case 2 -> MenuMngmt.removeProductFromStock(shop);
			case 3 -> MenuMngmt.showAllProdStock(shop);
			case 4 -> MenuMngmt.showAllProdStockQty(shop);
			case 5 -> MenuMngmt.showAllShopStockValue(shop);
			case 6 -> MenuMngmt.createTicket(shop);
			case 7 -> MenuMngmt.showOldSalesTickets(shop);
			case 8 -> MenuMngmt.showTotalSalesAmount(shop);
			default -> System.out.println("Error! Please enter a number between 0 and 8");
			}
		} while(!quit);
	}
	
	
	public static byte showMenu() {
		
		byte option = Input_sc.enterByte("\nGARDEN SHOP APP MENU\n"
				+ "----------------------------------------------------------\n"
				+ "Choose one of the following options (enter its number)\n"
				+ "1. Add Tree, Flower or Decoration to the shop's stock\n"
				+ "2. Remove Tree, Flower or Decoration from the shop's stock\n"
				+ "3. Show the stock of all products\n"
				+ "4. Show stock quantities\n"
				+ "5. Show total value of the Garden shop\n"
				+ "6. Create sale's ticket with multiple objects\n"
				+ "7. Show old sale's tickets\n"
				+ "8. Show total amount made from sales\n"
				+ "0. Quit the app");
		
		return option;
	}
}
