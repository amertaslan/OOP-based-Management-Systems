
public class Employee {
	private int employeeID;
	private static int ID = 1;
	private int employeeofficenum;
	private String type;
	private String name;
	private Date birthdate;
	private String gender;
	private Address address;
	private Phone phone;
	private boolean activestatus;
	private double salary;
	private int losscount;
	
	public Employee(int employeeofficenum, String type, String name, Date birthdate, String gender, Address address, Phone phone) {
		this.employeeofficenum = employeeofficenum;
		this.employeeID = ID++;
		this.type = type;
		this.name = name;
		this.birthdate = birthdate;
		this.gender = gender;
		this.address = address;
		this.phone = phone;
		this.activestatus = true;
		this.salary = 2020.58;
		this.losscount = 0;
	}

	public int getEmployeeofficenum() {return employeeofficenum;}
	public int getEmployeeID() {return employeeID;}
	public String getType() {return type;}
	public String getName() {return name;}
	public Date getBirthdate() {return birthdate;}
	public String getGender() {return gender;}
	public Address getAddress() {return address;}
	public Phone getPhone() {return phone;}
	public boolean getActiveStatus() {return activestatus;}
	public double getSalary() {return salary;}
	public int getLosscount() {return losscount;}
	
	public void setEmployeeofficenum(int employeeofficenum) {this.employeeofficenum = employeeofficenum;}
	public void setEmployeeID(int employeeID) {this.employeeID = employeeID;}
	public void setType(String type) {this.type = type;}
	public void setName(String name) {this.name = name;}
	public void setBirthdate(Date birthdate) {this.birthdate = birthdate;}
	public void setGender(String gender) {this.gender = gender;}
	public void setAdress(Address address) {this.address = address;}
	public void setPhone(Phone phone) {this.phone = phone;}
	public void setActiveStatus(boolean activestatus) {this.activestatus = activestatus;}
	public void setSalary(double salary) {this.salary = salary;}
	public void setLosscount(int losscount) {this.losscount = losscount;}

	public String displayEmployee() {
		return "Employee [employeeID=" + employeeID + ", officenum=" + employeeofficenum + ", type=" + type
				+ ", name=" + name + ", birthdate=" + birthdate.displayDate() + ", gender=" + gender + ", address=" + address.displayAddress()
				+ ", phone=" + phone.displayPhone() + ", activestatus=" + activestatus + ", salary=" + salary;
	}


	
	
	
}
