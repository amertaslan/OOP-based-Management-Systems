
public class Car {
	private String carID;
	private String carBrand;
	private String carModel;
	private String carColor;
	private int rentCount;
	private boolean carStatues;
	
	public Car(String carID, String carBrand, String carModel, String carColor) {
		this.carID = carID;
		this.carBrand = carBrand;
		this.carModel = carModel;
		this.carColor = carColor;
		this.rentCount = 0;
		this.carStatues = true;
	}

	public String getCarID() {
		return carID;
	}

	public void setCarID(String carID) {
		this.carID = carID;
	}

	public String getCarBrand() {
		return carBrand;
	}

	public void setCarBrand(String carBrand) {
		this.carBrand = carBrand;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public String getCarColor() {
		return carColor;
	}

	public void setCarColor(String carColor) {
		this.carColor = carColor;
	}

	public int getRentCount() {
		return rentCount;
	}

	public void setRentCount(int rentCount) {
		this.rentCount = rentCount;
	}

	public boolean isCarStatues() {
		return carStatues;
	}

	public void setCarStatues(boolean carStatues) {
		this.carStatues = carStatues;
	}

	public String displayCar() {
		return "Car [carID=" + carID + ", carBrand=" + carBrand + ", carModel=" + carModel + ", carColor=" + carColor
				+ ", rentCount=" + rentCount + ", carStatues=" + carStatues + "]";
	}
	
	
}
