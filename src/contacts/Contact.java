package contacts;

/**
 * @author Eric Matysek
 * 
 */
public class Contact implements Comparable {

	// TODO DOCUMENTATION!!!

	private String ID;
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private String zip;
	private String homePhone;
	private String cellPhone;
	private String email;

	/**
	 * @param ID
	 * @param firstName
	 *            first name
	 * @param lastName
	 *            last name
	 * @param address
	 *            address
	 * @param city
	 *            city
	 * @param state
	 *            state
	 * @param zip
	 *            zip
	 * @param homePhone
	 *            home phone
	 * @param cellPhone
	 *            cell phone
	 * @param email
	 *            email
	 */
	public Contact(String ID, String firstName, String lastName,
			String address, String city, String state, String zip,
			String homePhone, String cellPhone, String email) {
		this.ID = ID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.homePhone = homePhone;
		this.cellPhone = cellPhone;
		this.email = email;
	}

	/**
	 * @return the iD
	 */
	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city
	 *            the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the zip
	 */
	public String getZip() {
		return zip;
	}

	/**
	 * @param zip
	 *            the zip to set
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}

	/**
	 * @return the homePhone
	 */
	public String getHomePhone() {
		return homePhone;
	}

	/**
	 * @param homePhone
	 *            the homePhone to set
	 */
	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	/**
	 * @return the cellPhone
	 */
	public String getCellPhone() {
		return cellPhone;
	}

	/**
	 * @param cellPhone
	 *            the cellPhone to set
	 */
	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	public String getNodeString() {
		String nodeString;
		if (this.lastName.equals("")) {
			nodeString = this.firstName;
		} else {
			nodeString = (this.lastName + ", " + this.firstName);
		}
		return nodeString;
	}

	@Override
	public String toString() {
		return (this.firstName + " " + this.lastName);
	}

	@Override
	public int compareTo(Object obj) {
		Contact c = (Contact) obj;
		return this.lastName.compareToIgnoreCase(c.lastName);
	}

	public boolean equals(Contact c) {
		if (!ID.equals(c.getID())) {
			return false;
		}
		if (!firstName.equals(c.getFirstName())) {
			return false;
		}
		if (!lastName.equals(c.getLastName())) {
			return false;
		}
		if (!address.equals(c.getAddress())) {
			return false;
		}
		if (!city.equals(c.getCity())) {
			return false;
		}
		if (!state.equals(c.getState())) {
			return false;
		}
		if (!zip.equals(c.getZip())) {
			return false;
		}
		if (!homePhone.equals(c.getHomePhone())) {
			return false;
		}
		if (!cellPhone.equals(c.getCellPhone())) {
			return false;
		}
		if (!email.equals(c.getEmail())) {
			return false;
		}

		return true;
	}

}
