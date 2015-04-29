package ui.dlg;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import ui.component.MyTableHeaderPanel;
import ui.component.MyTablePanel;

@SuppressWarnings("serial")
public class TeamListPanel extends JPanel {
	int x;
	int y;
	int width;
	int height;
	int selectedRow;
	String[] westHeader;
	String[][] westTable;
	String[] eastHeader;
	String[][] eastTable;
	int rowNum;
	
	JScrollPane sp;
	MyTableHeaderPanel headerPanel;
	MyTablePanel tablePanel ;
	
	JButton West_Btn;
	JButton East_Btn;
	
	public TeamListPanel(int x,int y,int widthn,int heightn){
		
		this.x = x;
		this.y = y;
		this.width = widthn;
		this.height = heightn;
		this.setBounds(x, y, width, height);
		this.setLayout(null);
		rowNum = 4;
		
		
		
		
		westHeader = new String[]{"西南区","西北区","太平洋区"};
		eastHeader = new String []{"大西洋区","中央区","东南区"};
		
		westTable = setTableContent(westHeader);
		eastTable  = setTableContent(eastHeader);
		setTable(width/25,height/10,(width - width/12)/3,((height) - (height/10)-(height/25))/rowNum,westHeader,westTable);

		West_Btn = new JButton();
		West_Btn.setBounds(width/25,0,width/10, height/10);
		West_Btn.setFont(new Font("宋体",1, 30));//设置字体
		West_Btn.setBorderPainted(false);
		West_Btn.setMargin(new Insets(0,0,0,0));
		final JPanel panel = this;
		final JLabel btnChoosedLabel = new JLabel();
		West_Btn.addMouseListener(       new MouseAdapter(){
				public void mouseReleased(MouseEvent e){
					if(panel.getComponentAt(panel.getMousePosition()) == West_Btn){
		        		ImageIcon btnChoosedIcon = new ImageIcon("resource/LetterButton.png");
		        		btnChoosedIcon.setImage(btnChoosedIcon.getImage().getScaledInstance(West_Btn.getWidth(), West_Btn.getHeight(),Image.SCALE_DEFAULT));
		        		
		        		btnChoosedLabel.setIcon(btnChoosedIcon);
		        		btnChoosedLabel.setOpaque(false);
		        		
		        		panel.add(btnChoosedLabel);
		        		btnChoosedLabel.setBounds(West_Btn.getX(), West_Btn.getY(), West_Btn.getWidth(), West_Btn.getHeight());
		        		panel.remove(sp);
		        		panel.repaint();
		        		setTable(width/25,height/10,(width - width/12)/3,((height) - (height/10)-(height/25))/rowNum,westHeader,westTable);
	        		}
				}
	            public void mouseEntered(MouseEvent e){

	        		ImageIcon btnChoosedIcon = new ImageIcon("resource/LetterButton.png");
	        		btnChoosedIcon.setImage(btnChoosedIcon.getImage().getScaledInstance(West_Btn.getWidth(), West_Btn.getHeight(),Image.SCALE_DEFAULT));
	        		
	        		btnChoosedLabel.setIcon(btnChoosedIcon);
	        		btnChoosedLabel.setOpaque(false);
	        		
	        		panel.add(btnChoosedLabel);
	        		btnChoosedLabel.setBounds(West_Btn.getX(), West_Btn.getY(), West_Btn.getWidth(), West_Btn.getHeight());
	        		West_Btn.setForeground(Color.decode("#FF0000"));
	            }
	            public void mouseExited(MouseEvent e){
	            	panel.remove(btnChoosedLabel);
	            	West_Btn.setBackground(null);
	            	West_Btn.setForeground(null);
	            }
	            public void mousePressed(MouseEvent e){
	            	
	            	ImageIcon btnChoosedIcon = new ImageIcon("resource/LetterButtonP.png");
	        		btnChoosedIcon.setImage(btnChoosedIcon.getImage().getScaledInstance(West_Btn.getWidth(), West_Btn.getHeight(),Image.SCALE_DEFAULT));
	        		
	        		btnChoosedLabel.setIcon(btnChoosedIcon);
	        		btnChoosedLabel.setOpaque(false);
	        		
	        		panel.add(btnChoosedLabel);
	        		btnChoosedLabel.setBounds(West_Btn.getX(), West_Btn.getY(), West_Btn.getWidth(), West_Btn.getHeight());
	            	
	            }
	        
		}
);
	//	tempBtn.setOpaque(false);
		West_Btn.setMargin(new Insets(0, 0, 0, 0));
		West_Btn.setText("西部");
		West_Btn.	setContentAreaFilled(false);
		West_Btn.setBorderPainted(false);
		West_Btn.setFocusPainted(false);
		
		East_Btn = new JButton();
		East_Btn.setBounds(width/25 + width/25 + West_Btn.getWidth(),0,width/10, height/10);
		East_Btn.setFont(new Font("宋体",1, 30));//设置字体
		East_Btn.setBorderPainted(false);
		East_Btn.setMargin(new Insets(0,0,0,0));
		East_Btn.addMouseListener(       new MouseAdapter(){
				public void mouseReleased(MouseEvent e){
					if(panel.getComponentAt(panel.getMousePosition()) == East_Btn){
		        		ImageIcon btnChoosedIcon = new ImageIcon("resource/LetterButton.png");
		        		btnChoosedIcon.setImage(btnChoosedIcon.getImage().getScaledInstance(East_Btn.getWidth(), East_Btn.getHeight(),Image.SCALE_DEFAULT));
		        		
		        		btnChoosedLabel.setIcon(btnChoosedIcon);
		        		btnChoosedLabel.setOpaque(false);
		        		
		        		panel.add(btnChoosedLabel);
		        		btnChoosedLabel.setBounds(East_Btn.getX(), East_Btn.getY(), East_Btn.getWidth(), East_Btn.getHeight());
		        		panel.remove(sp);
		        		panel.repaint();
		        		setTable(width/25,height/10,(width - width/12)/3,((height) - (height/10)-(height/25))/rowNum,eastHeader,eastTable);
	        		}
				}
	            public void mouseEntered(MouseEvent e){

	        		ImageIcon btnChoosedIcon = new ImageIcon("resource/LetterButton.png");
	        		btnChoosedIcon.setImage(btnChoosedIcon.getImage().getScaledInstance(East_Btn.getWidth(), East_Btn.getHeight(),Image.SCALE_DEFAULT));
	        		
	        		btnChoosedLabel.setIcon(btnChoosedIcon);
	        		btnChoosedLabel.setOpaque(false);
	        		
	        		panel.add(btnChoosedLabel);
	        		btnChoosedLabel.setBounds(East_Btn.getX(), East_Btn.getY(), West_Btn.getWidth(), East_Btn.getHeight());
	        		East_Btn.setForeground(Color.decode("#FF0000"));
	            }
	            public void mouseExited(MouseEvent e){
	            	panel.remove(btnChoosedLabel);
	            	East_Btn.setBackground(null);
	            	East_Btn.setForeground(null);
	            }
	            public void mousePressed(MouseEvent e){
	            	
	            	ImageIcon btnChoosedIcon = new ImageIcon("resource/LetterButtonP.png");
	        		btnChoosedIcon.setImage(btnChoosedIcon.getImage().getScaledInstance(East_Btn.getWidth(), East_Btn.getHeight(),Image.SCALE_DEFAULT));
	        		
	        		btnChoosedLabel.setIcon(btnChoosedIcon);
	        		btnChoosedLabel.setOpaque(false);
	        		
	        		panel.add(btnChoosedLabel);
	        		btnChoosedLabel.setBounds(East_Btn.getX(), East_Btn.getY(), East_Btn.getWidth(), East_Btn.getHeight());
	            	
	            }
	        
		}
);
	//	tempBtn.setOpaque(false);
		East_Btn.setMargin(new Insets(0, 0, 0, 0));
		East_Btn.setText("东部");
		East_Btn.	setContentAreaFilled(false);
		East_Btn.setBorderPainted(false);
		East_Btn.setFocusPainted(false);
		this.setOpaque(false);
		this.add(West_Btn);
		this.add(East_Btn);
		
	}
	
