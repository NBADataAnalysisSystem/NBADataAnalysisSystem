package autotest;

import de.tototec.cmdoption.CmdOption;

public class Team {
	@CmdOption(names = {"--help", "-h", "-?"}, description = "show help", isHelp = true)
	public boolean help;
}
