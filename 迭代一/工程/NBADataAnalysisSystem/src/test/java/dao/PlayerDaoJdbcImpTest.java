package dao;

public class PlayerDaoJdbcImpTest {
/*
	private static PlayerDaoJdbcImp dao = new PlayerDaoJdbcImp();
	private static Connection connection;
	private static DatabaseConnection dbconn;
	
	@BeforeClass
	public static void setupDatabase() throws Exception {
		Class.forName("org.sqlite.JDBC");
		connection = DriverManager.getConnection("jdbc:sqlite:player.db");
		dbconn = new DatabaseConnection(connection, null);
		dao.setConnection(connection);
		dao.createTables();
	}
	
	@AfterClass
	public static void closeDatabase() throws Exception {
		if (connection != null) {
			connection.close();
			connection = null;
		}
		if (dbconn != null) {
			dbconn.close();
			dbconn = null;
		}
	}

	protected IDataSet getDataSet(String name) throws Exception {
		InputStreamReader reader = new InputStreamReader(new FileInputStream(new File(name)));
		assertNotNull("file:" + name + " not found in classpath", reader);
		@SuppressWarnings("deprecation")
		FlatXmlDataSet dataSet = new FlatXmlDataSet(reader);
		return dataSet;
	}
	
	@Test
	public void testGetPlayerById() throws Exception {
		IDataSet setupDataset = getDataSet("./src/test/java/player.xml");
		DatabaseOperation.CLEAN_INSERT.execute(dbconn, setupDataset);
		Player player = dao.getPlayerById("1");
		assertNotNull(player);
		assertEquals("aaa", player.getName());
	}
	
	@Test
	public void testFileToDatabase() throws Exception {
		//dao.fileToDatabase("./data/players/info/");
	
	}
	

	
	
*/
}
