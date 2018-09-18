package baseball;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Stats {

	String name;
	double hits;
	double atBats;
	double doubles;
	double triples;
	double hr;
	double r;
	double bb;
	
	Stats(String nameIn, double abIn, double hitsIn, double doublesIn, 
			double triplesIn, double hrIn, double rIn, double bbIn) {
		name = nameIn;
		hits = hitsIn;
		atBats = abIn;
		doubles = doublesIn;
		triples = triplesIn;
		hr = hrIn;
		r = rIn;
		bb = bbIn;
	}
	
	



	public double BA() {
		return hits / atBats;
	}
	
	public double OBP() {
		return (hits + bb)/(atBats + bb);
	}
	
	public int totalBases() {
		int singles = (int) (hits - (hr + triples + doubles));
		return (int)(singles + (2*doubles) + (3*triples) + (4*hr));
	}
	
	public double SLG() {
		return (double)(this.totalBases()) / atBats;
		
	}
	
	public double OPS() {
		return this.OBP()+this.SLG();
	}
	
	
	public static void main(String args[]) {
		DecimalFormat df = new DecimalFormat(".###");
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter player name : ");
			String name = scan.nextLine();
		System.out.println("At Bats : ");
			double ab = scan.nextDouble();
		System.out.println("Hits : ");
			double hits = scan.nextDouble(); 
		System.out.println("Doubles : ");
			double doubles = scan.nextDouble();
		System.out.println("Triples : ");
			double triples = scan.nextDouble();
		System.out.println("Home Runs : ");
			double hr = scan.nextDouble();
		System.out.println("Runs : ");
			double r = scan.nextDouble();
		System.out.println("BB : ");
			double bb = scan.nextDouble();
			
		Stats player = new Stats(name, ab, hits, doubles, triples, hr, r, bb);
		scan.close();
		
		System.out.println("Player Name : " + (player.name) + "\nBatting Avg : " + df.format(player.BA()) + "\nOBP : " 
		+ df.format(player.OBP()) + "\nSLG : " + df.format(player.SLG()) + "\nOPS : " + df.format(player.OPS()) + "\nTotal Bases : " + player.totalBases());
	}
	
}
