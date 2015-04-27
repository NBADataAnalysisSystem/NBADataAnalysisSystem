package ui.component;

import java.awt.Color;
import java.awt.Font;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * 放置表格的Panel
 * @author L.Y.C
 *
 */
@SuppressWarnings("serial")
public class MyTablePanel  extends JPanel{

	public MyTable table;
	//总行、列数
	int allRows, allColumns;
	//视图显示行、页数
	int pageRow, pageColumn;
	//内容
	
	String[][] allContent;
	String[][] pageContent;
	//指向目前显示在table上面的最左上角的行和列，指向的列同时是headList的列，相当于指针
	public int pointerRow = 0;
	public int pointerColumn = 0;
	/**
	 * @param totalRow 总行数
	 * @param totalColumn 总列数
	 * @param pageRow 每页行数
	 * @param pageColumn 每页列数
	 * @param width 表格宽
	 * @param height 表格高
	 */
	public MyTablePanel(int totalRow, int totalColumn, int pageRow, int pageColumn, int width, int height){
		
		this.allRows = totalRow;
		this.allColumns = totalColumn;
		this.pageColumn = pageColumn;
		this.pageRow = pageRow;
		
		table = new MyTable(pageRow,pageColumn);
		table.addToPanel(this);
		
		allContent = new String[totalRow][totalColumn];
		pageContent = new String[pageRow][pageColumn];
		
		for(int i = 0; i < totalRow; i++){
			for(int j = 0; j < totalColumn; j++){
				allContent[i][j] = new String();
			}
		}
		for(int i = 0; i < pageRow; i++){
			for(int j = 0; j < pageColumn; j++){
				pageContent[i][j] = new String();
			}
		}
		
		this.setTableContent();
		this.setSize(width, height);
		this.setTableSize(width, height);
		this.setTableLocation(0, 0);
		
		this.setLayout(null);
		this.setOpaque(false);
	}
	//设置表格内容
	public void setContent(String[][] content){
		
		for(int i = 0; i < content.length && i < allRows; i++){
			for(int j = 0; j < content[0].length && j < allColumns; j++){
				allContent[i][j] = content[i][j];
			}
		}
		this.setTableContent();
	
	}
	
	//设置表格图片
	public void setFieldIcon(ImageIcon[][] icon,int horizontalAlignment){
		
		table.setFieldIcon(icon,horizontalAlignment);
	
	}
	public void setTableFont(Font font){
		table.setTableFont(font);
	}
	//设置表格行背景图片
	public void setRowBackground(Icon icon, int row){
		table.setRowBackground(icon, row);
	}
	
	public void setColumnBackground(Icon icon, int column){
		table.setColumnBackground(icon, column);
	}
	
	public void setFontColor(Color c, int row){
		table.setFontColorRow(c, row);
	}
	
	public void setFontColorColumn(Color c, int column){
		table.setFontColorColumn(c, column);
	}
	
	public void setFontColor(Color c){
		table.setFontColor(c);
	}
	//设置表格内容
	protected void setTableContent(){
		for(int i = 0; i < pageRow; i++){
			for(int j = 0; j < pageColumn; j++){
				pageContent[i][j] = allContent[i+pointerRow][j+pointerColumn];
			}
		}
		table.setFieldContent(pageContent);
		table.updateUI();
	}

	//设置表格大小
	private void setTableSize(int width, int height){
		table.setSize(width, height);
	}
	//设置表格坐标
	private void setTableLocation(int x, int y){
		table.setLocation(x, y);
	}
	//滚动条相关，表格左右切换
	public void changeColumn(int change){
		pointerColumn += change;
		//设置左右滚动边界
		if(pointerColumn < 0){
			pointerColumn = 0;
		}
		else if(pointerColumn > allColumns-pageColumn){
			pointerColumn = allColumns-pageColumn;
		}
		this.setTableContent();
	}
	//上下滚动条相关
	public void changeRow(int change){
		pointerRow += change;
		if(pointerRow < 0){
			pointerRow = 0;
		}
		else if(pointerRow > allRows-pageRow){
			pointerRow = allRows-pageRow;
		}
		this.setTableContent();
	}
	//设置“指针”
	protected void setTablePointer(int pointerR, int pointerC){
		pointerRow = pointerR;
		pointerColumn = pointerC;
		if(pointerColumn < 0){
			pointerColumn = 0;
		}
		else if(pointerColumn > allColumns-pageColumn){
			pointerColumn = allColumns-pageColumn;
		}
		if(pointerRow < 0){
			pointerRow = 0;
		}
		else if(pointerRow > allRows-pageRow){
			pointerRow = allRows-pageRow;
		}
		this.setTableContent();
	}
	
////	//设置表格监听
////	int temp=0;
//	public  void getClicked(MouseEvent e){
//		for(MouseListener i:this.getMouseListeners()){
//			i.mouseClicked(e);
//		}
//	}
	
	
	
}
