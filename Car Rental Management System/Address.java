
public class Address {
	private String adress;
	private String town;
	private String city;
	
	public Address(String adress, String town, String city) {
		this.adress = adress;
		this.town = town;
		this.city = city;
	}
	
	public String getAdress() {return adress;}
	public String getTown() {return town;}
	public String getCity() {return city;}
	
	public void setAdress(String adress) {this.adress = adress;}	
	public void setTown(String town) {this.town = town;}
	public void setCity(String city) {this.city = city;}

	public String displayAddress() {
		return adress + ", town=" + town + ", city=" + city;
	}
	
	
}
