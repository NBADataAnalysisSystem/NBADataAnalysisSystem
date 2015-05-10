package autotest;

import de.tototec.cmdoption.CmdOption;

public class Team {
	public String isAll = "all";
	public String isAvg = "avg";
	public String hotField;
	public String number = "30";
	public String isHigh = "normal";
	public String sortBy = "score.desc";
	
	@CmdOption(names = {"--help", "-h", "-?"}, description = "显示帮助信息", isHelp = true)
	public boolean help;
	

	@CmdOption(names = {"-all"}, description = "显示所有球队数据（默认）", conflictsWith = {"-hot"})
	private void setAll() {
		isAll = "all";
	}
	
	@CmdOption(names = {"-hot"}, args = {"field"}, 
			description = "显示热点球队", 
			conflictsWith = {"-avg", "-total", "-sort", "-all"})
	private void setHot(String field) {
		isAll = "hot";
		hotField = field;
		number = "5";
	}
	
	@CmdOption(names = {"-avg"}, description = "显示球队赛季平均数据（默认）", conflictsWith = {"-total"})
	private void setAvg() {
		isAvg = "avg";
	}
	
	@CmdOption(names = {"-total"}, description = "显示球队赛季总数据", conflictsWith = {"-avg"})
	private void setTotal() {
		isAvg = "total";
	}
	

	@CmdOption(names = {"-n"}, args = {"number"}, description = "显示的条目数（默认30）")
	private void setNumber(String number) {
		this.number = number;
	}
	
	@CmdOption(names = {"-sort"}, args = {"condition"}, description = "排序（默认按得分降序）")
	private void setSort(String condition) {
		sortBy = condition;
	}
	
	@CmdOption(names = {"-high"}, description = "显示高级数据", requires = {"-n", "-sort"})
	private void setHigh() {
		isHigh = "high";
		if (sortBy.equals("score.desc")) {
			sortBy = "winRate.desc";
		}
	}
}
