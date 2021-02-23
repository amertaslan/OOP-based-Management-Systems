
public class Contract {
	private int contractId;
	private static int ID = 1;
	private int contractEmployeeId;
	private int contractCustomerId;
	private String carId;
	private Date pickUpDate;
	private Date dropOffDate;
	private int dailyPrice;
	
	public Contract(int contractCustomerId, int contractEmployeeId, String carId, Date pickUpDate,Date dropOffDate, int dailyPrice) {
		this.contractId = ID++;
		this.contractEmployeeId = contractEmployeeId;
		this.contractCustomerId = contractCustomerId;
		this.carId = carId;
		this.pickUpDate = pickUpDate;
		this.dropOffDate = dropOffDate;
		this.dailyPrice = dailyPrice;
	}

	public int getContractId() {
		return contractId;
	}

	public void setContractId(int contractId) {
		this.contractId = contractId;
	}

	public int getContractEmployeeId() {
		return contractEmployeeId;
	}

	public void setContractEmployeeId(int contractEmployeeId) {
		this.contractEmployeeId = contractEmployeeId;
	}

	public int getContractCustomerId() {
		return contractCustomerId;
	}

	public void setContractCustomerId(int contractCustomerId) {
		this.contractCustomerId = contractCustomerId;
	}

	public String getCarId() {
		return carId;
	}

	public void setCarId(String carId) {
		this.carId = carId;
	}

	public Date getPickUpDate() {
		return pickUpDate;
	}

	public void setPickUpDate(Date pickUpDate) {
		this.pickUpDate = pickUpDate;
	}

	public Date getDropOffDate() {
		return dropOffDate;
	}

	public void setDropOffDate(Date dropOffDate) {
		this.dropOffDate = dropOffDate;
	}

	public int getDailyPrice() {
		return dailyPrice;
	}

	public void setDailyPrice(int dailyPrice) {
		this.dailyPrice = dailyPrice;
	}
	
	public int rentedIncomeSingle() {
		int income = Math.abs(Integer.parseInt(dropOffDate.getDay())-Integer.parseInt(pickUpDate.getDay()))*dailyPrice;
		return income;
	}

	public String displayContract() {
		return "Contract [contractId=" + contractId + ", contractEmployeeId=" + contractEmployeeId
				+ ", contractCustomerId=" + contractCustomerId + ", carId=" + carId + ", pickUpDate=" + pickUpDate.displayDate()
				+ ", dropOffDate=" + dropOffDate.displayDate() + ", dailyPrice=" + dailyPrice + "]";
	}
	
	
}
