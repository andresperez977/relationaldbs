package relationaldbs.model;

public class Producto {

	private Long id;
	private String name;
	private String price;
	private double category;
	private String brand;
	private int stock;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public double getCategory() {
		return category;
	}
	public void setCategory(double category) {
		this.category = category;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public Producto(Long id, String name, String price, double category, String brand, int stock) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.category = category;
		this.brand = brand;
		this.stock = stock;
	}

	
}
