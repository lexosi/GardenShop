package gardenshop;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class ManageData {

	/* LOAD DATA */
	public static List<Shop> loadData() {
		List<Shop> shops = null;
		try {
			FileInputStream fis = new FileInputStream("shops.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);

			shops = (List<Shop>) ois.readObject();

			ois.close();
			fis.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (ClassNotFoundException c) {
			System.out.println("Class not found");
			c.printStackTrace();
		}
		return shops;
	}

	/* SAVE DATA */
	public static void saveData(List<Shop> shops) {
		try {
			FileOutputStream fos = new FileOutputStream("shops.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(shops);

			oos.close();
			fos.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	public static void saveGardenShop(Shop shop) {
		
	}
	
	public static void saveProduct(Product product, int quantity) {
		try {
			File stockFile = new File("./gardenshop/txtfiles/stock.txt");
			if(!stockFile.exists()) {
				stockFile.createNewFile();
				System.out.println("New Stock File created");
			}
			FileWriter writting = new FileWriter(stockFile, true);
			writting.write(product.toString() + " Quantity =" + quantity);
			writting.close();
		} catch(IOException e) {
			System.out.println("There has been an error" + e.getMessage());
		}
	}
	
	public static void saveTicket(Ticket ticket) {
		
	}
	
	/* REMOVE DATA */
	public static void deleteProduct(Product product, int quantity) {
		
	}
}
