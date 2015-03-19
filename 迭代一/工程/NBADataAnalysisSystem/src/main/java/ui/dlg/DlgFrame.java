package ui.dlg;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class DlgFrame {
	
	public static JFrame rootFrame;
	
    public static void center(JFrame frame){
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = frame.getWidth();
        int height = frame.getHeight();
        frame.setLocation( (screensize.width - width) / 2,
                      (screensize.height - height) / 2);
    }

}
