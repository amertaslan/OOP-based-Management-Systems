
public class Customer {
	private int customerID;
	private static int ID = 1;
	private String name;
	private Date birthdate;
	private String gender;
	private Address address;
	private Phone phone;
	private String type;
	private int rentCount;
	
	public Customer(String name, Date birthdate, String gender, Address address, Phone phone) {
		this.customerID = ID++;
		this.name = name;
		this.birthdate = birthdate;
		this.gender = gender;
		this.address = address;
		this.phone = phone;
		this.type = "";
		this.rentCount = 0;
	}
	
	public int getRentCount() {
		return rentCount;
	}

	public void setRentCount(int rentCount) {
		this.rentCount = rentCount;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}

	public String displayCustomer() {
		return "Customer [customerID=" + customerID + ", name=" + name + ", birthdate=" + birthdate.displayDate() + ", gender="
				+ gender + ", address=" + address.displayAddress() + ", phone=" + phone.displayPhone() + "]";
	}
	
	
}
