
public class DECarTest {
	public static void main(String[] args) {
		DECarManagement Company = new DECarManagement();
		Date ed1 = new Date("10","4","1990");
		Address ea1 = new Address("Buca", "Karþþýyaka", "Ýzmir");
		Phone ep1 = new Phone("+90","541","3348989");
		Employee e1 = new Employee("Arif", ed1, "Male", ea1, ep1);
		
		Date ed2 = new Date("10","4","1990");
		Address ea2 = new Address("Buca", "Karþþýyaka", "Ýzmir");
		Phone ep2 = new Phone("+90","541","3348989");
		Employee e2 = new Employee("Ayberk", ed2, "Male", ea2, ep2);
		
		Date ed3 = new Date("10","4","1990");
		Address ea3 = new Address("Buca", "Karþþýyaka", "Ýzmir");
		Phone ep3 = new Phone("+90","541","3348989");
		Employee e3 = new Employee("Hazar", ed3, "Male", ea3, ep3);
		
		Date ed4 = new Date("10","4","1990");
		Address ea4 = new Address("Buca", "Karþþýyaka", "Ýzmir");
		Phone ep4 = new Phone("+90","541","3348989");
		Employee e4 = new Employee("Mumcuh", ed4, "Male", ea4, ep4);
		
		Company.addEmployee(e1);
		Company.addEmployee(e2);
		Company.addEmployee(e3);
		Company.addEmployee(e4);
		
		Car c1 = new Car("35AC3546", "Toyota", "Corolla", "Grey");
		Car c2 = new Car("35AC3547", "Toyota", "Yaris", "Red");
		Car c3 = new Car("35AC3548", "Toyota", "Morolla", "Pink");
		
		Company.addCar(c1);
		Company.addCar(c2);
		Company.addCar(c3);
		
		Date cd1 = new Date("10","4","1990");
		Address ca1 = new Address("Buca", "Karþþýyaka", "Ýzmir");
		Phone cp1 = new Phone("+90","541","3348989");
		Customer cu1 = new Customer("Arif", cd1, "Male", ca1, cp1);
		
		Date cd2 = new Date("10","4","1990");
		Address ca2 = new Address("Buca", "Ankara", "Ýzmir");
		Phone cp2 = new Phone("+90","541","3397989");
		Customer cu2 = new Customer("Ayberk", cd2, "Female", ca2, cp2);
		
		Date cd3 = new Date("10","4","1990");
		Address ca3 = new Address("Buca", "Karþþýyaka", "Ýzmir");
		Phone cp3 = new Phone("+90","541","3346089");
		Customer cu3 = new Customer("Hasan", cd3, "Male", ca3, cp3);
		
		Company.addCustomer(cu1);
		Company.addCustomer(cu2);
		Company.addCustomer(cu3);
		
		Date pickup1 = new Date("10","4","2019");
		Date dropoff1 = new Date("11","4","2019");
		Contract cont1 = new Contract(1, 1, "35AC3546", pickup1, dropoff1, 100);
		
		Date pickup2 = new Date("10","4","2019");
		Date dropoff2 = new Date("11","4","2019");
		Contract cont2 = new Contract(1, 2, "35AC3547", pickup2, dropoff2, 200);
		
		Date pickup3 = new Date("15","4","2019");
		Date dropoff3 = new Date("18","4","2019");
		Contract cont3 = new Contract(3, 2, "35AC3546", pickup3, dropoff3, 100);
		
		Date pickup4 = new Date("20","4","2019");
		Date dropoff4 = new Date("21","4","2019");
		Contract cont4 = new Contract(1, 2, "35AC3547", pickup4, dropoff4, 200);
		
		Date pickup5 = new Date("27","4","2019");
		Date dropoff5 = new Date("28","4","2019");
		Contract cont5= new Contract(1, 2, "35AC3546", pickup5, dropoff5, 100);
		
		Company.addContract(cont1);
		Company.addContract(cont2);
		Company.addContract(cont3);
		Company.addContract(cont4);
		Company.addContract(cont5);
		
		Company.listCars();
		System.out.println();
		Company.listCustomers();
		System.out.println();
		Company.listContracts();
		System.out.println();
		Company.listEmployees();
		System.out.println();
		
		Company.increaseSalary();
		System.out.println("Salaries were increased.");
		
		Company.listAvailableCars();
		System.out.println();
		Company.listSilverCustomer();
		System.out.println();
		
		Company.totalIncome();
		System.out.println();
		Company.mostRentedCar();
	}
}
