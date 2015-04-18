package ui.dlg;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

import com.sun.awt.AWTUtilities;

@SuppressWarnings({ "serial" })
public class InputDialog extends JDialog implements ActionListener{

	
	JButton btn_apply; 
	JButton btn_cancel;
	JFrame frame;
	public InputDialog(JFrame parent){
		super(parent);
		frame = parent;
		btn_apply = new JButton("确定");
		btn_apply.setName("apply");
		btn_apply.addActionListener(this);
		
		
		btn_cancel = new JButton("取消");
		btn_cancel.setName("cancel");
		btn_cancel.addActionListener(this);
		
		
	}
	
	public void resetLocation(){
		if(this.getParent()!=null){
			this.setLocationRelativeTo(this.getParent());
		}
	}
	

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JButton){
			JButton btn = (JButton) e.getSource();
			String name = btn.getName();
			if("apply".equals(name)){
				apply();
			}else if ("cancel".equals(name)){
				dispose();
				AWTUtilities.setWindowOpacity(frame, 1f);
			}
		}
	
	}
	public void apply(){
		
	
	
	}
	
    public static void center(JFrame frame){
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = frame.getWidth();
        int height = frame.getHeight();
        frame.setLocation( (screensize.width - width) / 2,
                      (screensize.height - height) / 2);
    }
    
	public void infoMsg(String msg){
		
		//JOptionPane.showMessageDialog(this, msg, "消息", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void errorMsg(String msg){
	//	JOptionPane.showMessageDialog(this, msg, "错误消息", JOptionPane.ERROR_MESSAGE);
	}
}
