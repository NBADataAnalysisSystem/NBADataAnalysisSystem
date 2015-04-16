package ui.component;

import javax.swing.JLabel;

public class MyTableHeaderPanel extends MyTablePanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1533827499842103220L;
	JLabel[] header;
	final static int allRow = 1;
	final static int pageRow = 1;
	
	public MyTableHeaderPanel(int totalRow, int totalColumn, int pageRows,
			int pageColumn, int width, int height) {
		super(allRow, totalColumn, pageRow, pageColumn, width, height);
		// TODO Auto-generated constructor stub
	}

	public void setContent(String[] content){
		
			for(int j = 0; j < content.length && j < allColumns; j++){
				allContent[0][j] = content[j];
			}
		this.setTableContent();
	
	}	
	
	protected void setTableContent(){
			for(int j = 0; j < pageColumn; j++){
				pageContent[0][j] = allContent[0][j+pointerColumn];
			}
		table.setFieldContent(pageContent);
		table.updateUI();
	}
	
	


}