	JFrame frame;
	public void setFatherFrame(JFrame frame){
		this.frame = frame;
	}
	private void setTable(int x,int y,int cellWidth,int cellHeight,String[] header,String[][] table){

		headerPanel  = new MyTableHeaderPanel(1,header.length,1,header.length,cellWidth*3,cellHeight/2);
		tablePanel = new MyTablePanel(table.length,header.length,table.length,header.length,cellWidth*3,cellHeight*table.length);
		
		headerPanel.setContent(header);
		tablePanel.setContent(table);
		headerPanel.setPreferredSize(new Dimension(cellWidth*3,cellHeight/2));
		tablePanel.setPreferredSize(new Dimension(cellWidth*3,cellHeight*table.length));

		sp= new JScrollPane(tablePanel);
		sp.setColumnHeaderView(headerPanel);
		sp.setSize(cellWidth*3+cellWidth/15, cellHeight*rowNum);
	    sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	    sp.setOpaque(false);
		sp.getViewport().setOpaque(false); 
		sp.getColumnHeader().setOpaque(false);//再取出头部，并设置为透明 
		
		tablePanel.addMouseListener(
				new MouseAdapter(){
					public void mouseClicked(MouseEvent e){
					//	selectedRow = Integer.parseInt(e.getComponent().getName());
						
						selectedRow=Integer.parseInt(e.getComponent().getComponentAt(tablePanel.getMousePosition()).getName());
					}          
				}
				);    
		this.add(sp);
		sp.setLocation(x,y);
//		System.out.println(mainPanel.getHeight()*2/11);
	//	tablePanel.setOpaque(false);
		headerPanel.setOpaque(false);
		
		ImageIcon rowIconA ;
		rowIconA = new ImageIcon("resource/PlayerRowA.png");
		rowIconA.setImage(rowIconA.getImage().getScaledInstance(cellWidth, cellHeight,Image.SCALE_DEFAULT));
		
		ImageIcon rowIconB ;
		rowIconB = new ImageIcon("resource/PlayerRowB.png");
		rowIconB.setImage(rowIconB.getImage().getScaledInstance(cellWidth, cellHeight,Image.SCALE_DEFAULT));
		
		ImageIcon tableHeaderIcon ;
		tableHeaderIcon = new ImageIcon("resource/PlayerHeaderRow.png");
		tableHeaderIcon.setImage(tableHeaderIcon.getImage().getScaledInstance(cellWidth, cellHeight,Image.SCALE_DEFAULT));
		
		for(int i = 0; i <table.length;){
			tablePanel.setRowBackground(rowIconA, i++);
			tablePanel.setRowBackground(rowIconB, i++);
	}
		headerPanel.setRowBackground(tableHeaderIcon, 0);
		
		tablePanel.setTableFont(new Font("Serif",0, 20));
		headerPanel.setTableFont(new Font("Serif",1, 15));
		headerPanel.setFontColor(Color.decode("#FFFFFF"));
		
	}
	
	private String[][] setTableContent(String[] header){
		//根据header获取列表信息，其中一维表示二维所代表的分区下的球队,@Dalec Gu
		String[][] content = new String[30][3];
		
		return content;
	}

//	public static void main(String [] args){
//	
//	JFrame test = new JFrame();
//	test.setSize(972, 500);
//	test.setUndecorated(true);
//	TeamListPanel panel = new TeamListPanel(0,0,972,500);
//	panel.setBackground(Color.decode("#FF0000"));
////	panel.setForeground(Color.decode("#FF0000"));
//	panel.setVisible(true);
//	test.add(panel);
//	test.setVisible(true);
	
	
	
	
	
	
//}
}
