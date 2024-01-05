package gardenshop;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ManageData {

	/* LOAD DATA */
	public static List<Shop> loadData() {
        List<Shop> shops = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get("./src/main/java/gardenshop/txtfiles/shops.txt"),
                    StandardCharsets.UTF_8);
            for (String line : lines) {
                shops.add(new Shop(line));
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return shops;
    }
	
	/* SAVE DATA */
	public static void saveData(List<Shop> shops) {
		try {
			FileOutputStream fos = new FileOutputStream("./src/main/java/gardenshop/txtfiles/shops.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(shops);

			oos.close();
			fos.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	
	public static void saveProduct(Product product, int quantity) {
		try {
			File stockFile = new File("./src/main/java/gardenshop/txtfiles/stock.txt");
			if(!stockFile.exists()) {
				stockFile.createNewFile();
				System.out.println("New Stock File created");
			}
			FileWriter writting = new FileWriter(stockFile, true);
			writting.write(product.toString() + " Quantity = " + quantity + "\n");
			writting.close();
			System.out.println("Product saved successfully");
		} catch(IOException e) {
			System.out.println("There has been an error " + e.getMessage());
		}
	}
	
	public static void saveTicket(Ticket ticket) {
		try {
			File ticketFile = new File("./src/main/java/gardenshop/txtfiles/tickets.txt");
			if (!ticketFile.exists()) {
				ticketFile.createNewFile();
				System.out.println("New Ticket File created");
			}
			FileWriter writting = new FileWriter(ticketFile, true);
			writting.write(ticket.toString() + "\n");
			writting.close();
		} catch (IOException e) {
			System.out.println("There has been an error" + e.getMessage());
		}
	}
	
	/* MODIFIY DATA */
	public static void modifyProduct(Product product, int newQty, int quantity) {
		String newProdLine = product.toString() + " Quantity = " + newQty;
		
		try {
			File stockFile = new File("./src/main/java/gardenshop/txtfiles/stock.txt");
			if (stockFile.exists()) {
				List<String> out = new ArrayList<>();
				List<String> lines = Files.readAllLines(stockFile.toPath(), StandardCharsets.UTF_8);

				for (String line : lines) {
					if (!line.contains(product.toString() + " Quantity = " + quantity)) {
						out.add(line);
					} else {
						out.add(newProdLine);
					}
				}

				Files.write(stockFile.toPath(), out, StandardCharsets.UTF_8);
				System.out.println("Product removed from Stock File");
			}
		} catch (IOException e) {
			System.out.println("There has been an error" + e.getMessage());
		}
	}
	
	/* REMOVE DATA */
	public static void deleteProduct(Product product, int quantity) {
		try {
			File stockFile = new File("./src/main/java/gardenshop/txtfiles/stock.txt");
			if (stockFile.exists()) {
				List<String> out = new ArrayList<>();
				List<String> lines = Files.readAllLines(stockFile.toPath(), StandardCharsets.UTF_8);

				for (String line : lines) {
					if (!line.contains(product.toString() + " Quantity = " + quantity)) {
						out.add(line);
					}
				}

				Files.write(stockFile.toPath(), out, StandardCharsets.UTF_8);
				System.out.println("Product removed from Stock File");
			}
		} catch (IOException e) {
			System.out.println("There has been an error" + e.getMessage());
		}
	}
}
