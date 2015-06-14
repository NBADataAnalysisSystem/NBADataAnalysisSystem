package ui.dlg;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

@SuppressWarnings("serial")
public class TeamBarChartPanel extends JPanel {


	
	int x;
	int y;
	int width;
	int height;
	JFreeChart chart;
	ChartPanel chartPanel;
	
	public TeamBarChartPanel(int x,int y,int width,int height,String[][] data){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		this.createChart(data);
		chartPanel = new ChartPanel(chart);
		this.setBounds(x, y, width, height);
		this.setLayout(null);
		
		chartPanel.setBounds(0, 0, width, height);
		this.add(chartPanel);
		
		chartPanel.setOpaque(false);
		this.setOpaque(false);
		this.setVisible(true);
		
	}
	/**
	 * 
	 * @param data为要显示的值，data[0][0]为球员名称，data[1][0]为联盟，1-5分别对应下面五个数据
	 * @return
	 */
    public static CategoryDataset  createDataset(String[][] data) //创建柱状图数据集
    {
    	String score = "场均得分";
    	String rebound = "场均篮板";
    	String assist = "场均助攻";
    	String freeThrow = "罚球%";
    	String threeP = "三分%";
    	DefaultCategoryDataset    dataset=new DefaultCategoryDataset ();
        //TODO 暂时先放着，用模拟的数据
//        for(int i = 0;i<data.length;i++){
//        	for(int j = 0;j<data[0].length;i)
//        	dataset.setValue(data[i][0],Double.parseDouble(data[i][1]));
//        }
//连接数据以后使用 TODO
    	dataset.setValue(Double.parseDouble(data[0][1]),data[0][0],score);
    	dataset.setValue(Double.parseDouble(data[0][2]),data[0][0],rebound);
    	dataset.setValue(Double.parseDouble(data[0][3]),data[0][0],assist);
    	dataset.setValue(Double.parseDouble(data[0][4]),data[0][0],freeThrow);
    	dataset.setValue(Double.parseDouble(data[0][5]),data[0][0],threeP);
    	
    	dataset.setValue(Double.parseDouble(data[1][1]),data[1][0],score);
    	dataset.setValue(Double.parseDouble(data[1][2]),data[1][0],rebound);
    	dataset.setValue(Double.parseDouble(data[1][3]),data[1][0],assist);
    	dataset.setValue(Double.parseDouble(data[1][4]),data[1][0],freeThrow);
    	dataset.setValue(Double.parseDouble(data[1][5]),data[1][0],threeP);
    	
    	
//        dataset.setValue(20,lineSeries,"2012");
//        dataset.setValue(40,lineSeries,"2013");
//        dataset.setValue(15,lineSeries,"2014");
//        dataset.setValue(15,lineSeries,"2015");
        return dataset;
    }
    
    @SuppressWarnings("static-access")
	public void createChart(String[][] data) {
    	chart = ChartFactory.createBarChart(null, "联盟对比","水平", this.createDataset(data), PlotOrientation.VERTICAL,  true, false, false);  
        chart.setBackgroundPaint(null);  
        // 图片背景色  
     //   chart.setBackgroundPaint(Color.white);  
        // 设置标题文字  
        // 取得饼图plot对象  
        // PiePlot plot = (PiePlot) chart.getPlot();  
        // 取得3D饼图对象  
        CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundAlpha(0.0f);
        // 图形边框颜色  
        plot.setOutlinePaint(Color.RED);  
        // plot.setBaseSectionPaint(Color.WHITE);  
        // 图形边框粗细  
        plot.setOutlineStroke(new BasicStroke(1.0f));  
  
        // 指定图片的透明度(0.0-1.0)  
        plot.setForegroundAlpha(0.65f);  

//        plot.setSectionPaint(0, new Color(244, 194, 144));  
        // plot.setSectionPaint("2", new Color(144, 233, 144));  
        // 设置图例说明Legend上的文字  
        chart.getLegend().setItemFont(new Font("宋体", Font.PLAIN, 30));  

 }
//	
	public static void main(String [] args){
		String[][] barChartData = new String[2][6];
		for(int i = 0 ;i<6;i++){
			barChartData[0][i] = i+"";
			barChartData[1][i] = i+"";
		}
		barChartData[1][0] = "联盟";
	JFrame test = new JFrame();
	test.setSize(600, 700);
	test.setUndecorated(true);
	TeamBarChartPanel panel = new TeamBarChartPanel(0,0,600,700,barChartData);
	test.add(panel);
	test.setVisible(true);
	


	}

}
