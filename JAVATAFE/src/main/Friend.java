package main;

public class Friend {
	String name, street, suburb, postcode, phone;

	// This method is a constructor…
	public Friend() {
		name = "New Friend";
	}

	// This method is also a constructor…
	public Friend(String str) {
		name = str;
	}

	public void setName(String str) {
		name = str;
	}

	public String getName() {
		return name;
	}

	public void setAddress(String _street, String _suburb, String _postcode) {
		street = _street;
		suburb = _suburb;
		postcode = _postcode;
	}

	public String getStreet() {
		return street;
	}

}
