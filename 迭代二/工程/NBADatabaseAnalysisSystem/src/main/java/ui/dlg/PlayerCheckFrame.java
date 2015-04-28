package ui.dlg;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.sun.awt.AWTUtilities;



public class PlayerCheckFrame extends JFrame implements  ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5980271968002702909L;
	private static Point origin = new Point();
	//璁剧疆绐椾綋澶у皬
	private int height=0;
	private int width=0;
	private int x;
	private int y;
	JPanel backgroundPanel;
	JPanel mainPanel;
	JPanel basicPanel;
	JScrollPane sp;
	JPanel infoPanel;
	JPanel seasonPanel;
	JPanel matchPanel;
	
	String player;
	

	
	public PlayerCheckFrame(String tocheck){
			player = tocheck;
			backgroundPanel = new JPanel();
			height = Toolkit.getDefaultToolkit().getScreenSize().height*4/5;
			width = Toolkit.getDefaultToolkit().getScreenSize().width*1/2;
			x=(Toolkit.getDefaultToolkit().getScreenSize().width-width)/2;
			y=(Toolkit.getDefaultToolkit().getScreenSize().height-height)/2;
			this.setUndecorated(true);
			this.setSize(width, height);
			this.setLocation(x,y);
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			this.setLayout(null);
		
			backgroundPanel.setSize(width,height);
			backgroundPanel.setLayout(null);

			ImageIcon background ;
			background = new ImageIcon("resource/check.png");
			background.setImage(background.getImage().getScaledInstance(backgroundPanel.getWidth(), backgroundPanel.getHeight(),Image.SCALE_DEFAULT));
		
			JLabel placeBackgroundIcon = new JLabel();
			placeBackgroundIcon.setIcon(background);
			placeBackgroundIcon.setBounds(0, 0,backgroundPanel.getWidth() , backgroundPanel.getHeight());
			placeBackgroundIcon.setOpaque(false);

		      
			mainPanel = new JPanel();
			mainPanel.setBounds(0, 0,width, height);
			mainPanel.setLayout(null);
			mainPanel.setOpaque(false);
	
			basicPanel = new JPanel();
			basicPanel.setBounds(0, 0, width, height/3);
			basicPanel.setOpaque(false);
			setBasicPanel();
			
			infoPanel = new JPanel();
			infoPanel.setBounds(0, height/3, width, height*2/3);
			infoPanel.setLayout(new GridLayout(2,1));
			infoPanel.setOpaque(false);
			
			seasonPanel = new JPanel();
			seasonPanel.setOpaque(false);
			setSeasonPanel();
			infoPanel.add(seasonPanel);
			
			matchPanel = new JPanel();
			matchPanel.setOpaque(false);
			matchPanel.setBorder(BorderFactory.createEmptyBorder());
			setMatchPanel();
			infoPanel.add(matchPanel);
			
			mainPanel.add(infoPanel);
			JButton btn_Close = new JButton("脳");
			btn_Close.setMargin(new Insets(0,0,0,0));
			btn_Close.setBounds(this.getWidth()-30,0,30, 30);
			btn_Close.addActionListener( this);
			btn_Close.setContentAreaFilled(false);
			btn_Close.setForeground(Color.decode("#3A5FCD"));
			btn_Close.setFont(new Font("Serif",0, 30));//璁剧疆瀛椾綋
			btn_Close.setName("close");
		      //TODO
			mainPanel.add(basicPanel);
			backgroundPanel.add(placeBackgroundIcon);
			backgroundPanel.setBackground(Color.white);
			this.add(backgroundPanel);
			this.add(mainPanel,0);
			this.add(btn_Close,0);
			this.setVisible(true);
		      
		  	this. addMouseListener( 
			        new MouseAdapter(){
			            public void mousePressed(MouseEvent e){
			              origin.x = e.getX();
			              origin.y = e.getY();
			            }

//			            public void mouseReleased(MouseEvent e) {
//			              ( (MouseListener) this).mouseReleased(e);
//			            }
			            @Override
			            public void mouseEntered(MouseEvent e) {
			              repaint();              
			            }            
			          }
			      );

			      this.addMouseMotionListener(
			          new MouseMotionAdapter(){
			            public void mouseDragged(MouseEvent e){
			              Point p =    getLocation();
			              setLocation(p.x + e.getX() - origin.x, p.y + e.getY() - origin.y );
			            }          
			          }
			      );    
		      
	}


	@SuppressWarnings("static-access")
	private void setMatchPanel() {
		final ImageIcon icon = new ImageIcon("resource/Line.png");
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints s= new GridBagConstraints();
		s.fill = GridBagConstraints.BOTH; 
		matchPanel.setLayout(layout);
		final JLabel lineLabel =new JLabel();
		s.gridwidth=0;
		s.weightx = 1; 
		s.weighty=1;
		layout.setConstraints(lineLabel, s);
		lineLabel.setText("最近五场比赛");
		lineLabel.addComponentListener(new ComponentAdapter(){
			public void componentResized(ComponentEvent e){
				icon.setImage(icon.getImage().getScaledInstance(lineLabel.getWidth(), lineLabel.getHeight(),Image.SCALE_DEFAULT));
			}
		}
	);
		lineLabel.setIcon(icon);
		lineLabel.setFont(new Font("宋体",1,height/24));
		lineLabel.setForeground(Color.WHITE);
		lineLabel.setHorizontalTextPosition(lineLabel.CENTER);
		matchPanel.add(lineLabel);

		String [] tempHeader = new String[17];
		String[][] tableString = new String[6][17];
		tableString[0]= new String[]{"年度","球队","场数","%","鍛戒腑","鍑烘墜","鍛戒腑","涓夊垎鍑烘墜","缃氱悆%","缃氱悆鍛戒腑","缃氱悆鍑烘墜","杩涙敾","闃插畧","绡澘","鍔╂敾","鎶㈡柇","澶辫","鐘","鐩栧附","寰楀垎"};
		DefaultTableModel model = new DefaultTableModel(tableString,tempHeader);
		JTable table = new JTable(model);
		s.gridwidth=0;
		s.weightx = 1; 
		s.weighty=8;
		layout.setConstraints(table, s);
		MyTableCellRenderrer render = new MyTableCellRenderrer();
	//	render.setOpaque(false); //灏嗘覆鏌撳櫒璁剧疆涓洪?忔槑  
     
        table.setDefaultRenderer(Object.class,render);  
		for(int i = 0;i<table.getColumnCount();i++){
			table.getColumnModel().getColumn(i).setPreferredWidth(tableString[0][i].length()*height/24);	
		}
		table.getColumnModel().getColumn(0).setPreferredWidth(5*height/24);	
		table.setRowHeight(height/23);
		table.setEnabled(false);
		table.setGridColor(Color.GRAY);
		//table.setOpaque(false);

		matchPanel.add(table);
		
	}


	@SuppressWarnings("static-access")
	private void setSeasonPanel() {
		final ImageIcon icon = new ImageIcon("resource/Line.png");
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints s= new GridBagConstraints();
		s.fill = GridBagConstraints.BOTH; 
		seasonPanel.setLayout(layout);
		final JLabel lineLabel =new JLabel();
		s.gridwidth=0;
		s.weightx = 1; 
		s.weighty=0.23;
		layout.setConstraints(lineLabel, s);
		lineLabel.setText("璧涘鏁版嵁");
		lineLabel.addComponentListener(new ComponentAdapter(){
			public void componentResized(ComponentEvent e){
				icon.setImage(icon.getImage().getScaledInstance(lineLabel.getWidth(), lineLabel.getHeight(),Image.SCALE_DEFAULT));
			}
		}
	);
		lineLabel.setIcon(icon);
		lineLabel.setFont(new Font("瀹嬩綋",1,height/21));
		lineLabel.setForeground(Color.WHITE);
		lineLabel.setHorizontalTextPosition(lineLabel.CENTER);
		seasonPanel.add(lineLabel);
		/**
		 * 璁剧疆璧涘骞冲潎琛ㄥご
		 */
		String [] tempHeader = new String[17];
		String[][] tableString = new String[5][17];
		tableString[0]= new String[]{"骞村害","鐞冮槦","鍦烘暟","鍏堝彂","鍒嗛挓","%","涓夊垎%","缃氱悆%","杩涙敾","闃插畧","鍦哄潎绡澘","鍦哄潎鍔╂敾","鍦哄潎鎶㈡柇","鍦哄潎鐩栧附","澶辫","鐘","寰楀垎"};
		DefaultTableModel model = new DefaultTableModel(tableString,tempHeader);
		JTable table = new JTable(model);
		s.gridwidth=0;
		s.weightx = 1; 
		s.weighty=5;
		layout.setConstraints(table, s);
		MyTableCellRenderrer render = new MyTableCellRenderrer();
	//	render.setOpaque(false); //灏嗘覆鏌撳櫒璁剧疆涓洪?忔槑  
     
        table.setDefaultRenderer(Object.class,render);  
		for(int i = 0;i<table.getColumnCount();i++){
			table.getColumnModel().getColumn(i).setPreferredWidth(tableString[0][i].length()*height/21);	
		}
		table.getColumnModel().getColumn(0).setPreferredWidth(5*height/21);	
		table.getColumnModel().getColumn(1).setPreferredWidth(5*height/21);	
		table.setRowHeight(height/19);
		table.setEnabled(false);
		table.setGridColor(Color.decode("#D1EEEE"));
		//table.setOpaque(false);

		seasonPanel.add(table);
	}


	@SuppressWarnings("static-access")
	private void setBasicPanel() {
		ImageIcon icon = new ImageIcon();
		basicPanel.setLayout(new GridLayout(1,4));
		JLabel playerPhoto = new JLabel();
		icon =  new ImageIcon("resource/BackgroundOfHot.png");
		icon.setImage(icon.getImage().getScaledInstance(width/4, height/3,Image.SCALE_DEFAULT));
		playerPhoto.setIcon(icon);
		basicPanel.add(playerPhoto);
		JPanel contain;
		/**
		 * 璁剧疆鍚嶃?佺悆闃熷悕銆佸彿鏁般?佷綅缃?
		 */
		JPanel dataPanel = new JPanel();
		dataPanel.setLayout(new BorderLayout());
		JLabel number = new JLabel();
		number.setText("3");
		number.setForeground(Color.YELLOW);
		number.setFont(new Font("瀹嬩綋",1,50));
		number.setBorder(BorderFactory.createLoweredBevelBorder());
		number.setHorizontalAlignment(number.RIGHT);
		dataPanel.add("West",number);
		contain = new JPanel();
		contain.setOpaque(false);
		contain.setLayout(new GridLayout(4,1));
		JLabel englishName = new JLabel();
		englishName.setText(player);
		englishName.setFont(new Font("瀹嬩綋",0,20));
		englishName.setHorizontalAlignment(number.LEFT);
		contain.add(englishName);
		JLabel chineseName = new JLabel();
		chineseName.setText("涓枃-涓枃涓枃");
		chineseName.setFont(new Font("瀹嬩綋",1,15));
		chineseName.setHorizontalAlignment(chineseName.LEFT);
		contain.add(chineseName);
		JLabel teamChinese = new JLabel();
		teamChinese.setText("涓枃涓枃涓枃");
		teamChinese.setFont(new Font("瀹嬩綋",0,15));
		teamChinese.setForeground(Color.BLUE);
		teamChinese.setHorizontalAlignment(teamChinese.LEFT);
		teamChinese.setVerticalAlignment(teamChinese.BOTTOM);
		contain.add(teamChinese);
		JLabel position = new JLabel();
		position.setText("涓枃");
		position.setFont(new Font("Courier",0,15));
		position.setHorizontalAlignment(position.LEFT);
		position.setVerticalAlignment(position.TOP);
		contain.add(position);
		dataPanel.add("Center",contain);
		/**
		 * 璁剧疆涓変釜鍦哄潎淇℃伅
		 */
		contain = new JPanel();
		contain.setOpaque(false);
		contain.setLayout(new GridLayout(2,3));
		JLabel temp1 =new JLabel();
		temp1.setText("鍦哄潎寰楀垎");
		temp1.setFont(new Font("瀹嬩綋",0,10));
		temp1.setForeground(Color.decode("#9B30FF"));
		contain.add(temp1);
		JLabel temp2 =new JLabel();
		temp2.setText("鍦哄潎绡澘");
		temp2.setFont(new Font("瀹嬩綋",0,10));
		temp2.setForeground(Color.decode("#9B30FF"));
		contain.add(temp2);
		JLabel temp3 =new JLabel();
		temp3.setText("鍦哄潎鍔╂敾");
		temp3.setFont(new Font("瀹嬩綋",0,10));
		temp3.setForeground(Color.decode("#9B30FF"));
		contain.add(temp3);
		JLabel temp1A =new JLabel();
		temp1A.setText("11");
		temp1A.setFont(new Font("瀹嬩綋",1,20));
		contain.add(temp1A);
		JLabel temp2A =new JLabel();
		temp2A.setText("22");
		temp2A.setFont(new Font("瀹嬩綋",1,20));
		contain.add(temp2A);
		JLabel temp3A =new JLabel();
		temp3A.setText("33");
		temp3A.setFont(new Font("瀹嬩綋",1,20));
		contain.add(temp3A);
		dataPanel.add("South",contain);
		dataPanel.setOpaque(false);
		basicPanel.add(dataPanel);
		/**
		 * 璁剧疆涓汉淇℃伅
		 */		
		JPanel basicInfoPanel = new JPanel();
		basicInfoPanel.setOpaque(false);
		basicInfoPanel.setLayout(new GridLayout(8,1));
		basicInfoPanel.add(new JLabel());
		JLabel whRate = new JLabel();
		whRate.setText("韬珮"+"/"+"浣撻噸");
		whRate.setFont(new Font("Serif",0,11));
		basicInfoPanel.add(whRate);
		JLabel birthDay = new JLabel();
		birthDay.setText("鐢熸棩"+":"+"1111-11-11");
		birthDay.setFont(new Font("Serif",0,11));
		basicInfoPanel.add(birthDay);
		JLabel exp = new JLabel();
		exp.setText("缁忓巻"+":"+"2骞?");
		exp.setFont(new Font("Serif",0,11));
		basicInfoPanel.add(exp);
		JLabel school = new JLabel();
		school.setText("鍔犲叆NBA涔嬪墠"+":"+"Baylor/United States");
		school.setFont(new Font("Serif",0,11));
		basicInfoPanel.add(school);
		basicPanel.add(basicInfoPanel);
		
		JLabel teamIcon = new JLabel();
		icon =  new ImageIcon("resource/BackgroundOfHot.png");
		icon.setImage(icon.getImage().getScaledInstance(width/8, height/6,Image.SCALE_DEFAULT));
		teamIcon.setHorizontalAlignment(teamChinese.RIGHT);
		teamIcon.setVerticalAlignment(teamChinese.CENTER);
		teamIcon.setIcon(icon);
		basicPanel.add(teamIcon);
		
		
	}


	public JLabel setLabelIcon(Icon icon) {
		// TODO Auto-generated method stub
		return null;
	}
	private JFrame fatherFrame;
	public void setFatherFrame(JFrame frame){
		fatherFrame = frame;
	}
	
	public static void main(String[] args){
		
		@SuppressWarnings("unused")
		PlayerCheckFrame test = new PlayerCheckFrame("");
	}

	 @SuppressWarnings("serial")
	class MyTableCellRenderrer extends DefaultTableCellRenderer{
	        
         @Override
         public Component getTableCellRendererComponent(JTable table,
                 Object value, boolean isSelected, boolean hasFocus, int row,
                 int column)
         {
             // TODO Auto-generated method stub
             Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            // 闅旇鎹㈣壊
             if(row == 0){
            	 comp.setBackground(Color.GRAY);
             }else if(row%2 ==1){
            	// ((JComponent) comp).setOpaque(false);
            	  comp.setBackground(Color.decode("#D1EEEE"));
             }else if(row%2 ==0 && row !=0){
             	// ((JComponent) comp).setOpaque(false);
           	  comp.setBackground(Color.white);
            }
             return comp;
         }
 }
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JButton){
			JButton btn = (JButton)e.getSource();
			String name = btn.getName();
			if("close".equals(name)){
				  this.setVisible(false);
				  this.dispose();
					AWTUtilities.setWindowOpacity(fatherFrame, 1f);
			//	  System.exit(0);
			}
		}
		
	}
	


}
