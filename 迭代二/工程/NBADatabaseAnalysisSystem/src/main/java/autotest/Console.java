package autotest;
import java.io.PrintStream;

import de.tototec.cmdoption.*;

public class Console {
	
	public void execute(PrintStream out, String[] args) {
		Config config = new Config();
		CmdlineParser cp = new CmdlineParser(config);
		try {
			cp.parse(args[0]);
		} catch (CmdlineParserException e) {
			e.printStackTrace();
		}
		if (config.help) {
			cp.usage();
		}
		if (config.model == Model.Player) {
			String string = "";
			for (int i = 1; i < args.length; i++) {
				string = string + args[i] + " ";
			}
			Player player = new Player();
			cp = new CmdlineParser(player);
			try {
				cp.parse(string.split("\\s"));
			} catch (CmdlineParserException e) {
				e.printStackTrace();
			}
			if (player.help) {
				cp.usage();
			}
		} else if (config.model == Model.Team) {
			String string = "";
			for (int i = 1; i < args.length; i++) {
				string = string + args[i] + " ";
			}
			Team team = new Team();
			cp = new CmdlineParser(team);
			try {
				cp.parse(string.split("\\s"));
			} catch (CmdlineParserException e) {
				e.printStackTrace();
			}
			if (team.help) {
				cp.usage();
			}
		}
	}
	
}