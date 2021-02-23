
public class Employee {
	private int employeeID;
	private static int ID = 1;
	private String name;
	private Date birthdate;
	private String gender;
	private Address address;
	private Phone phone;
	private double salary;
	private int rentCount;
	
	public Employee(String name, Date birthdate, String gender, Address address, Phone phone) {
		this.employeeID = ID++;
		this.name = name;
		this.birthdate = birthdate;
		this.gender = gender;
		this.address = address;
		this.phone = phone;
		this.salary = 2558.40;
		this.rentCount = 0;
	}

	public int getRentCount() {
		return rentCount;
	}

	public void setRentCount(int rentCount) {
		this.rentCount = rentCount;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
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
	
	public String displayEmployee() {
		return "Employee [employeeID=" + employeeID + ", name=" + name + ", birthdate=" + birthdate.displayDate() + ", gender="
				+ gender + ", address=" + address.displayAddress() + ", phone=" + phone.displayPhone() + ", salary=" + salary + "]";
	}

	
}
