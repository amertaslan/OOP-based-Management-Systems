
public class Customer {
	private int customerID;
	private static int ID = 1;
	private String name;
	private Date birthdate;
	private String gender;
	private String email;
	private Address address;
	private Phone phone;
	private boolean activestatus;
	private int sendercustomercount;
	
	public Customer(String name, Date birthdate, String gender, String email, Address address, Phone phone) {
		this.customerID = ID++;
		this.name = name;
		this.birthdate = birthdate;
		this.gender = gender;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.activestatus = true;
		this.sendercustomercount = 0;
	}
	
	public int getCustomerID() {return customerID;}
	public String getName() {return name;}
	public Date getBirthdate() {return birthdate;}
	public String getGender() {return gender;}
	public String getEmail() {return email;}
	public Address getAddress() {return address;}
	public Phone getPhone() {return phone;}
	public boolean getActiveStatus() {return activestatus;}
	public int getSendercustomercount() {return sendercustomercount;}
	
	public void setCustomerID(int customerID) {this.customerID = customerID;}
	public void setName(String name) {this.name = name;}
	public void setBirthdate(Date birthdate) {this.birthdate = birthdate;}
	public void setGender(String gender) {this.gender = gender;}
	public void setEmail(String email) {this.email = email;}
	public void setAdress(Address address) {this.address = address;}
	public void setPhone(Phone phone) {this.phone = phone;}	
	public void setActiveStatus(boolean activestatus) {this.activestatus = activestatus;}
	public void setSendercustomercount(int sendercustomercount) {this.sendercustomercount = sendercustomercount;}
	
	public String displayCustomer() {
		return "Customer [customerID=" + customerID + ", name=" + name + ", birthdate=" + birthdate.displayDate() + ", gender="
				+ gender + ", email=" + email + ", address=" + address.displayAddress() + ", phone=" + phone.displayPhone() + "]";
	}

}
