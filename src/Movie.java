//created and maintained by Sandro Luck
//13-927-769
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import jdk.nashorn.internal.parser.TokenStream;


public class Movie {
	private int wikiID;
	private String freebaseID;
	private String name;
	private Date releaseDate;
	private int revenue;
	private double runtime;
	private Language language;
	private DateFormat df;
	
	//date formats
	
	public Movie(String raw){
		//String wiki, String freebase,String movie, String dateString, String revenue, String runtime,String [] languageCountryGenre
		String [] tokens = raw.split("\t");
		//in this array is saved if information is missing,true if info available
		boolean [] tokensFlag=new boolean[tokens.length];
		//check format is the same for all
		for (int i = 0; i < tokens.length; i++) {
			if(tokens[i]!=null&&!tokens[i].isEmpty()){
				tokensFlag[i]=true;
			}
		}
		
		
		//wiki id
		if(tokensFlag[0]){
			this.wikiID=Integer.parseInt(tokens[0]);
		}
		//String freebase
		if(tokensFlag[1]){
			this.freebaseID=tokens[1];
		}
		//name has to be set
		if(tokensFlag[2]){
			this.name=tokens[2];
		}
		//covnert string to date
		if(tokensFlag[3]){
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
				try {
					this.releaseDate = df.parse(tokens[3]);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		if(tokensFlag[4]){
			this.revenue=Integer.parseInt(tokens[4]);
		}
		if(tokensFlag[5]){
			this.runtime=Double.parseDouble(tokens[5]);
		}
		this.printMovie();
	}
	//mainly for test reasons
	public void printMovie(){
		System.out.println("WIKI ID:"+this.wikiID+
				"    freebaseID:"+this.freebaseID+
				"    Movie:"+this.name+
				"    release Date:"+this.releaseDate+
				"    revenue:"+this.revenue+
				"    runtime:"+this.runtime
				);
	}
}
