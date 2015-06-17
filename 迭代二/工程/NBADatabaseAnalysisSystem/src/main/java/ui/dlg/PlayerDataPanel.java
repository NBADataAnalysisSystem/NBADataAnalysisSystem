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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import dao.chartdao.ChartDaoJdbcImp;


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
	String result;
	double fone;
	double ffive;
	
	@SuppressWarnings("static-access")
	public PlayerDataPanel(int x,int y,int widthn,int heightn){
		DecimalFormat df = new DecimalFormat("#0.000");
		this.x = x;
		this.y = y;
		this.width = widthn;
		this.height = heightn;
		this.setBounds(x, y, width, height);
		header = new String[]{"前锋","中锋","后卫"};
		this.getData();
		this.setTable();
		
		this.setLayout(new GridLayout(1,2));
		this.add(sp);
		
		result = culculate(countData);
		fone = 4.88;
		ffive = 3.11;
		result = df.format(Double.parseDouble(result));
		reducePanel = new JPanel(new GridLayout(4,1));
		
		JLabel fLabel = new JLabel();
		fLabel.setText("检验统计量为FA = " + result);
		fLabel.setOpaque(false);
		fLabel.setFont(new Font("微软雅黑",1,height/20));
		reducePanel.add(fLabel);
		
		String conclusion;
		JLabel compareLabel = new JLabel();
		if(fone <= Double.parseDouble(result)){
			compareLabel.setText("F0.01≤ FA");
			conclusion = "高度显著差异";
		}else 	if(fone >= Double.parseDouble(result)&&ffive<=Double.parseDouble(result)){
			compareLabel.setText("F0.05≤ FA ≤ F0.01");
			conclusion = "显著差异";
		}else {
			compareLabel.setText("FA≤ F0.05");
			conclusion = "无显著差异";
		}
		compareLabel.setOpaque(false);
		compareLabel.setVerticalAlignment(compareLabel.BOTTOM);
		compareLabel.setFont(new Font("微软雅黑",1,height/12));
		reducePanel.add(compareLabel);
		
		JLabel temp = new JLabel("由此可知，球员位置与其得分有：");
		temp.setFont(new Font("微软雅黑",1,height/20));
		reducePanel.add(temp);
		
		JLabel ss = new JLabel(conclusion);
		ss.setForeground(Color.BLUE);
		ss.setHorizontalAlignment(ss.CENTER);
		ss.setVerticalAlignment(ss.TOP);
		ss.setOpaque(false);
		ss.setFont(new Font("微软雅黑",1,height/10));
		reducePanel.add(ss);
		
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

	private String culculate(double[][] data){
		double result = 0;
		double c=0;
		double qt=0;
		double st=0;
		double qa=0;
		double sa=0;
		double se=0;
		double sumAll = 0;
		double sum[] = new double[3];
		
		for(int i = 0;i<data.length;i++){
			for(int j = 0;j<data[0].length;j++){
				sumAll = sumAll + data[i][j];
			}
		}
		for(int i = 0;i<data[0].length;i++){
			sum[0] = sum[0] + data[0][i];
			sum[1] = sum[1] +data[1][i];
			sum[2] = sum [2] + data[2][i];
		}
		
		c = Math.pow(sumAll, 2)/90;
		for(int i = 0;i<data.length;i++){
			for(int j = 0 ;j<data[0].length;j++){
				qt = qt + Math.pow(data[i][j], 2);
			}
		}
		st = qt  - c;
		for(int i = 0;i<3;i++){
			qa = qa + Math.pow(sum[i], 2);
		}
			qa = qa/30;
		sa = qa -c;
		se = st - sa;
		
		double fa = 2;
		double fe = 87;
		double va = sa/fa;
		double ve = se/fe;
		result = va/ve;
		return Double.toString(result);
	}
	/**
	 * 获取表格数据
	 *data[][].第一维为行，第二唯[0]为前锋，[1]为中锋，[2]为后卫
	 *data[][]储存三种不同位置下，每种30个球员的场均得分的数据，不需要存储名字等信息
	 */
	private void getData(){
		ChartDaoJdbcImp dataImp = new ChartDaoJdbcImp();
		String[][] temp = dataImp.getPlayerScoreAtPosition();
		countData = new double[3][30];
//		Random random = new Random();
		data =temp;
//		for(int i = 0;i<30;i++){
//			data[i][1] = Double.toString(Math.abs(random.nextDouble())*20+10); 
//			data[i][2] = Double.toString(Math.abs(random.nextDouble())*20+10); 
//			data[i][0]=	Double.toString(Math.abs(random.nextDouble())*20+10); 
//		}
		for(int i =0;i<3;i++){
			for(int j = 0;j<30;j++){
				countData[i][j] = Double.parseDouble(data[j][i]);
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

