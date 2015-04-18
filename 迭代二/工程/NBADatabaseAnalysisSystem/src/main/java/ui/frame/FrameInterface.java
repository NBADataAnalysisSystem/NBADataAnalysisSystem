package ui.frame;

import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.JLabel;


/**
 * 提供球员和球队主要界面的接口
 * @author L.Y.C
 * @version2015/4/12
 *
 */
public interface FrameInterface {
	
	//设置表格内容，包括表头
	public void setTableContent(String [] headerContent,String[][] content);
	//建立、变更表格，包括SCROLLPANE
	public void buidTablePanel(int allRow,int allColumn,int pageRow,int pageColumn);
	//显示数据
	public void showData();
	//获取表头信息
	public ArrayList<String> getList();
	//设置表头信息
	public void setList(ArrayList<String> list);
	//更新数据
	public void refreshData();
	//设置图片
	public JLabel setLabelIcon(Icon icon);
	public void setBtnPanel();
	public void setTablePanel();
}
