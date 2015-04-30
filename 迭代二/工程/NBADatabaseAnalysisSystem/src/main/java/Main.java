import dao.Dao;
import ui.frame.FrontFrame;


public class Main {
	
	public static void main(String[] args){
		Dao d = new Dao();
		FrontFrame f = new FrontFrame();
		try {
			d.monitorFiles("C://Users/cross/Documents/CSE/CSEIII data/迭代一数据/matches");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
