import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

//created and maintained by Sandro Luck
//13-927-769
public class DataSetImporter {
	private final String inputFileName;
	private FileReader fileReader;
	private BufferedReader bufferedReader;
	
	public DataSetImporter(String inputFileName){
		this.inputFileName=inputFileName;
		try {
			this.fileReader = new FileReader(inputFileName);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.bufferedReader = new BufferedReader(fileReader);
		
	}
}
