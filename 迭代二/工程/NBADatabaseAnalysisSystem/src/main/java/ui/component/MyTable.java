package ui.component;

import java.awt.Color;
import java.awt.Font;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * 自制表格
 * @author L.Y.C
 * @version 2015/4/12
 */

public class MyTable {
	//表格，三维数组，前两维为行和列，固定单元格位置，第三为判定内容或图片
	JLabel[][][] table ;
	int row,column;
	//单元格高与宽
	int cellH,cellW;
	//表格坐标
	int x = 0,y = 0;
	
	public MyTable(int row,int column){
		
		table = new JLabel[row][column][2];
		this.row = row;
		this.column = column;
		
		//绘制表格
		for(int i = 0; i < row; i++){
			for(int j = 0; j < column; j++){
				table[i][j][0] = new JLabel();
				table[i][j][1] = new JLabel();
				table[i][j][0] .setName(Integer.toString(i));
				table[i][j][1].setName(Integer.toString(i));
				table[i][j][0].setHorizontalAlignment(SwingConstants.CENTER);
				//设置表格为透明，方便显示图片
				table[i][j][0].setOpaque(false);
				table[i][j][1].setOpaque(false);
			}
		}
		
	}
	//表格内容添加，添加内容为String的二维数组
	public void setFieldContent(String[][] content){
		
		for(int i = 0; i < content.length && i < row; i++){
			for(int j = 0; j < content[0].length && j < column; j++){
				table[i][j][0].setText(content[i][j]);
			}
		}
		
	}
	public void setFieldIcon(ImageIcon[][] icon,int horizontalAlignment){

		for(int i = 0; i < icon.length && i < row; i++){
			for(int j = 0; j < icon[0].length && j < column; j++){
				table[i][j][0].setIcon(icon[i][j]);
				table[i][j][0].setHorizontalTextPosition(horizontalAlignment);
			}
		}
	}
	
	//获取单元格
	public JLabel getCell(int row,int column){
		return table[row][column][0];
	}
	//设置单元格高
	public void setRowHeight(int Rheight){
		cellH = Rheight;
		this.resetTableBounds();
	}
	//设置单元格宽
	public void setColumnWidth(int Cwidth){
		cellW = Cwidth;
		this.resetTableBounds();
	}
	//设置表格整体大小
	public void setSize(int width, int height){
		if(row !=0){
			cellH = height / row;
		}else{
			cellH = height;
		}
		cellW = width / column;
		this.resetTableBounds();
	}
	//设置坐标
	public void setLocation(int x, int y){
		this.x = x;
		this.y = y;
		this.resetTableBounds();
	}
	//设置表格坐标、大小
	private void resetTableBounds(){
		for(int i = 0; i < row; i++){
			for(int j = 0; j < column; j++){
				table[i][j][0].setBounds(x+j*cellW, y+i*cellH, cellW, cellH);
				table[i][j][1].setBounds(x+j*cellW, y+i*cellH, cellW, cellH);
			}
		}
	}
	//刷新表格
	public void updateUI(){
		for(int i = 0; i < row; i++){
			for(int j = 0; j < column; j++){
				table[i][j][0].updateUI();
				table[i][j][1].updateUI();
			}
		}
	}
	//将表格添加到Panel中
	protected void addToPanel(JPanel panel){
		for(int i = 0; i < row; i++){
			for(int j = 0; j < column; j++){
				//先添加背景，后添加内容
				panel.add(table[i][j][1], 0);
				panel.add(table[i][j][0], 0);
			}
		}
	

	}
	//设置字体大小
	protected void setTableFont(Font font){
		for(int i = 0; i < row; i++){
			for(int j = 0; j < column; j++){
				table[i][j][0].setFont(font);
			}
		}
	}
	//设置字体颜色
	protected void setFontColor(Color c){
		for(int i = 0; i < row; i++){
			for(int j = 0; j < column; j++){
				table[i][j][0].setForeground(c);
			}
		}
	}
	
	//设置某列字体颜色
	protected void setFontColorColumn(Color c, int column){
		if(column >= this.column || column < 0) return;
		for(int i = 0; i < row; i++){
			table[i][column][0].setForeground(c);
		}
	}
	//设置某行字体颜色
	protected void setFontColorRow(Color c, int row){
		if(row >= this.row || row < 0) return;
		for(int j = 0; j < column; j++){
			table[row][j][0].setForeground(c);
		}
	}
	//设置某行背景
	protected void setRowBackground(Icon icon, int row){
		if(row >= this.row || row < 0) return;
		for(int j = 0; j < column; j++){
			table[row][j][1].setIcon(icon);
		}
	}
	//设置某列背景
	protected void setColumnBackground(Icon icon, int column){
		if(column >= this.column || column < 0) return;
		for(int i = 0; i < row; i++){
			table[i][column][1].setIcon(icon);
		}
	}
	//真是给跪。。。TODO
	int tempRow = -1;
	protected int getClicked(){
		
		return tempRow;
	}
	
}
