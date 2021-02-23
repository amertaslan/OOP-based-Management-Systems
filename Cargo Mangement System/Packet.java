
public class Packet {
	private int packetID;
	private static int ID = 1;
	private String sendercustomer;
	private String receivercustomer;
	private String weight;
	private String volume;
	private Date date;
	private int status;
	private int value;
	
	public Packet(String sendercustomer, String receivercustomer, String weight, String volume, Date date) {
		this.packetID = ID++;
		this.sendercustomer = sendercustomer;
		this.receivercustomer = receivercustomer;
		this.weight = weight;
		this.volume = volume;
		this.date = date;
		this.status = 0;
		if (Integer.parseInt(weight)>=1 && Integer.parseInt(weight)<=5) {
			if (volume.equalsIgnoreCase("small")) {
				this.value = 10;
			} 
			else if (volume.equalsIgnoreCase("medium")) {
				this.value = 15;
			}
			else if (volume.equalsIgnoreCase("large")) {
				this.value = 20;
			}
		}
		else if (Integer.parseInt(weight)>=6 && Integer.parseInt(weight)<=10) {
			if (volume.equalsIgnoreCase("small")) {
				this.value = 25;
			} 
			else if (volume.equalsIgnoreCase("medium")) {
				this.value = 30;
			}
			else if (volume.equalsIgnoreCase("large")) {
				this.value = 35;
			}
		}
		else if (Integer.parseInt(weight)>=11) {
			if (volume.equalsIgnoreCase("small")) {
				this.value = 40;
			} 
			else if (volume.equalsIgnoreCase("medium")) {
				this.value = 45;
			}
			else if (volume.equalsIgnoreCase("large")) {
				this.value = 50;
			}
		}
	}

	public int getPacketID() {return packetID;}
	public String getSendercustomer() {return sendercustomer;}
	public String getReceivercustomer() {return receivercustomer;}
	public String getWeight() {return weight;}
	public String getVolume() {return volume;}
	public Date getDate() {return date;}
	public int getStatus() {return status;}
	public int getValue() {return value;}
	
	public void setPacketID(int packetID) {this.packetID = packetID;}
	public void setSendercustomer(String sendercustomer) {this.sendercustomer = sendercustomer;}
	public void setReceivercustomer(String receivercustomer) {this.receivercustomer = receivercustomer;}
	public void setWeight(String weight) {this.weight = weight;}
	public void setVolume(String volume) {this.volume = volume;}
	public void setDate(Date date) {this.date = date;}
	public void setStatus(int status) {this.status = status;}

	public String displayPacket() {
		return "Packet [packetID=" + packetID + ", sendercustomer=" + sendercustomer + ", receivercustomer="
				+ receivercustomer + ", weight=" + weight + ", volume=" + volume + ", date=" + date.displayDate() + "]";
	}	
}
