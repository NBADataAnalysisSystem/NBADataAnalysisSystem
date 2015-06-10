package ui.dlg;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieToolTipGenerator;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;

@SuppressWarnings("serial")
public class TeamChartPanel extends JPanel {
	
	int x;
	int y;
	int width;
	int height;
	JFreeChart chart;
	ChartPanel chartPanel;
	
	public TeamChartPanel(int x,int y,int width,int height,String[][] data){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		this.createChart(data);
		chartPanel = new ChartPanel(chart);
		this.setBounds(x, y, width, height);
		this.setLayout(null);
		
		chartPanel.setBounds(x, y, width, height/2);
		this.add(chartPanel);
		
		chartPanel.setOpaque(false);
		this.setOpaque(false);
		this.setVisible(true);
		
	}
	
    public static DefaultPieDataset createDataset(String[][] data) //创建柱状图数据集
    {
    	DefaultPieDataset  dataset=new DefaultPieDataset ();
        //TODO 暂时先放着，用模拟的数据
        for(int i = 0;i<data.length;i++){
        	dataset.setValue(data[i][0],Double.parseDouble(data[i][1]));
        }
//        dataset.setValue(10,lineSeries,"2011");
//        dataset.setValue(20,lineSeries,"2012");
//        dataset.setValue(40,lineSeries,"2013");
//        dataset.setValue(15,lineSeries,"2014");
//        dataset.setValue(15,lineSeries,"2015");
        return dataset;
    }
    
    @SuppressWarnings("static-access")
	public void createChart(String[][] data) {
    	chart = ChartFactory.createPieChart3D(null, this.createDataset(data), true, false, false);  
        chart.setBackgroundPaint(null);  
        // 图片背景色  
     //   chart.setBackgroundPaint(Color.white);  
        // 设置标题文字  
        // 取得饼图plot对象  
        // PiePlot plot = (PiePlot) chart.getPlot();  
        // 取得3D饼图对象  
        PiePlot3D plot = (PiePlot3D) chart.getPlot();  
        plot.setBackgroundAlpha(0.0f);
        // 图形边框颜色  
        plot.setBaseSectionOutlinePaint(Color.RED);  
        // plot.setBaseSectionPaint(Color.WHITE);  
        // 图形边框粗细  
        plot.setBaseSectionOutlineStroke(new BasicStroke(1.0f));  
  
        // 指定图片的透明度(0.0-1.0)  
        plot.setForegroundAlpha(0.65f);  
        // 指定显示的饼图上圆形(false)还椭圆形(true)  
        plot.setCircular(true);  
  
        // 设置第一个 饼块section 的开始位置，默认是12点钟方向  
        plot.setStartAngle(360);  
        // 设置鼠标悬停提示  
        plot.setToolTipGenerator(new StandardPieToolTipGenerator());  
  
        // 设置突出显示的数据块  
        plot.setExplodePercent("One", 0.1D);  
        // 设置饼图各部分标签字体  
        plot.setLabelFont(new Font("宋体", Font.ITALIC, 20));  
        // 设置分饼颜色  
//        plot.setSectionPaint(0, new Color(244, 194, 144));  
        // plot.setSectionPaint("2", new Color(144, 233, 144));  
        // 设置图例说明Legend上的文字  
        chart.getLegend().setItemFont(new Font("宋体", Font.PLAIN, 30));  

 }
//	
	public static void main(String [] args){
		String[][] testString = new String[20][2];
		for(int i = 0;i<20;i++){
			testString[i][0] = i+"";
			testString[i][1]=i+"";
		}
	JFrame test = new JFrame();
	test.setSize(600, 700);
	test.setUndecorated(true);
	TeamChartPanel panel = new TeamChartPanel(0,0,600,700,testString);
	panel.setBackground(Color.decode("#FF0000"));
	panel.setForeground(Color.decode("#FF0000"));
	test.add(panel);
	test.setVisible(true);
	


	}

}

