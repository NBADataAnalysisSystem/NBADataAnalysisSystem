package dao;

public interface DaoInterface {
		
	//创建新数据库
	public void newDatabase () throws Exception;
	
	//从路径path中的文件中读取数据
	public void readFiles(String path) throws Exception;
	
	//从原路径中读取新添加的数据
	public void refreshFiles() throws Exception;
		

}
