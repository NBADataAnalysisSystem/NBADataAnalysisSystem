package dao.initializedao;

public class test {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		InitializeDatabase ini = new InitializeDatabase();
		ini.createDatabase();
		ini.fileToDatabase("./data");
		
	}

}
