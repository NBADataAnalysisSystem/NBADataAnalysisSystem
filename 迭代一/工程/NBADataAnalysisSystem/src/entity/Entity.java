package entity;
import java.sql.*;

public class Entity {
	
	public String packData(ResultSet rs){
		
		String result="";

		
		try{
			
			//ȡ������
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnNum = rsmd.getColumnCount();

			//��װ��������ַ���
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
