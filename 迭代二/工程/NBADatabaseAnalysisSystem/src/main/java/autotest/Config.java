package autotest;
import de.tototec.cmdoption.CmdOption;

public class Config {
	@CmdOption(names = {"--help", "-h", "-?"}, description = "show help", isHelp = true)
	public boolean help;
	
	@CmdOption(names = {"--datasource"}, args = {"path"}, description = "set datasource path")
	public String path;

	@CmdOption(names = {"-player"}, description = "player model", handler = PlayerHandler.class)
	public boolean player;
}
