package gardenshop;

import java.util.ArrayList;
import java.util.List;

public class Menu {

	static List<Shop> shops = new ArrayList<Shop>();

	public Menu() {
//		DataInit.loadData(shops);
	}

	public void startApp() {

		boolean quit = false;
		do {
			switch(showMenu()) {
			case 0 -> quit = true;
			case 1 -> MenuMngmt.createGardenShop(shops);
			case 2 -> MenuMngmt.addProductToStock(shops);
			case 3 -> MenuMngmt.removeProductFromStock(shops);
			case 4 -> MenuMngmt.showAllProdStock(shops);
			case 5 -> MenuMngmt.showAllProdStockQty(shops);
			case 6 -> MenuMngmt.showAllShopStockValue(shop);
			case 7 -> MenuMngmt.createTicket(shop);
			case 8 -> MenuMngmt.showOldSalesTickets(shop);
			case 9 -> MenuMngmt.showTotalSalesAmount(shop);
			default -> System.out.println("Error! Please enter a number between 0 and 9");
			}
		} while(!quit);
	}

	public static byte showMenu() {
		
		byte option = Input_sc.enterByte("GARDEN SHOP APP MENU\n"
				+ "Choose one of the following options (enter its number)\n"
				+ "1. Create Garden Shop\n"
				+ "2. Add Tree, Flower or Decoration to the shop's stock\n"
				+ "3. Remove Tree, Flower or Decoration from the shop's stock\n"
				+ "4. Show the stock of all products\n"
				+ "5. Show stock quantities\n"
				+ "6. Show total value of the Garden shop\n"
				+ "7. Create sale's ticket with multiple objects\n"
				+ "8. Show old sale's tickets\n"
				+ "9. Show total amount made from sales\n"
				+ "0. Quit the app");
		
		return option;
	}
}
