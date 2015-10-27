//created and maintained by Sandro Luck
//13-927-769
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


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
	
	public Movie(String wiki, String freebase,String movie, String dateString, String revenue, String runtime ){
		
		
		
		//wiki id
		this.wikiID=Integer.parseInt(wiki);
		
		//String freebase
		
		this.freebaseID=freebase;
		
		//name has to be set
		this.name=movie;
		
		//covnert string to date
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
		try {
			this.releaseDate = df.parse(dateString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.revenue=Integer.parseInt(revenue);
		this.runtime=Double.parseDouble(runtime);
		
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
