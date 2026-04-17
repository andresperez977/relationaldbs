package relationaldbs.model;

public class User {

	//field 
	private Long id;
	private String name;
	private String password;
	private double balance;
	private String email;
	private int phone;
	private String age;
	private String gender;
	private String city;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
		
	}
	public User(Long id, String name, String password, double balance, String email,int phone, String age,String gender,String city) {
		this.id=id;
		this.name = name;
		this.password = password;
		this.balance = balance;
		this.email= email;
		this.phone= phone;
		this.age= age;
		this.gender= gender;
		this.city=city;
	}


}
