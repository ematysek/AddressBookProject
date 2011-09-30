package gui.panels.contactlist;

import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;

/**
 * Class that defines a text field that can only contain a specific number of
 * characters.
 * 
 * @author Eric Matysek
 * 
 */
public class FixedTextField extends JTextField {

	/**
	 * Constructs a new text field with a maximum number of characters.
	 * 
	 * @param length
	 *            Maximum number of characters to allow in the text field.
	 */
	public FixedTextField(int length) {
		super(new FixedPlainDocument(length), "", length);
	}

}

class FixedPlainDocument extends PlainDocument {

	private int maxLength;

	/**
	 * Constructs a new plain document with a maximum number of characters.
	 * 
	 * @param maxLength
	 */
	FixedPlainDocument(int maxLength) {
		this.maxLength = maxLength;
	}

	// This is the method used to insert a string to a Plain Document.
	public void insertString(int offset, String str, AttributeSet a)
			throws BadLocationException {

		// If the current length of the string
		// + the length of the string about to be entered
		// (through typing or copy and paste)
		// is less than the maximum length passed as an argument..
		// We call the Plain Document method insertString.
		// If it isn't, the string is not entered.

		if (!((getLength() + str.length()) > maxLength)) {
			super.insertString(offset, str, a);
		}
	}
}
