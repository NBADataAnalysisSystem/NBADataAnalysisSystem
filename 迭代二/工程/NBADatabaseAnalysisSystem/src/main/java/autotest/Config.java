package autotest;
import de.tototec.cmdoption.CmdOption;
import de.tototec.cmdoption.CmdlineParser;
import de.tototec.cmdoption.CmdlineParserException;

public class Config {
	@CmdOption(names = {"--help", "-h", "-?"}, description = "show help", isHelp = true)
	public boolean help;
	
	@CmdOption(names = {"--datasource"}, args = {"path"}, description = "set datasource path")
	public String path;

	@CmdOption(names = {"-player"}, args = {"options"}, description = "player model")
	public void print(String op) {
		Player player = new Player();
		CmdlineParser cp = new CmdlineParser(player);
		try {
			cp.parse(op.split("\\s"));
		} catch (CmdlineParserException e) {
			e.printStackTrace();
		}
		System.out.println(player.getNum());
	}
}
