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
			cp.setProgramName("");
			cp.usage();
		} else {
			if (config.model == Model.Player) {
				String string = "";
				for (int i = 1; i < args.length; i++) {
					string = string + args[i] + " ";
				}
				Player player = new Player();
				cp = new CmdlineParser(player);
				try {
					if (!string.equals("")) {
						cp.parse(string.split("\\s"));
					}
				} catch (CmdlineParserException e) {
					e.printStackTrace();
				}
				if (player.help) {
					cp.setProgramName("-player");
					cp.usage();
				} else {
					if (player.isAll.equals("all")) {
						if (player.isAvg.equals("avg")) {
							if (player.isHigh.equals("normal")) {
								System.out.println("所有球员赛季场均数据");
							} else if (player.isHigh.equals("high")){
								System.out.println("所有球员赛季场均高级数据");
							}
						} else if (player.isAvg.equals("total")) {
							if (player.isHigh.equals("normal")) {
								System.out.println("所有球员赛季全部数据");
							} else if (player.isHigh.equals("high")){
								System.out.println("所有球员赛季全部高级数据");
							}
						}
					} else if (player.isAll.equals("hot")) {
						System.out.println("热点球员");
					} else if (player.isAll.equals("king")) {
						System.out.println("球员数据王");
					}
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
	
}