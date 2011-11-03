package contacts;

import java.util.ArrayList;

/**
 * @author Eric Matysek
 *
 */
public class ContactList {
	
	//TODO DOCUMENTATION!!!

	private ArrayList<Contact> contactList;

	public ContactList(ArrayList<Contact> contactList) {
		this.contactList = contactList;
	}

	public void add(Contact contact) {
		contactList.add(contact);
	}

	public int size() {
		return contactList.size();
	}

	public Contact get(int index) {
		return contactList.get(index);
	}
	
	public void remove(int index) {
		contactList.remove(index);
	}

}
