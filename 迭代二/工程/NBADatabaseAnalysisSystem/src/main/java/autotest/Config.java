package autotest;
import de.tototec.cmdoption.CmdOption;

public class Config {
	@CmdOption(names = { "--help", "-h", "-?" }, description = "show help", isHelp = true)
	public boolean help;
}
