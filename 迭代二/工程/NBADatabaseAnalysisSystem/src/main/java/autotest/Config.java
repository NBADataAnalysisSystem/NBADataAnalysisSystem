package autotest;

import dao.Dao;
import de.tototec.cmdoption.CmdOption;

public class Config {
	public Model model;
	
	@CmdOption(names = {"--help", "-h", "-?"}, description = "显示帮助信息", isHelp = true)
	public boolean help;
	
	@CmdOption(names = {"--datasource"}, args = {"path"}, description = "设置数据来源所在路径")
	public void setPath(String path) {
		//清空数据库，重新读数据
		Dao dao = new Dao();
		try {
			dao.newDatabase();
			dao.readFiles(path+"/");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@CmdOption(names = {"-player"}, description = "球员模块")
	public void setModelPlayer() {
		model = Model.Player;
	}
	
	@CmdOption(names = {"-team"}, description = "球队模块")
	public void setModelTeam() {
		model = Model.Team;
	}
}

enum Model {
	Player,Team
}
