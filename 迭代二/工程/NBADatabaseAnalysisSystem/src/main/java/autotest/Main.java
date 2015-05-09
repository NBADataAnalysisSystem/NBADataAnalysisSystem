package autotest;

public class Main {

	public static void main(String[] args) {
		Console console = new Console();
		console.execute(System.out, new String[]{"-player", "-total -n 5"});
	}

}
