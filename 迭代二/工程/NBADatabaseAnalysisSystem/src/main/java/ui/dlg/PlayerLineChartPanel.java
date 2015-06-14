package ui.dlg;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.TextAnchor;

@SuppressWarnings("serial")
public class PlayerLineChartPanel extends JPanel {
	
	int x;
	int y;
	int width;
	int height;
	JFreeChart chart;
	ChartPanel chartPanel;
	
	public PlayerLineChartPanel(int x,int y,int width,int height,String[][] data){
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
	
    public static CategoryDataset createDataset(String[][] data) //创建柱状图数据集
    {
        DefaultCategoryDataset dataset=new DefaultCategoryDataset();
        String lineSeries = "季后赛场均得分";
        //TODO 暂时先放着，用模拟的数据
        for(int i = 0;i<data.length;i++){
        	dataset.setValue(Double.parseDouble(data[i][1]), lineSeries, data[i][0]);
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
               //定义图标对象
               chart = ChartFactory.createLineChart(null,// 报表题目，字符串类型
                             "季度", // 横轴
                             "季后赛场均得分", // 纵轴
                             this.createDataset(data), // 获得数据集
                             PlotOrientation.VERTICAL, // 图标方向垂直
                             true, // 显示图例
                             false, // 不用生成工具
                             false // 不用生成URL地址
                             );
            //   chart.setBorderVisible(false);  
               chart.setBackgroundPaint(null);  
            //   chart.setBackgroundImageAlpha(0.0f);
//整个大的框架属于chart  可以设置chart的背景颜色
               

               // 生成图形
               CategoryPlot plot = chart.getCategoryPlot();
               // 图像属性部分
               plot.setBackgroundPaint(Color.white);
               plot.setDomainGridlinesVisible(true);  //设置背景网格线是否可见
               plot.setDomainGridlinePaint(Color.BLACK); //设置背景网格线颜色
               plot.setRangeGridlinePaint(Color.GRAY);
               plot.setNoDataMessage("没有数据");//没有数据时显示的文字说明。 
               plot.setBackgroundAlpha(0.0f);
               // 数据轴属性部分
               NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
               rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
               rangeAxis.setAutoRangeIncludesZero(true); //自动生成
               rangeAxis.setUpperMargin(0.20);
           //    rangeAxis.setLabelAngle(Math.PI / 2.0);
               rangeAxis.setAutoRange(false);
               // 数据渲染部分 主要是对折线做操作
               LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot
                             .getRenderer();
               renderer.setBaseItemLabelsVisible(true);
               renderer.setSeriesPaint(0, Color.black);    //设置折线的颜色
            renderer.setBaseShapesFilled(true);
               renderer.setBaseItemLabelsVisible(true);     
               renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(
                             ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_LEFT));
               renderer
                             .setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());  
/*
*StandardBaseItemLabelGenerator是通用的 因为我创建*的是CategoryPlot   所以很多设置都是Category相关
*而XYPlot  对应的则是 ： StandardXYItemLabelGenerator
*/
               renderer.setBaseItemLabelFont(new Font("Dialog", 1, 14));  //设置提示折点数据形状
               plot.setRenderer(renderer);
//               //区域渲染部分
//               double lowpress = 4.5; 
//         double uperpress = 8;   //设定正常血糖值的范围
//         IntervalMarker inter = new IntervalMarker(lowpress, uperpress);  
//         inter.setLabelOffsetType(LengthAdjustmentType.EXPAND); //  范围调整——扩张
//         inter.setPaint(Color.LIGHT_GRAY);// 域顏色  
//     
//         inter.setLabelFont(new Font("SansSerif", 41, 14));  
//         inter.setLabelPaint(Color.RED);  
//         inter.setLabel("正常血糖值范围");    //设定区域说明文字
//       plot.addRangeMarker(inter,Layer.BACKGROUND);  //添加mark到图形   BACKGROUND使得数据折线在区域的前端

               // 创建文件输出流
//               File fos_jpg = new File("E://bloodSugarChart.jpg ");
//               // 输出到哪个输出流
//               ChartUtilities.saveChartAsJPEG(fos_jpg, chart, // 统计图表对象
//                             700, // 宽
//                             500 // 
//                             );
//
 }
//	
//	public static void main(String [] args){
//		
//	JFrame test = new JFrame();
//	test.setSize(600, 700);
//	//test.setUndecorated(true);
//	//PlayerChartPanel panel = new PlayerChartPanel(0,0,600,700);
//	//panel.setBackground(Color.decode("#FF0000"));
////	panel.setForeground(Color.decode("#FF0000"));
//	panel.setVisible(true);
//	test.add(panel);
//	test.setVisible(true);
//	
//
//
//	}

}
