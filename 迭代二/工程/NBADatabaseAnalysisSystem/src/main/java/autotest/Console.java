package autotest;
import java.io.PrintStream;
import java.util.ArrayList;

import test.data.PlayerNormalInfo;
import test.data.TeamHighInfo;
import test.data.TeamHotInfo;
import test.data.TeamNormalInfo;
import dao.testdao.TestDaoJdbcImp;
import de.tototec.cmdoption.*;

public class Console {
	
	public void execute(PrintStream out, String[] args) {
		Config config = new Config();
		CmdlineParser cp = new CmdlineParser(config);
		try {
			if (args[0].charAt(0)!=args[0].charAt(1)) {
				cp.parse(args[0]);
			} else {
				cp.parse(args);
			}
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
								String[] list = new String[5];
								list[0] = player.number;
								list[1] = player.position;
								list[2] = player.league;
								list[3] = player.age;
								list[4] = player.sortBy;
								TestDaoJdbcImp dao = new TestDaoJdbcImp();
								ArrayList<PlayerNormalInfo> result = dao.getPlayerAvgNormalInfo(list);
								for (int i = 0; i < result.size(); i++) {
									out.println(i+1);
									out.println(result.get(i).getPoint());
								}
							} else if (player.isHigh.equals("high")){
								System.out.println("所有球员赛季场均高级数据");
								String[] list = new String[5];
								list[0] = player.number;
								list[1] = player.position;
								list[2] = player.league;
								list[3] = player.age;
								list[4] = player.sortBy;
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
								TestDaoJdbcImp dao = new TestDaoJdbcImp();
								ArrayList<PlayerNormalInfo> result = dao.getPlayerTotalNormalInfo(list);
								for (int i = 0; i < result.size(); i++) {
									out.println(i+1);
									out.println(result.get(i));
								}
							} else if (player.isHigh.equals("high")){
								System.out.println("所有球员赛季全部高级数据");
								String[] list = new String[5];
								list[0] = player.number;
								list[1] = player.position;
								list[2] = player.league;
								list[3] = player.age;
								list[4] = player.sortBy;
							}
						}
					} else if (player.isAll.equals("hot")) {
						System.out.println("热点球员");
						String[] list = new String[2];
						list[0] = player.hotField;
						list[1] = player.number;
					} else if (player.isAll.equals("king")) {
						System.out.println("球员数据王");
						String[] list = new String[3];
						list[0] = player.kingField;
						list[1] = player.time;
						list[2] = player.number;
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
								String[] list = new String[2];
								list[0] = team.number;
								list[1] = team.sortBy;
								TestDaoJdbcImp dao = new TestDaoJdbcImp();
								ArrayList<TeamNormalInfo> result = dao.getTeamAvgNormalInfo(list);
								for (int i = 0; i < result.size(); i++) {
									out.println(i+1);
									out.println(result.get(i));
								}
							} else if (team.isHigh.equals("high")){
								System.out.println("所有球队赛季场均高级数据");
								String[] list = new String[2];
								list[0] = team.number;
								list[1] = team.sortBy;
								TestDaoJdbcImp dao = new TestDaoJdbcImp();
								ArrayList<TeamHighInfo> result = dao.getTeamAvgHighInfo(list);
								for (int i = 0; i < result.size(); i++) {
									out.println(i+1);
									out.println(result.get(i));
								}
							}
						} else if (team.isAvg.equals("total")) {
							if (team.isHigh.equals("normal")) {
								System.out.println("所有球队赛季全部数据");
								String[] list = new String[2];
								list[0] = team.number;
								list[1] = team.sortBy;
								TestDaoJdbcImp dao = new TestDaoJdbcImp();
								ArrayList<TeamNormalInfo> result = dao.getTeamTotalNormalInfo(list);
								for (int i = 0; i < result.size(); i++) {
									out.println(i+1);
									out.println(result.get(i));
								}
							} else if (team.isHigh.equals("high")){
								System.out.println("所有球队赛季全部高级数据");
								String[] list = new String[2];
								list[0] = team.number;
								list[1] = team.sortBy;
								TestDaoJdbcImp dao = new TestDaoJdbcImp();
								ArrayList<TeamHighInfo> result = dao.getTeamTotalHighInfo(list);
								for (int i = 0; i < result.size(); i++) {
									out.println(i+1);
									out.println(result.get(i));
								}
							}
						}
					} else if (team.isAll.equals("hot")) {
						System.out.println("热点球队");
						String[] list = new String[2];
						list[0] = team.hotField;
						list[1] = team.number;
						TestDaoJdbcImp dao = new TestDaoJdbcImp();
						ArrayList<TeamHotInfo> result = dao.getTeamHotInfo(list);
						for (int i = 0; i < result.size(); i++) {
							out.println(i+1);
							out.println(result.get(i));
						}
					}
				}
			}
		}
	}
	
}