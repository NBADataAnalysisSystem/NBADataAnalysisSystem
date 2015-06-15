package ui.dlg;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.text.DecimalFormat;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class TeamDataPanel extends JPanel {
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
	JTextArea reduceArea;
	String RP;
	String Rfree;
	String Rrebound;
	String conclusion;
	
	public TeamDataPanel(int x,int y,int widthn,int heightn){
		
		this.x = x;
		this.y = y;
		this.width = widthn;
		this.height = heightn;
		this.setBounds(x, y, width, height);
		this.setLayout(null);
		header = new String[]{"名称","命中率","罚球%","场均篮板","胜率"};
		this.getData();
		this.setTable();
		
		this.setLayout(new GridLayout(1,2));
		this.add(sp);
		
		reducePanel = new JPanel();
		reducePanel.setOpaque(false);
		reducePanel.setLayout(new GridLayout(3,1));
		
		double[] temp = new double[30];
		for(int i = 0;i<30;i++){
			temp[i] = countData[i][0];
		}
		RP = this.culculate(temp);
		for(int i = 0;i<30;i++){
			temp[i] = countData[i][1];
		}
		Rfree = this.culculate(temp);
		for(int i = 0;i<30;i++){
			temp[i] = countData[i][2];
		}
		Rrebound = this.culculate(temp);
		JPanel rPanel = new JPanel();
		rPanel.setLayout(new GridLayout(3,1));
		rPanel.setOpaque(false);
		JLabel labelRP = new JLabel("命中率与胜率的相关系数=" + RP);
		JLabel labelRfree = new JLabel("罚球命中率与胜率的相关系数=" + Rfree);
		JLabel labelRrebound = new JLabel("场均篮板与胜率的相关系数=" + Rrebound);
		labelRP.setFont(new Font("宋体",1,height/24));
		labelRfree.setFont(new Font("宋体",1,height/24));
		labelRrebound.setFont(new Font("宋体",1,height/24));
		rPanel.add(labelRP);
		rPanel.add(labelRfree);
		rPanel.add(labelRrebound);
		
		reducePanel.add(rPanel);
		String max;
		if(Double.parseDouble(RP)>Double.parseDouble(Rfree)&&Double.parseDouble(RP)>Double.parseDouble(Rrebound)){
			max = "命中率";
		}else if(Double.parseDouble(Rfree)>Double.parseDouble(RP)&&Double.parseDouble(Rfree)>Double.parseDouble(Rrebound)){
			max = "罚球命中率";
		}else{
			max = "场均篮板";
		}
		reduceArea = new JTextArea();
		reduceArea.setSelectedTextColor(Color.RED);
		reduceArea.setLineWrap(true);        //激活自动换行功能 
		reduceArea.setWrapStyleWord(true);            // 激活断行不断字功能
		reduceArea.setFont(new Font("宋体",1,height/24));
		reduceArea.setText("由此可知，在命中率、罚球命中率、场均篮板中，与球队胜率相关系数的绝对值最接近1的是\n"+max);
		reduceArea.setOpaque(false);
		reducePanel.add(reduceArea);
		
		reducePanel.add(new JPanel());
	
	
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
		sp.setOpaque(false);
		this.revalidate();
		this.repaint();
		
	}

	private String culculate(double factor[]){
		double result = 0;
		int n = factor.length;
		double[] main = new double[30];
//		double aveFactor = 0;
//		double aveMain = 0;
		double sumFactor = 0;
		double sumMain = 0;
		double sumFM = 0;
		double sumSFactor = 0;
		double sumSMain = 0;
		for(int i = 0;i<30;i++){
			main[i] = countData[i][3];
		}
		
		for(int i = 0;i<n;i++){
			sumFM = sumFM + factor[i]*main[i];
		}
		for(int i = 0;i<n;i++){
			sumFactor = sumFactor + factor[i];
		}
	//	  aveFactor = sumFactor/n;
		for(int i = 0;i<n;i++){
			sumMain = sumMain + main[i];
		}
			//aveMain = sumMain/n;
		for(int i = 0;i<n;i++){
			sumSMain = sumSMain + Math.pow(main[i],2);
		}
		for(int i = 0;i<n;i++){
			sumSFactor = sumSFactor + Math.pow(factor[i],2);
		}
		
		result = (n*sumFM - sumFactor*sumMain)/((Math.sqrt(n*sumSFactor - Math.pow(sumFactor, 2)))*(Math.sqrt(n*sumSMain - Math.pow(sumMain, 2))));
		System.out.println(n*sumSFactor - Math.pow(sumFactor, 2));
		return Double.toString(result);
	}
	/**
	 * 获取表格数据
	 * data第一维为球队，第二唯0为球队名，1为球队命中率，2为罚球命中率，3为场均篮板，4为球队胜率
	 */
	private void getData(){
		countData = new double[30][4];
		Random random = new Random();
		data = new String[30][5];
		for(int i = 0;i<30;i++){
			data[i][0] = "test"+i;
			data[i][1] = Double.toString(Math.abs(random.nextDouble())%1); 
			data[i][2] = Double.toString(Math.abs(random.nextDouble())%1); 
			data[i][3]=	Double.toString(Math.abs(random.nextDouble())%1); 
			data[i][4] = Double.toString(Math.abs(random.nextDouble())%1); 
		}
		for(int i =0;i<30;i++){
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
