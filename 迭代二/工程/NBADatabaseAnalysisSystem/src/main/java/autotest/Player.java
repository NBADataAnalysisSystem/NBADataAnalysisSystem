package autotest;

import de.tototec.cmdoption.CmdOption;

public class Player {
	@CmdOption(names = {"--help", "-h", "-?"}, description = "show help", isHelp = true)
	public boolean help;
}
