package autotest;

public class Main {

	public static void main(String[] args) {
		Console console = new Console();
		console.execute(null, new String[]{"--help -total -n 5"});
	}

}
