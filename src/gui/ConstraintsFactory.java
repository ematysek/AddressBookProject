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

}
