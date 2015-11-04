import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

//created and maintained by Sandro Luck
//13-927-769
public class DataSetImporter {
	private final String inputFileName;
	private String outputFileName;
	private FileReader fileReader;
	private BufferedReader bufferedReader;
	private String [] tokens;
	private String lastRaw;
	private PrintWriter writer;
	
	private boolean stop = false;
	
	public DataSetImporter(String inputFileName, String outputFileName){
		this.inputFileName=inputFileName;
		this.outputFileName = outputFileName;
		try {
			this.fileReader = new FileReader(inputFileName);
			this.writer = new PrintWriter(outputFileName);
			initializeDatabase();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.bufferedReader = new BufferedReader(fileReader);
		try {
			while(stop == false){
				lastRaw=bufferedReader.readLine();
				if(lastRaw == null){
					stop = true;
				}else{
					String [] tokens = lastRaw.split("\t");
				    
				    printArrayToFile(tokens);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    writer.close();
	}
	
	private void initializeDatabase(){
		writer.println("CREATE DATABASE movies");
		writer.println("USE movies");
		writer.println("\nCREATE TABLE table");
		writer.println("(");
		writer.println("[wiki_id] int(11) NOT NULL AUTO_INCREMENT,");
		writer.println("[freebase_id] char(20),");
		writer.println("[name] char(35),");
		writer.println("[release_date] date(),");
		writer.println("[box_office] int(),");
		writer.println("[runtime] int(),");
		writer.println("[languages] char(),");
		writer.println("[countries] char(),");
		writer.println("[genres] char(),");
		writer.println(")");
	}
	
	private void printArrayToFile(String[] tokens){
		writer.print("INSERT INTO table VALUES (");
	    for(int i=0; i<tokens.length-1; i++){
	    	writer.print("\'" + tokens[i] + "\', ");
	    }
	    writer.print(tokens[tokens.length-1] + "\')\n" );
	}
}
