package autotest;
import java.io.PrintStream;

import de.tototec.cmdoption.*;

public class Console {
	
	public void execute(PrintStream out, String[] args) {
		Config config = new Config();
		CmdlineParser cp = new CmdlineParser(config);
		cp.registerHandler(new PlayerHandler());
		try {
			cp.parse(args);
		} catch (CmdlineParserException e) {
			e.printStackTrace();
		}
		if (config.help) {
			cp.usage();
		}
		out.println(config.path);
	}
	
}