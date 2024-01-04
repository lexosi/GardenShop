package gardenshop;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import gardenshop.Decoration.Material;
import gardenshop.Flower.Colour;
import gardenshop.Product.ProdType;

public class Shop {

	private int shopId;
	private static int shopIdNext;
	private String name;
	private Map<Product, Integer> productsStock;
	private double stockValue;
	private List<Ticket> ticketsHistory;
	
	public Shop(String name) {
		this.shopId = Shop.shopIdNext;
		Shop.shopIdNext++;
		this.name = name;
		this.productsStock = new HashMap<Product, Integer>();
		this.ticketsHistory = new ArrayList<Ticket>();
	}
	
	public int getShopId() {
		return shopId;
	}
	public String getName() {
		return name;
	} 
	public Map<Product, Integer> getProductsStock() {
		return productsStock;
	}
	public double getStockValue() {
		return stockValue;
	}
	public List<Ticket> getTicketsHistory(){
		return ticketsHistory;
	}

	
	public void setName(String name) {
		this.name = name;
	}
	public void setProductsStock(Product product, int quantity) {
		this.productsStock.put(product, quantity);
	}
	public void setStockValue(double stockValue) {
		this.stockValue = stockValue;
	}
	public void setTicketsHistory(Ticket ticket) {
		this.ticketsHistory.add(ticket);
	}

	// Update quantity
	public void updateStockQty(int quantity) {
		//get qty - quantity 
		// set qty
	}

	//Methods to get keys and values of the HashMap productsStock
		//Get keys (Product)
	public List<Product> findKeys() {
		Set<Product> findKeys = productsStock.keySet();
		List<Product> allStockProducts = new ArrayList<Product>();
		allStockProducts.addAll(findKeys);
		return allStockProducts;
	}
		//Get values (Quantity)
	public Collection<Integer> findValues() {
		Collection<Integer> findValues = productsStock.values();
		return findValues;
	}

	// Stock Methods	
	public void addProduct() {
		Product product = null;
		int quantity = 0;
		byte prodTypeOption;
		double price, height;
		String color, materials;
		Colour colour;
		Material material;
		
		prodTypeOption = Input_sc.enterByte("Which type of product do you want to add to the shop:\n"
				+ "1. Tree\n"
				+ "2. Flower\n"
				+ "3. Decoration");
		
		price = Input_sc.enterDouble("Enter the price of the product:");
		name = Input_sc.enterStr("Enter the name of the product:");
		quantity = Input_sc.enterInt("Enter the quantity:");  
		
		switch(prodTypeOption) {
		case 1:
			height = Input_sc.enterDouble("Enter tree's height:"); 
			
			product = new Tree(ProdType.TREE, name, price, height);
			setProductsStock(product, quantity);
			break;
		case 2:
			color = ChooseOptions.chooseColour();
			colour = Colour.valueOf(color.toUpperCase());
			
			product = new Flower(ProdType.FLOWER, name, price, colour);
			setProductsStock(product, quantity);
			break;
		case 3:
			materials = ChooseOptions.chooseMaterial();
			material = Material.valueOf(materials.toUpperCase());
			
			product = new Decoration(ProdType.DECORATION, name, price, material);
			setProductsStock(product, quantity);
		}
		System.out.println("Product added to stock successfully");
	}
	
	public void removeProduct(Product product, int quantity) {
		if(productsStock.containsKey(product)) {
			productsStock.remove(product, quantity);
			System.out.println("Product removed from stock successfully");
		}
	}
	
	
	public Ticket stockMngmt(Ticket ticket, Product product) {
		int stockQty, quantity;
		
		if(productsStock.containsKey(product)) {
			quantity = Input_sc.enterInt("Enter the numbers of products you want to buy");
			stockQty = productsStock.get(product);
			
			if(stockQty > quantity) {
				stockQty -= quantity;
				productsStock.put(product, stockQty);
				ticket.addProd(product, quantity);
			} else if(stockQty == quantity) {
				productsStock.remove(product, quantity);
				ticket.addProd(product, quantity);
			} else if(stockQty < quantity) {
				System.out.println("There's no enough stock of this product");
			} else {
				System.out.println("Sorry, there's no stock of this product");
			}
		} else {
			System.out.println("Sorry, we can't find this product");
		}
		return ticket;
	}
	
	@Override
	public String toString() {
		return "Shop [shopId=" + this.shopId + ", name=" + this.name + "]";
	}
}
