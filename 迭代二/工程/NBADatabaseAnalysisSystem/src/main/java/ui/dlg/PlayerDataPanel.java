package ui.dlg;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


@SuppressWarnings("serial")
public class PlayerDataPanel extends JPanel {
	int x;
	int y;
	int width;
	int height;
	String data[][];
	double countData[][];
	JTable table ;
	String header[];
	JScrollPane sp;
	JPanel reducePanel;
	
	
	public PlayerDataPanel(int x,int y,int widthn,int heightn){
		
		this.x = x;
		this.y = y;
		this.width = widthn;
		this.height = heightn;
		this.setBounds(x, y, width, height);
		header = new String[]{"名称","命中率","罚球%","场均篮板","胜率"};
		this.getData();
		this.setTable();
		
		this.setLayout(new GridLayout(1,2));
		this.add(sp);
		reducePanel = new JPanel();
		reducePanel.setOpaque(false);
		this.add(reducePanel);
		this.setOpaque(false);
		
	}

	private void setTable(){
		DefaultTableModel model = new DefaultTableModel(data,header) ;
		JTable table = new JTable(model);
		
		MyTableCellRenderrer render = new MyTableCellRenderrer();
		//	render.setOpaque(false); 
	     
	    table.setDefaultRenderer(Object.class,render);  
		table.setEnabled(false);
		table.setGridColor(Color.decode("#D1EEEE"));
		
		sp = new JScrollPane(table);
		//sp.setOpaque(false);
		this.revalidate();
		this.repaint();
		
	}

	/**
	 * 获取表格数据
	 * data第一维为球队，第二唯0为球队名，1为球队命中率，2为罚球命中率，3为场均篮板，4为球队胜率
	 */
	private void getData(){
		countData = new double[50][4];
		Random random = new Random();
		data = new String[50][5];
		for(int i = 0;i<50;i++){
			data[i][0] = "test"+i;
			data[i][1] = Double.toString(Math.abs(random.nextDouble())%1); 
			data[i][2] = Double.toString(Math.abs(random.nextDouble())%1); 
			data[i][3]=	Double.toString(Math.abs(random.nextDouble())%1); 
			data[i][4] = Double.toString(Math.abs(random.nextDouble())%1); 
		}
		for(int i =0;i<50;i++){
			for(int j = 0;j<4;j++){
				countData[i][j] = Double.parseDouble(data[i][j+1]);
			}
		}
		
	}
	
	class MyTableCellRenderrer extends DefaultTableCellRenderer{
        
        @Override
        public Component getTableCellRendererComponent(JTable table,
                Object value, boolean isSelected, boolean hasFocus, int row,
                int column)
        {
            // TODO Auto-generated method stub
            Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
//            if(row == 0){
//           	 comp.setBackground(Color.GRAY);
//            }else
           	 if(row%2 ==1){
           	// ((JComponent) comp).setOpaque(false);
           	 
           	  comp.setBackground(Color.decode("#D1EEEE"));
            }else if(row%2 ==0 ){
          	  comp.setBackground(Color.white);
           }
            return comp;
        }
}
	JFrame frame;
	public void setFatherFrame(JFrame frame){
		this.frame = frame;
	}
}

