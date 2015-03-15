package dao;
import entity.Entity;
import java.sql.*;


public class Dao {
	
	Connection conn=null;
	
	private boolean connectToDatabase(){
		// ����������
        String driver = "com.mysql.jdbc.Driver";

        // URLָ��Ҫ���ʵ����ݿ���scutcs
        String url = "jdbc:mysql://localhost:3306/home";

        // MySQL����ʱ���û���
        String user = "root"; 

        // MySQL����ʱ������
        String password = "7045228";
        
        try { 
            // ������������
            Class.forName(driver);

            // �������ݿ�
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
			
			//�޷��������ݿ⣬����null
			return null;
			
		}
		
		//���ؼ�
		ResultSet result=null;
		
		try{
			
		// statement����ִ��SQL���
        Statement statement = conn.createStatement();
		
        // �����
        result = statement.executeQuery(sql);
        
		}catch(Exception e){
			e.printStackTrace();
		}
        //���ؽ����
        return result;
		
	}//getData end
	
	public String getFromDatabase(String sql){
		
		//��ȡ�����
		ResultSet rs = this.getData(sql);
		
		Entity ent = new Entity();
		
		String result = null;
		
		//��װ����
		result = ent.packData(rs);
		
		return result;
		
	}//end getFromDatabase
		

}
