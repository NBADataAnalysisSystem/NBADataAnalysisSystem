package autotest;

import de.tototec.cmdoption.CmdOption;

public class Player {
	public String isAll = "all";
	public String isAvg = "avg";
	public String hotField;
	public String kingField;
	public String time;
	public String number = "50";
	public String isHigh = "normal";
	public String position = "A";
	public String league = "A";
	public String age = "A";
	public String sortBy = "point.desc";
	
	@CmdOption(names = {"--help", "-h", "-?"}, description = "显示帮助信息", isHelp = true)
	public boolean help;
	
	@CmdOption(names = {"-all"}, description = "显示所有球员数据（默认）", conflictsWith = {"-hot", "-king"})
	private void setAll() {
		isAll = "all";
	}
	
	@CmdOption(names = {"-hot"}, args = {"field"}, 
			description = "显示热点球员", 
			conflictsWith = {"-avg", "-total", "-filter", "-sort", "-all", "-king"})
	private void setHot(String field) {
		isAll = "hot";
		hotField = field;
	}
	
	@CmdOption(names = {"-king"}, args = {"field", "-season/daily"}, 
			description = "显示数据王", 
			conflictsWith = {"-avg", "-total", "-filter", "-sort", "-all", "-hot"})
	private void setKing(String field,String type) {
		isAll = "king";
		kingField = field;
		time = type.substring(1);
		number = "5";
	}
	
	@CmdOption(names = {"-avg"}, description = "显示球员赛季平均数据（默认）", conflictsWith = {"-total"})
	private void setAvg() {
		isAvg = "avg";
	}
	
	@CmdOption(names = {"-total"}, description = "显示球员赛季总数据", conflictsWith = {"-avg"})
	private void setTotal() {
		isAvg = "total";
	}
	

	@CmdOption(names = {"-n"}, args = {"number"}, description = "显示的条目数（默认50）")
	private void setNumber(String number) {
		this.number = number;
	}
	
	@CmdOption(names = {"-filter"}, args = {"condition"}, description = "筛选")
	private void setFilter(String condition) {
		for (String string:condition.split(",")) {
			switch (string.split("\\.")[0]) {
			case "position":
				position = string.split("\\.")[1];
				break;
			case "league":
				league = string.split("\\.")[1].charAt(0)+"";
				break;
			case "age":
				switch (string.split("\\.")[1]) {
				case "<=22":
					age = "1";
					break;
				case "22<X<=25":
					age = "2";
					break;
				case "25<X<=30":
					age = "3";
					break;
				case ">30":
					age = "4";
					break;
				}
				break;
			}
		}
	}
	
	@CmdOption(names = {"-sort"}, args = {"condition"}, description = "排序（默认按得分降序）")
	private void setSort(String condition) {
		sortBy = condition;
	}
	
	@CmdOption(names = {"-high"}, description = "显示高级数据", requires = {"-n", "-sort"})
	private void setHigh() {
		isHigh = "high";
		if (sortBy.equals("point.desc")) {
			sortBy = "winRate.desc";
		}
	}
}