
import java.util.Scanner;

public class main {

	public static void main(String[] args) throws Exception {
		
		Scanner input = new Scanner(System.in);
		buildClass build = new buildClass();
		
		while(true){
			try{
				System.out.println("Please write <text_file> <pair> <key>. (Enter e or E to exit)");//press tab between arguments
				String t = input.nextLine();
				if(t.equals("e") || t.equals("E"))//for exit
					break;
				String txt = t.split("\t")[0];
				int pair = Integer.parseInt(t.split("\t")[1]);
				String key = t.split("\t")[2];
				
				build.start(txt, pair, key);//starts function
				System.out.println();
			}
			catch (Exception e) {
				System.out.println("Input Error! Correct format is \"<txt> tab <pair> tab <key>\". Try again.\n");
			}
			
			
			
		}

	}

}
