package autotest;

import de.tototec.cmdoption.CmdOption;

public class Config {
	public Model model;
	
	@CmdOption(names = {"--help", "-h", "-?"}, description = "show help", isHelp = true)
	public boolean help;
	
	@CmdOption(names = {"--datasource"}, args = {"path"}, description = "set datasource path")
	public String path;

	@CmdOption(names = {"-player"}, description = "player model")
	public void setModelPlayer() {
		model = Model.Player;
	}
	
	@CmdOption(names = {"-team"}, description = "team model")
	public void setModelTeam() {
		model = Model.Team;
	}
}

enum Model {
	Player,Team
}
