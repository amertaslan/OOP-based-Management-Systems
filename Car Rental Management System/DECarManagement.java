
public class DECarManagement {
	private Office[] offices;
	private Employee[] employees;
	private Customer[] customers;
	private Car[] cars;
	private Contract[] contracts;
	private Company[] companies;
	private int officecount;
	private int employeecount;
	private int customercount;
	private int carcount;
	private int contractcount;
	private int companycount;

	public DECarManagement() {
		this.offices = new Office[150];
		this.employees = new Employee[150];
		this.customers = new Customer[150];
		this.cars = new Car[150];
		this.contracts = new Contract[150];
		this.companies = new Company[150];
		this.officecount = 0;
		this.employeecount = 0;
		this.customercount = 0;
		this.carcount = 0;
		this.contractcount = 0;
		this.companycount = 0;
	}

	//--------------------------------------------------------ADD METHODS--------------------------------------------------------------------
	public void addOffice(Office o) {
		offices[officecount] = o; //adding new office object to the office array.
		officecount++;//increasing counter to add new object to the next index of array.
	}	
	public void addEmployee(Employee e) {
		employees[employeecount] = e;//adding new office employee to the office array.
		employeecount++;//increasing counter to add new object to the next index of array.
	}	
	public void addCustomer(Customer c) {
		customers[customercount] = c;//adding new office customer to the office array.
		customercount++;//increasing counter to add new object to the next index of array.
	}	
	public void addCar(Car c) {
		cars[carcount] = c; //adding new car object to the car array.
		carcount++;//increasing counter to add new object to the next index of array.
	}
	public void addContract(Contract c) {
		contracts[contractcount] = c; //adding new contract object to the contract array.
		contractcount++;//increasing counter to add new object to the next index of array.
		rentedCar();
		for (int j = 0; j < customercount; j++) { //to define customer as silver, bronze or gold.
			if (c.getContractCustomerId()==customers[j].getCustomerID()) {
				customers[j].setRentCount(customers[j].getRentCount()+1);
				if (customers[j].getRentCount()<3 && customers[j].getRentCount()>=1) {
					customers[j].setType("Bronze");
				}
				else if (customers[j].getRentCount()>=3 && customers[j].getRentCount()<=5) {
					customers[j].setType("Silver");
				}
				else if (customers[j].getRentCount()>5) {
					customers[j].setType("Gold");
				}
			}
		}
	}
	public void addCompany(Company c) {
		companies[companycount] = c; //adding new company object to the company array.
		companycount++;//increasing counter to add new object to the next index of array.
	}

	//--------------------------------------------------------LIST METHODS------------------------------------------------------------------
	public void listOffices() {
		for (int i = 0; i < officecount; i++) {
			System.out.println(offices[i].displayOffice()); //listing the office array in a loop by using display method.
		}
	}
	public void listEmployees() {
		for (int i = 0; i < employeecount; i++) {
			System.out.println(employees[i].displayEmployee()); //listing the employee array in a loop by using display method.
		}
	}
	public void listCustomers() {
		for (int i = 0; i < customercount; i++) {
			System.out.println(customers[i].displayCustomer()); //listing the customer array in a loop by using display method.
		}
	}
	public void listCars() {
		for (int i = 0; i < carcount; i++) {
			System.out.println(cars[i].displayCar()); //listing the car array in a loop by using display method.
		}
	}
	public void listContracts() {
		for (int i = 0; i < contractcount; i++) {
			System.out.println(contracts[i].displayContract()); //listing the contract array in a loop by using display method.
		}
	}	
	public void listCompanies() {
		for (int i = 0; i < companycount; i++) {
			System.out.println(companies[i].displayCompany()); //listing the c array in a loop by using display method.
		}
	}
	
	public void listSilverCustomer() {
		for (int i = 0; i < customercount; i++) {
			if (customers[i].getType().equalsIgnoreCase("Silver")) {
				System.out.println(customers[i].displayCustomer());
			}
		}
	}
	
	public void listAvailableCars() {
		for (int i = 0; i < carcount; i++) {
			if (cars[i].isCarStatues()==true) {
				System.out.println(cars[i].displayCar());
			}
		}
	}
	
	public void increaseSalary() {
		for (int i = 0; i < employeecount; i++) {
			employees[i].setSalary(employees[i].getSalary()+employees[i].getSalary()*1/10);
		}
	}
	
	public void rentedCar() {
		for (int i = 0; i < contractcount; i++) {
			for (int j = 0; j < carcount; j++) {
				if (contracts[i].getCarId().equals(cars[j].getCarID())) {
					cars[j].setRentCount(cars[j].getRentCount()+1);
					cars[j].setCarStatues(false);
				}
			}
		}
	}
	
	public void mostRentedCar() {
		int count = 0;
		String carId = "";
		for (int i = 0; i < carcount; i++) {
			if (cars[i].getRentCount()>count) {
				count = cars[i].getRentCount();
				carId = cars[i].getCarID();
			}
		}
		System.out.println("Most rented car: " + carId);
	}
	
	public void totalIncome() {
		int totalincome = 0;
		for (int i = 0; i < contractcount; i++) {
			totalincome += contracts[i].rentedIncomeSingle();
		}
		listContracts();
		System.out.println();
		System.out.println("Total income is " + totalincome);
	}
}
