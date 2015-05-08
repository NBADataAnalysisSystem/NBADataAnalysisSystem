package autotest;

import de.tototec.cmdoption.CmdOption;

public class Player {
	private boolean showTotal = false;
	private int num = 0;

	public boolean isShowTotal() {
		return showTotal;
	}

	@CmdOption(names = { "-total" }, description = "show total", maxCount = 1, minCount = 0)
	public void setShowTotal() {
		this.showTotal = true;
	}

	public int getNum() {
		return num;
	}

	@CmdOption(names = { "-n" }, args = { "filed" }, maxCount = 1, minCount = 0)
	public void setNum(String filed) {
		this.num = Integer.parseInt(filed);
	}
}
