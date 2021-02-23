
public class Company {
	private int companyID;
	private static int ID = 1;
	private String name;
	private Address address;
	private Phone phone;
	
	public Company(String name, Address address, Phone phone) {
		this.companyID = ID++;
		this.name = name;
		this.address = address;
		this.phone = phone;
	}

	public int getCompanyID() {
		return companyID;
	}

	public void setCompanyID(int companyID) {
		this.companyID = companyID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String displayCompany() {
		return "Company [companyID=" + companyID + ", name=" + name + ", address=" + address.displayAddress() + ", phone=" + phone.displayPhone() + "]";
	}

}
