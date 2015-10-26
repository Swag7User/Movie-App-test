import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//created and maintained by Sandro Luck
//13-927-769
public class DataSetImporter {
	private final String inputFileName;
	private FileReader fileReader;
	private BufferedReader bufferedReader;
	private String [] tokens;
	private String lastRaw;
	
	public DataSetImporter(String inputFileName){
		this.inputFileName=inputFileName;
		try {
			this.fileReader = new FileReader(inputFileName);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.bufferedReader = new BufferedReader(fileReader);
		try {
			lastRaw=bufferedReader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String [] tokens = lastRaw.split("\t");
	    
		String var_1 = tokens[0];
	    String var_2 = tokens[1];
	    String var_3 = tokens[2];
	    String var_4 = tokens[3];
	    String var_5 = tokens[4];
	    String var_6 = tokens[5];
	    
	    System.out.println(tokens[0]+" "+tokens[1]+" "+tokens[2]+" "+tokens[3]+" "+tokens[4]+" "+tokens[5]+" "+tokens[6]);
	}
}
