import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class DECargoManagament {
	//necessary array for program and count variables to use add methods.
	private Office[] offices;
	private Employee[] employees;
	private Customer[] customers;
	private Packet[] packets;
	private int officecount;
	private int employeecount;
	private int customercount;
	private int packetcount;
	
	public DECargoManagament() throws IOException {
		//creating arrays with 150 index.
		this.offices = new Office[150];
		this.employees = new Employee[150];
		this.customers = new Customer[150];
		this.packets = new Packet[150];
		this.officecount = 0;
		this.employeecount = 0;
		this.customercount = 0;
		this.packetcount = 0;
		
		loadFile();
	}
	
	//--------------------------------------------------------LOAD FILE METHOD---------------------------------------------------------------
	public void loadFile() throws IOException {
		//objects variables to create objects with classes.
		Office o;
		Employee e;
		Customer c;
		Packet p;
		String str3, str1, str2; //used to substring methods of phone number.
		//input file reading.
		Path path = Paths.get("input.txt");
		@SuppressWarnings("resource")
		Scanner input = new Scanner(path);
		int i = 0; //used to give wrong command input error at lines as line number by increasing at loop.
		do {
			i++;
			String[] words = input.nextLine().split(";", -1); //to split the lines by ";".
			
			if (words[0].equalsIgnoreCase("addoffice")) {
				System.out.println("Office had been added.");
				str1 = words[5].substring(0, 3);
				str2 = words[5].substring(3, 6);
				str3 = words[5].substring(6);
				Phone phone = new Phone(str1, str2, str3); //creating a new phone object by substring the input of the phone to send to create a new office object.
				Address address = new Address(words[2], words[3], words[4]);//creating a new address object to send to create a new office object.
				o = new Office(words[1], address, phone); //creating office object.
				addOffice(o);//sending new office object to add offices array.
			}
			else if (words[0].equalsIgnoreCase("listoffices")) {
				System.out.println("The list of offices................................ ");
				listOffices(); //working when the list offices command given.
			}
			else if (words[0].equalsIgnoreCase("addemployee")) {
				for (int j = 0; j < officecount; j++) {
					if (offices[j].getOfficeID() == Integer.parseInt(words[1])) {
						System.out.println("Employee had been added.");
						String[] splitDate = words[4].split("/"); //to split date by "/" to create a new date object.
						Date date = new Date(splitDate[0], splitDate[1], splitDate[2]); //creating new date object by using split command.			
						str1 = words[9].substring(0, 3);
						str2 = words[9].substring(3, 6);
						str3 = words[9].substring(6);
						Phone phone = new Phone(str1, str2, str3);//creating a new phone object by substring the input of the phone to send create a new employee object.
						Address address = new Address(words[6], words[7], words[8]);//creating a new address object to send to create a new employee object.
						e = new Employee(Integer.parseInt(words[1]), words[2], words[3], date, words[5], address, phone);//creating employee object.
						addEmployee(e);//sending new employee object to add employees array.
					}
				}	
			}
			else if (words[0].equalsIgnoreCase("listemployees")) {
				System.out.println("The list of employees.............................. ");
				listEmployees();//working when the list employees command given.
			}
			else if (words[0].equalsIgnoreCase("addcustomer")) {
				System.out.println("Customer had been added.");
				String[] splitDate = words[2].split("/");
				Date date = new Date(splitDate[0], splitDate[1], splitDate[2]);
				str1 = words[8].substring(0, 3);
				str2 = words[8].substring(3, 6);
				str3 = words[8].substring(6);
				Phone phone = new Phone(str1, str2, str3);//creating a new phone object by substring the input of the phone to send create a new customer object.
				Address address = new Address(words[5], words[6], words[7]);//creating a new address object to send to create a new employee object.
				c = new Customer(words[1], date, words[3], words[4], address, phone);
				addCustomer(c);//sending new customer object to add customers array.
			}
			else if (words[0].equalsIgnoreCase("listcustomers")) {
				System.out.println("The list of customers.............................. ");
				listCustomers();//working when the list customers command given.
			}
			else if (words[0].equalsIgnoreCase("addpacket")) {
				if (Integer.parseInt(words[1])>customercount || Integer.parseInt(words[1])<1 || Integer.parseInt(words[2])>customercount || Integer.parseInt(words[2])<1) {
					System.out.println("Invalid sender or receiver customer ID. Could not added.");//giving an error massage when an invalid id given in text file.
				} 
				else {
					System.out.println("Packet had been added.");
					String[] splitDate = words[5].split("/");
					Date date = new Date(splitDate[0], splitDate[1], splitDate[2]);
					p = new Packet(words[1], words[2], words[3], words[4], date);//creating a new phone object by substring the input of the phone to send create a new packet object.
					addPacket(p);//sending new packet object to add packets array.
				}
			}
			else if (words[0].equalsIgnoreCase("listpackets")) {
				System.out.println("The list of packets................................ ");
				listPackets();//working when the list packets command given.
			}
			else if (words[0].equalsIgnoreCase("deletecustomer")) {
				if (Integer.parseInt(words[1])>customercount+1 || Integer.parseInt(words[1])<1) {
					System.out.println("Invalid customer ID. Could not deleted.");//giving an error massage when the wrong id given.
				} 
				else {
					deleteCustomer(words[1]);//deleting customer by sending its id to the method.
					System.out.println("Customer had been deleted.");	
				}
			}
			else if (words[0].equalsIgnoreCase("deleteemployee")) {
				
				if (Integer.parseInt(words[1])>employeecount+1 || Integer.parseInt(words[1])<1) {
					System.out.println("Invalid employee ID. Could not deleted.");//giving an error massage when the wrong id given.
				}
				else {
					deleteEmployee(words[1]);//deleting employee by sending its id to the method.
					System.out.println("Employee had been deleted.");	
				}
			}
			else if (words[0].equalsIgnoreCase("updateoffice")) {
				if (Integer.parseInt(words[1])>officecount+1 || Integer.parseInt(words[1])<1) {
					System.out.println("Invalid office ID. Could not updated.");//giving an error massage when the wrong id given.
				} 
				else {
					str1 = words[6].substring(0, 3);
					str2 = words[6].substring(3, 6);
					str3 = words[6].substring(6);
					Phone phone = new Phone(str1, str2, str3);
					Address address = new Address(words[3], words[4], words[5]);
					updateOffice(words, phone, address);//updating office by sending words array and phone, address to the method.
					System.out.println("Office had been updated.");	
				}
			}
			else if (words[0].equalsIgnoreCase("updateemployee")) {
				if (Integer.parseInt(words[1])>employeecount+1 || Integer.parseInt(words[1])<1) {
					System.out.println("Invalid employee ID. Could not updated.");//giving an error massage when the wrong id given.
				} 
				else {
					String[] splitDate = words[5].split("/");
					Date date = new Date(splitDate[0], splitDate[1], splitDate[2]);				
					str1 = words[10].substring(0, 3);
					str2 = words[10].substring(3, 6);
					str3 = words[10].substring(6);
					Phone phone = new Phone(str1, str2, str3);
					Address address = new Address(words[7], words[8], words[9]);
					updateEmployee(words, date, phone, address);//updating employee by sending words array and date, phone address object to the method.
					System.out.println("Employee had been updated.");
				}				
			}
			else if (words[0].equalsIgnoreCase("updatecustomer")) {
				if (Integer.parseInt(words[1])>customercount+1 || Integer.parseInt(words[1])<1) {
					System.out.println("Invalid customer ID. Could not updated.");//giving an error massage when the wrong id given.
				} 
				else {
					String[] splitDate = words[3].split("/");
					Date date = new Date(splitDate[0], splitDate[1], splitDate[2]);				
					str1 = words[9].substring(0, 3);
					str2 = words[9].substring(3, 6);
					str3 = words[9].substring(6);
					Phone phone = new Phone(str1, str2, str3);
					Address address = new Address(words[6], words[7], words[8]);
					updateCustomer(words, date, phone, address);//updating customer by sending words array and date, phone address object to the method.
					System.out.println("Customer had been updated.");
				}
			}
			else if (words[0].equalsIgnoreCase("updatepacket")) {
				if (Integer.parseInt(words[1])>packetcount+1 || Integer.parseInt(words[1])<1) {
					System.out.println("Invalid packet ID. Could not updated.");//giving an error massage when the wrong id given.
				} 
				else {
					String[] splitDate = words[6].split("/");
					Date date = new Date(splitDate[0], splitDate[1], splitDate[2]);
					updatePacket(words, date);//updating packet by sending words array and date object to the method.
					System.out.println("Packet had been updated.");
				}
			}
			else if (words[0].equalsIgnoreCase("increasesalaries")) {
				increaseSalary();//to increase salary when the command given.
				System.out.println("Salaries were increased.");
			}
			else if (words[0].equalsIgnoreCase("deliverpacket")) {
				deliverPacketStatus(words); //to change the status of packet as "1" when its delivered.
				System.out.println("Packet has delivered.");
			}
			else if (words[0].equalsIgnoreCase("losspacket")) {
				lostPacketStatus(words);//to change the status of packet as "2" when its lost.
				System.out.println("Packet has lost.");
			}
			else if (words[0].equalsIgnoreCase("trackpacket")) {
				System.out.println("Packet status:"); //to show the status of packet with its id.
				trackPacketStatus(words);
			}
			else if (words[0].equalsIgnoreCase("top3customers")) {
				countSenderCustomer(); //counting sender customer by its id to find top three customer.
				System.out.println("TOP 3 Customers: ");
				topThreeCustomers(); //listing top three customers by using sender customer count.
			}
			else if (words[0].equalsIgnoreCase("totalincome")) {
				int value = 0;
				System.out.println("Total income of company is " + totalIncome(value) + " TL");			
			}
			else if (words[0].equalsIgnoreCase("search")) {
				System.out.println("Search result(s)...");
				search(words);
			}
			else {
				System.out.println("Wrong command at " + i + ". line!!!"); //to give an error massage when a wrong command given at file.
			}
		} while (input.hasNextLine());
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
	public void addPacket(Packet p) {
		packets[packetcount] = p;//adding new office packet to the office array.
		packetcount++;//increasing counter to add new object to the next index of array.
	}
	
	//--------------------------------------------------------LIST METHODS------------------------------------------------------------------
	public void listOffices() {
		for (int i = 0; i < officecount; i++) {
			System.out.println(offices[i].displayOffice()); //listing the office array in a loop by using display method.
		}
	}
	public void listEmployees() {
		for (int i = 0; i < employeecount; i++) {
			if (employees[i].getActiveStatus() == true) {
				System.out.println(employees[i].displayEmployee());//listing the employee array in a loop by using display method.
			}
;		}
	}	
	public void listCustomers() {
		for (int i = 0; i < customercount; i++) {
			if (customers[i].getActiveStatus() == true) {
				System.out.println(customers[i].displayCustomer());//listing the customer array in a loop by using display method.
			}
		}
	}
	public void listPackets() {
		for (int i = 0; i < packetcount; i++) {
			System.out.println(packets[i].displayPacket());//listing the packet array in a loop by using display method.
		}
	}
	
	//--------------------------------------------------------DELETE METHODS----------------------------------------------------------------
	public void deleteCustomer(String s) {
		for (int i = 0; i < customercount; i++) {
			if (customers[i].getCustomerID() == Integer.parseInt(s)) {
				customers[i].setActiveStatus(false); //changing the status of customer as false to do not use it anymore.
			}
		}
	}	
	public void deleteEmployee(String s) {
		for (int i = 0; i < employeecount; i++) {
			if (employees[i].getEmployeeID() == Integer.parseInt(s)) {
				employees[i].setActiveStatus(false); //changing the status of customer as false to do not use it anymore.
			}
		}
	}
	
	//--------------------------------------------------------UPDATE METHODS----------------------------------------------------------------
	public void updateOffice(String[] words, Phone phone, Address address) {
		for (int i = 0; i < officecount; i++) {
			if (offices[i].getOfficeID() == Integer.parseInt(words[1])) {
				offices[i].setName(words[2]);
				offices[i].setAddress(address);
				offices[i].setPhone(phone);
			}
		}
	}
	public void updateEmployee(String[] words, Date date, Phone phone, Address address) {
		for (int i = 0; i < employeecount; i++) {
			if (employees[i].getEmployeeID() == Integer.parseInt(words[1])) {
				employees[i].setEmployeeofficenum(Integer.parseInt(words[2]));
				employees[i].setType(words[3]);
				employees[i].setName(words[4]);
				employees[i].setBirthdate(date);
				employees[i].setGender(words[6]);
				employees[i].setAdress(address);
				employees[i].setPhone(phone);
			}
		}
	}
	public void updateCustomer(String[] words, Date date, Phone phone, Address address) {
		for (int i = 0; i < customercount; i++) {
			if (customers[i].getCustomerID() == Integer.parseInt(words[1])) {
				customers[i].setName(words[2]);
				customers[i].setBirthdate(date);
				customers[i].setGender(words[4]);
				customers[i].setEmail(words[5]);
				customers[i].setAdress(address);
				customers[i].setPhone(phone);
			}
		}
	}
	public void updatePacket(String[] words, Date date) {
		for (int i = 0; i < packetcount; i++) {
			if (packets[i].getPacketID() == Integer.parseInt(words[1])) {
				packets[i].setSendercustomer(words[2]);
				packets[i].setReceivercustomer(words[3]);
				packets[i].setWeight(words[4]);
				packets[i].setVolume(words[5]);
				packets[i].setDate(date);
			}
		}
	}
	
	//-------------------------------------------------------INCREASE SALARY METHOD-------------------------------------------------------------
	public void increaseSalary() {
		double increasedSalary = 0d;
		for (int i = 0; i < employeecount; i++) {			
			increasedSalary = employees[i].getSalary() + employees[i].getSalary()/10;
			employees[i].setSalary(increasedSalary);			
		}
	}
	
	//---------------------------------------------PACKET METHODS(DELIVER, LOSS, TRACK)---------------------------------------------------------
	public void deliverPacketStatus(String[] words) {
		for (int i = 0; i < packetcount; i++) {
			if (packets[i].getPacketID() == Integer.parseInt(words[1])) {
				for (int j = 0; j < employeecount; j++) {
					if (employees[j].getEmployeeID() == Integer.parseInt(words[2]) && employees[j].getActiveStatus()==true) {
						packets[i].setStatus(1);
					}
				}
			}
		}
		
	}	
	public void lostPacketStatus(String[] words) {
		for (int i = 0; i < packetcount; i++) {
			if (packets[i].getPacketID() == Integer.parseInt(words[1])) {
				for (int j = 0; j < employeecount; j++) {
					if (employees[j].getEmployeeID() == Integer.parseInt(words[2]) && employees[j].getActiveStatus()==true) {
						packets[i].setStatus(2);
						int losscounter = employees[j].getLosscount() + 1;
						employees[j].setLosscount(losscounter);
					}
					if (employees[j].getLosscount() >= 3) {
						deleteEmployee(words[2]);
					}
				}
			}
		}
	}
	public void trackPacketStatus(String[] words) {
		for (int i = 0; i < packetcount; i++) {
			if (packets[i].getPacketID() == Integer.parseInt(words[1])) {
				System.out.print(packets[i].displayPacket() + " [Packet Status= " + packets[i].getStatus() + "]");
				if (packets[i].getStatus() == 0) {
					System.out.println(" Packet added.");
				} 
				else if (packets[i].getStatus() == 1) {
					System.out.println(" Packet delivered.");
				}
				else if (packets[i].getStatus() == 2) {
					System.out.println(" Packet lost.");
				}
			}
		}
	}
	
	//--------------------------------------------------------TOP3 CUSTOMER METHOD--------------------------------------------------------------
	public void countSenderCustomer() {
		for (int i = 0; i < packetcount; i++) {
			for (int j = 0; j < customercount; j++) {
				if (customers[j].getCustomerID() == Integer.parseInt(packets[i].getSendercustomer())) {
					int sendercount = customers[j].getSendercustomercount()+1;
					customers[j].setSendercustomercount(sendercount);
				}
			}	
		}
	}	
	public void topThreeCustomers() {
		Customer tempcustomer; //bubble sort of customers by posted packet value.
		for(int i = 0; i < customercount; i++){  
			for(int j = 1; j < (customercount-i); j++){  
				if(customers[j-1].getSendercustomercount() < customers[j].getSendercustomercount()){  
                      tempcustomer = customers[j-1];  
                      customers[j-1] = customers[j];  
                      customers[j] = tempcustomer;  
				}                
			}  
		}
		int top3counter = 3;
		for (int i = 0; i < top3counter; i++) {
			if (customers[i].getActiveStatus() == false) {
				top3counter++;
			}
			else {
				System.out.println(customers[i].getName());
			}		
		}
	}
	
	//--------------------------------------------------------TOTAL INCOME METHOD---------------------------------------------------------------
	public int totalIncome(int value) {		
		for (int i = 0; i < packetcount; i++) {
			value += packets[i].getValue();
		}
		return value;
	}
	
	//--------------------------------------------------------- SEARCH METHOD-------------------------------------------------------------------
	public void search(String[] words) {
		String[] newwords = null;
		if (!(words[4].equals(null))) {
			newwords = words[4].split("-");//splitting the minimum - maximum weight value to use condition statement. 
		}		
		for (int i = 0; i < packetcount; i++) {
			if (words[3].equals("") || packets[i].getStatus() == Integer.parseInt(words[3])) {
				if (words[5].equals("") || packets[i].getVolume().equals(words[5])) {
					if (words[4].equals("") || (Integer.parseInt(packets[i].getWeight()) >= Integer.parseInt(newwords[1]) && Integer.parseInt(packets[i].getWeight()) <= Integer.parseInt(newwords[2]))) {
						for (int j = 0; j < customercount; j++) {
							String fromCity = "";
							String toCity = "";
							if (customers[j].getCustomerID() == Integer.parseInt(packets[i].getSendercustomer())) {
								fromCity = customers[j].getAddress().getCity();
							}
							if (customers[j].getCustomerID() == Integer.parseInt(packets[i].getReceivercustomer())) {
								toCity = customers[j].getAddress().getCity();
							}
							if (words[1].equals("") || fromCity.equals(words[1])) {
								if (words[1].equals("") || toCity.equals(words[2])) {
									String statusofPacket = "";
									if (packets[i].getStatus() == 0) {
										statusofPacket = "Added";
									}
									else if (packets[i].getStatus() == 1) {
										statusofPacket = "Delivered";
									}
									else if (packets[i].getStatus() == 2) {
										statusofPacket = "Lost";
									}
									System.out.println(packets[i].getPacketID() + ". " + packets[i].displayPacket() + " Status= " + statusofPacket);
									break;
								}
							}
						}
					}
				}
			}
		}
	}
}
