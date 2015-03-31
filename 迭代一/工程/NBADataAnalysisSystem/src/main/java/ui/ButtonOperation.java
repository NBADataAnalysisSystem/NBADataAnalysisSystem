package ui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.geom.Area;
import java.awt.image.PixelGrabber;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.sun.awt.AWTUtilities;

@SuppressWarnings("restriction")
public class ButtonOperation extends JButton{
	
	  private static final long serialVersionUID = 1L;
//	  private Point origin; 
	  private Image img; //用来设定窗体不规则样式的图片
	  int rateOfWidth;
	  int rateOfHeight;
	  JFrame frame;
	
	@SuppressWarnings("static-access")
	public ButtonOperation(String source,JFrame frame){
		  super();
		  
		  this.frame = frame;
		  MediaTracker mt=new MediaTracker(frame);
		  this.img = Toolkit.getDefaultToolkit().createImage(source);
		  //TODO 先设置成固定大小。之后再改变
//		  int width = img.getWidth(null)/rateOfWidth;
//		  int height = img.getHeight(null)/rateOfHeight;
		  Image temp = img.getScaledInstance(100,100,img.SCALE_DEFAULT);  
		  img = temp;
		  mt.addImage(img, 0);
		  try {
			  mt.waitForAll();
		  } catch (InterruptedException e) {
			  e.printStackTrace();
		  }
		    
		  try {
			  initialize();//窗体初始化
		  } catch (IOException e) {
			  e.printStackTrace();
		  }    
	}
	//设定倍率
	public void setRate(int rateOfWidth,int rateOfHeight){
		
		this.rateOfWidth = rateOfWidth;
		this.rateOfHeight = rateOfHeight;
		
	}
	
	/**
	    * 窗体初始化
	    */
	  private void initialize() throws IOException {
	    //设定窗体大小和图片一样大
	    this.setSize(img.getWidth(null), img.getHeight(null));
	    //设定禁用窗体装饰（去掉边框）
	    //this.setUndecorated(true);
//	    //初始化用于移动窗体的原点
//	    this.origin=new Point();
	    
	    //调用AWTUtilities的setWindowShape方法设定本窗体为制定的Shape形状
	    AWTUtilities.setWindowShape(frame,getImageShape(img));        
	    //设定窗体可见度
	    AWTUtilities.setWindowOpacity(frame, 1f);
	    
	    //this.setLocationRelativeTo(null);
	    
	    //设置一下移动窗体的方法
//	    addMouseListener( 
//	        new MouseAdapter(){
//	          public void mousePressed(MouseEvent e){
//	            origin.x = e.getX();
//	            origin.y = e.getY();
//	          }
//	          //窗体上单击鼠标右键关闭程序
//	          public void mouseClicked(MouseEvent e) {
//	            if(e.getButton()==MouseEvent.BUTTON3)
//	              System.exit(0);
//	          }
//	          public void mouseReleased(MouseEvent e) {
//	            super.mouseReleased(e);
//	          }
//	          @Override
//	          public void mouseEntered(MouseEvent e) {
//	            repaint();              
//	          }            
//	        }
//	    );

//	    addMouseMotionListener(
//	        new MouseMotionAdapter(){
//	          public void mouseDragged(MouseEvent e){
//	            Point p =    getLocation();
//	            setLocation(p.x + e.getX() - origin.x, p.y + e.getY() - origin.y );
//	          }          
//	        }
//	    );    
	  }

	  
	  /**
	    * 将Image图像转换为Shape图形
	    * @param img
	    * @param isFiltrate
	    * @return Image图像的Shape图形表示
	    */
	  public Shape getImageShape(Image img) {
	    ArrayList<Integer> x=new ArrayList<Integer>();
	    ArrayList<Integer> y=new ArrayList<Integer>();    
	    int width=img.getWidth(null);//图像宽度
	    int height=img.getHeight(null);//图像高度

	    //筛选像素
	    //首先获取图像所有的像素信息
	    PixelGrabber pgr = new PixelGrabber(img, 0, 0, -1, -1, true);
	    try {
	      pgr.grabPixels();
	    } catch (InterruptedException ex) {
	      ex.getStackTrace();
	    }
	    int pixels[] = (int[]) pgr.getPixels();
	    
	    //循环像素
	    for (int i = 0; i < pixels.length; i++) {
	      //筛选，将不透明的像素的坐标加入到坐标ArrayList x和y中      
	      int alpha = getAlpha(pixels[i]);
	      if (alpha == 0){
	        continue;        
	      }else{
	        x.add(i%width>0 ? i%width-1:0);
	        y.add(i%width==0 ? (i==0 ? 0:i/width-1):i/width);
	      }      
	    }
	    
	    //建立图像矩阵并初始化(0为透明,1为不透明)
	    int[][] matrix=new int[height][width];    
	    for(int i=0;i<height;i++){
	      for(int j=0;j<width;j++){
	        matrix[i][j]=0;
	      }
	    }
	    
	    //导入坐标ArrayList中的不透明坐标信息
	    for(int c=0;c<x.size();c++){
	      matrix[y.get(c)][x.get(c)]=1;
	    }
	    
	    /* 由于Area类所表示区域可以进行合并，我们逐一水平"扫描"图像矩阵的每一行，
	     * 将不透明的像素生成为Rectangle，再将每一行的Rectangle通过Area类的rec
	     * 对象进行合并，最后形成一个完整的Shape图形
	     */
	    Area rec=new Area();
	    int temp=0;
	    
	    for(int i=0;i<height;i++){
	      for(int j=0;j<width;j++){
	        if(matrix[i][j]==1){
	          if(temp==0)
	            temp=j;  
	          else if(j==width){
	            if(temp==0){
	              Rectangle rectemp=new Rectangle(j,i,1,1);
	              rec.add(new Area(rectemp));
	            }else{
	              Rectangle rectemp=new Rectangle(temp,i,j-temp,1);
	              rec.add(new Area(rectemp));
	              temp=0;
	            }
	          }
	        }else{
	          if(temp!=0){
	            Rectangle rectemp=new Rectangle(temp,i,j-temp,1);
	            rec.add(new Area(rectemp));
	            temp=0;
	          }
	        }
	      }
	      temp=0;
	    }
	    return rec;
	  }

	  
	  /**
	    * 获取像素的Alpha值
	    * @param pixel
	    * @return 像素的Alpha值
	    */
	  private int getAlpha(int pixel) {
	    return (pixel >> 24) & 0xff;
	  }
	  
	  
	  /* 我们可以选择在窗体上绘制图片，是窗体完全呈现出图片的样式，
	    * 当然我们也可以根据需要不绘制它，而采取其他操作
	    */
	  @Override
	  public void paint(Graphics g) {
	    super.paint(g);
	    g.drawImage(img, 0, 0, null);
	  }

}
