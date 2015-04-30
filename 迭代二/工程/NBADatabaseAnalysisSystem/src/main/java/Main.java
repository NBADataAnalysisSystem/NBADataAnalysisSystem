import dao.Dao;
import ui.frame.FrontFrame;


public class Main {
	
	public static void main(String[] args){
		Dao d = new Dao();
		FrontFrame f = new FrontFrame();
		try {
			d.monitorFiles("D://data/matches");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
