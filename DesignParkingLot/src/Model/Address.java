package Model;

public class Address {
    String street;
    String block;
    String city;
    String state;
    String country;
    
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getBlock() {
		return block;
	}
	public void setBlock(String block) {
		this.block = block;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	public Address(String street, String block, String city, String state, String country) {
		super();
		this.street = street;
		this.block = block;
		this.city = city;
		this.state = state;
		this.country = country;
	}
	
	
}
