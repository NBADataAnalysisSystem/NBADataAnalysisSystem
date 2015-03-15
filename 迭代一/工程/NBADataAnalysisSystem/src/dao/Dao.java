package dao;
import entity.Entity;
import java.sql.*;


public class Dao {
	
	Connection conn=null;
	
	private boolean connectToDatabase(){
		// 驱动程序名
        String driver = "com.mysql.jdbc.Driver";

        // URL指向要访问的数据库名scutcs
        String url = "jdbc:mysql://localhost:3306/home";

        // MySQL配置时的用户名
        String user = "root"; 

        // MySQL配置时的密码
        String password = "7045228";
        
        try { 
            // 加载驱动程序
            Class.forName(driver);

            // 连续数据库
            conn = DriverManager.getConnection(url, user, password);

           } catch(ClassNotFoundException e) {
        	   
            e.printStackTrace();
            
           } catch(SQLException e) {
        	   
            e.printStackTrace();
            
           } 
        	   if(conn == null){
        		   
        		   return false;
        		   
        	   }else {
        		   
        		   return true;      	   
        		   
           }
        
	}//connectToDatabase end
	
	private ResultSet getData(String sql){
		
		if(!this.connectToDatabase()){
			
			//无法连接数据库，返回null
			return null;
			
		}
		
		//返回集
		ResultSet result=null;
		
		try{
			
		// statement用来执行SQL语句
        Statement statement = conn.createStatement();
		
        // 结果集
        result = statement.executeQuery(sql);
        
		}catch(Exception e){
			e.printStackTrace();
		}
        //返回结果集
        return result;
		
	}//getData end
	
	public String getFromDatabase(String sql){
		
		//获取结果集
		ResultSet rs = this.getData(sql);
		
		Entity ent = new Entity();
		
		String result = null;
		
		//包装数据
		result = ent.packData(rs);
		
		return result;
		
	}//end getFromDatabase
		

}
