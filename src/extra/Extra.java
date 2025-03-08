package extra;

import java.awt.*;
import javax.swing.*;

public class Extra {
	
	private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	public static int sc_getWidth() {
		return (int) screenSize.getWidth();
	}
	
	public static int sc_getHeight() {
		return (int) screenSize.getHeight();
	}

	
}
