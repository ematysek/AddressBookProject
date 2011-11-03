package gui;

import java.awt.GridBagConstraints;
import java.awt.Insets;

/**
 * Creates GridBagConstraints objects.
 * 
 * @author Eric Matysek
 * 
 */
public class ConstraintsFactory {

	/**
	 * Get GridBagConstraints using provided fields.
	 * @param gridx Specifies the column for the component.
	 * @param gridy Specifies the row for the component.
	 * @param gridwidth Specifies the number of columns the component will occupy.
	 * @param gridheight Specifies the number of rows the component will occupy.
	 * @param anchor Specifies where to place the component within the display area.
	 * @param insets Specifies the external padding of the component.
	 * @return Returns GridBagConstraints object with specified fields.
	 */
	public static GridBagConstraints getConstraints(int gridx, int gridy,
			int gridwidth, int gridheight, int anchor, Insets insets) {
		GridBagConstraints c = new GridBagConstraints();

		c.insets = insets;
		c.gridx = gridx;
		c.gridy = gridy;
		c.gridwidth = gridwidth;
		c.gridheight = gridheight;
		c.anchor = anchor;
		return c;
	}
	
	/**
	 * Get GridBagConstraints using provided fields including weights.
	 * @param gridx Specifies the column for the component.
	 * @param gridy Specifies the row for the component.
	 * @param gridwidth gridwidth Specifies the number of columns the component will occupy.
	 * @param gridheight gridheight Specifies the number of rows the component will occupy.
	 * @param weightx Specifies how to distribute extra horizontal space.
	 * @param weighty Specifies how to distribute extra vertical space.
	 * @param anchor Specifies where to place the component within the display area.
	 * @param insets insets Specifies the external padding of the component.
	 * @return GridBagConstraints object with specified fields.
	 */
	public static GridBagConstraints getConstraints(int gridx, int gridy,
			int gridwidth, int gridheight, int weightx, int weighty, int anchor, Insets insets) {
		GridBagConstraints c = new GridBagConstraints();

		c.insets = insets;
		c.gridx = gridx;
		c.gridy = gridy;
		c.gridwidth = gridwidth;
		c.gridheight = gridheight;
		c.weightx = weightx;
		c.weighty = weighty;
		c.anchor = anchor;
		return c;
	}

}
