package autotest;
import java.io.PrintStream;
import java.util.ArrayList;

import test.data.PlayerNormalInfo;
import dao.testdao.TestDaoJdbcImp;
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
								ArrayList<String> list = new ArrayList<String>();
								list.add(player.number);
								list.add(player.position);
								list.add(player.league);
								list.add(player.age);
								list.add(player.sortBy);
								System.out.println(list);
							} else if (player.isHigh.equals("high")){
								System.out.println("所有球员赛季场均高级数据");
								ArrayList<String> list = new ArrayList<String>();
								list.add(player.number);
								list.add(player.position);
								list.add(player.league);
								list.add(player.age);
								list.add(player.sortBy);
								System.out.println(list);
							}
						} else if (player.isAvg.equals("total")) {
							if (player.isHigh.equals("normal")) {
								System.out.println("所有球员赛季全部数据");
								String[] list = new String[5];
								list[0] = player.number;
								list[1] = player.position;
								list[2] = player.league;
								list[3] = player.age;
								list[4] = player.sortBy;
								System.out.println(list);
								TestDaoJdbcImp dao = new TestDaoJdbcImp();
								ArrayList<PlayerNormalInfo> result = dao.getPlayerTotalNormalInfo(list);
								System.out.print(result.get(0));
							} else if (player.isHigh.equals("high")){
								System.out.println("所有球员赛季全部高级数据");
								ArrayList<String> list = new ArrayList<String>();
								list.add(player.number);
								list.add(player.position);
								list.add(player.league);
								list.add(player.age);
								list.add(player.sortBy);
								System.out.println(list);
							}
						}
					} else if (player.isAll.equals("hot")) {
						System.out.println("热点球员");
						ArrayList<String> list = new ArrayList<String>();
						list.add(player.hotField);
						list.add(player.number);
						System.out.println(list);
					} else if (player.isAll.equals("king")) {
						System.out.println("球员数据王");
						ArrayList<String> list = new ArrayList<String>();
						list.add(player.kingField);
						list.add(player.time);
						list.add(player.number);
						System.out.println(list);
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
					if (!string.equals("")) {
						cp.parse(string.split("\\s"));
					}
				} catch (CmdlineParserException e) {
					e.printStackTrace();
				}
				if (team.help) {
					cp.setProgramName("-team");
					cp.usage();
				} else {
					if (team.isAll.equals("all")) {
						if (team.isAvg.equals("avg")) {
							if (team.isHigh.equals("normal")) {
								System.out.println("所有球队赛季场均数据");
								ArrayList<String> list = new ArrayList<String>();
								list.add(team.number);
								list.add(team.sortBy);
								System.out.println(list);
							} else if (team.isHigh.equals("high")){
								System.out.println("所有球队赛季场均高级数据");
								ArrayList<String> list = new ArrayList<String>();
								list.add(team.number);
								list.add(team.sortBy);
								System.out.println(list);
							}
						} else if (team.isAvg.equals("total")) {
							if (team.isHigh.equals("normal")) {
								System.out.println("所有球队赛季全部数据");
								ArrayList<String> list = new ArrayList<String>();
								list.add(team.number);
								list.add(team.sortBy);
								System.out.println(list);
							} else if (team.isHigh.equals("high")){
								System.out.println("所有球队赛季全部高级数据");
								ArrayList<String> list = new ArrayList<String>();
								list.add(team.number);
								list.add(team.sortBy);
								System.out.println(list);
							}
						}
					} else if (team.isAll.equals("hot")) {
						System.out.println("热点球队");
						ArrayList<String> list = new ArrayList<String>();
						list.add(team.hotField);
						list.add(team.number);
						System.out.println(list);
					}
				}
			}
		}
	}
	
}