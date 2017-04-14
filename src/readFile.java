import java.io.BufferedReader;
import java.io.FileReader;

// reads given input. 
public class readFile {

	private BufferedReader br;
	
	//function splits line, checks first pair if it is negative or not. Then adds splitted line to two dimensional array.
	public String[][] read_file(String path) throws Exception {


		try {

			br = new BufferedReader(new FileReader(path));

			int i = 0;
			int lenght = Integer.parseInt(br.readLine());
			String line = null;
			String[][] lines = new String[lenght][2];



			while ((line = br.readLine()) != null) {

				lines[i][0] = line.trim().split("\t")[0];
				lines[i][1] = line.trim().split("\t")[1];
				if(Long.parseLong(lines[i][0]) < 0)//checks if weight is negative or not
					throw new IllegalArgumentException(lines[i][0]);
				i++;
				
			} 

			return lines;
		} catch(Exception e) {
			System.out.println("Weight cannot be negative"); //weight is negative. function returns null.
			
			return null;

		}
	}
}