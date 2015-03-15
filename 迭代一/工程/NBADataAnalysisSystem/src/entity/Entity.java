package entity;
import java.sql.*;

public class Entity {
	
	public String packData(ResultSet rs){
		
		String result="";

		
		try{
			
			//取得列数
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnNum = rsmd.getColumnCount();

			//包装结果集到字符串
			while(rs.next()){
				for(int i=1;i<columnNum;i++){
					result+=rs.getString(i);
					result+=";";
				}
				result+=rs.getString(columnNum);
				result+='\n';
			}
			
		}catch (Exception e){
			e.printStackTrace();
		}
		return result;
	}//end packData

}
