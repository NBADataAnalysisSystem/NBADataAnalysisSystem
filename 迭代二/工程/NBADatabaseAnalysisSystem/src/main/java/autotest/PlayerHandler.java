package autotest;

import java.lang.reflect.AccessibleObject;

import de.tototec.cmdoption.handler.CmdOptionHandler;
import de.tototec.cmdoption.handler.CmdOptionHandlerException;

public class PlayerHandler implements CmdOptionHandler {

	public void applyParams(Object arg0, AccessibleObject arg1, String[] arg2,
			String arg3) throws CmdOptionHandlerException {
	}

	public boolean canHandle(AccessibleObject arg0, int arg1) {
		return false;
	}

}
