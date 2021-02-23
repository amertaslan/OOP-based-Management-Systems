
public class Office {
	private int officeID;
	private static int ID = 1;
	private String name;
	private Address address;
	private Phone phone;
	
	public Office(String name, Address address, Phone phone) {
		this.officeID = ID++;
		this.name = name;
		this.address = address;
		this.phone = phone;
	}

	public int getOfficeID() {
		return officeID;
	}

	public void setOfficeID(int officeID) {
		this.officeID = officeID;
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

	public String displayOffice() {
		return "Office [officeID=" + officeID + ", name=" + name + ", address=" + address.displayAddress() + ", phone=" + phone.displayPhone() + "]";
	}

	
}
