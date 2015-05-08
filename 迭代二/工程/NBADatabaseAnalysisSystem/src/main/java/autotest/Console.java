package autotest;
import java.io.PrintStream;

import de.tototec.cmdoption.*;

public class Console {
	
	public void execute(PrintStream out, String[] args) {
		Config config = new Config();
		Player player = new Player();
		CmdlineParser cp = new CmdlineParser(new Object[]{config, player});
		String cmdStr = args[0];
		String[] cmdArr = cmdStr.split("\\s"); //
		try {
			cp.parse(cmdArr[0]);
			cp.parse(cmdArr[1]);
			cp.parse(new String[] { cmdArr[2], cmdArr[3] });
		} catch (CmdlineParserException e) {
			e.printStackTrace();
		}
		if (config.help) {
			System.out.println("-------help---------");
		}
		if (player.isShowTotal()) {
			System.out.println("------total---------");
		}
		System.out.println("the number of player is " + player.getNum());
	}
	
}