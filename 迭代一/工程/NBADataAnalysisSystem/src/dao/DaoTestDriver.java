package dao;
import java.sql.*;

public class DaoTestDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dao d= new Dao();
	    String str = d.getFromDatabase("select * from user");
	    
	    System.out.println(str);
	
	  

	}

}
