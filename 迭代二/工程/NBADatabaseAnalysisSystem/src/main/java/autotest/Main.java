package autotest;

public class Main {

	public static void main(String[] args) throws Exception {
		Console console = new Console();
		console.execute(System.out, new String[]{"-player"});
		//console.execute(System.out, new String[]{"-player","-all","-n","10"});
		//console.execute(System.out, new String[]{"-player","-high","-n","10","-sort","frequency.desc"});
		//console.execute(System.out, new String[]{"-player","-hot","assist","-n","5"});
		//console.execute(System.out, new String[]{"-player","-king","score","-season"});
		//console.execute(System.out, new String[]{"-player","-avg","-n","5","-filter","position.F"});
		//console.execute(System.out, new String[]{"-player","-total","-all","-n","10","-filter","position.F,league.West","-sort","shot.desc"});
		//console.execute(System.out, new String[]{"--datasource","d:/nba/data"});
	}

}
