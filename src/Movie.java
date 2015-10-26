//created and maintained by Sandro Luck
//13-927-769
import java.util.Date;

public class Movie {
	private int wikiID;
	private int freebaseID;
	private String name;
	private Date releaseDate;
	private int revenue;
	private int runtime;
	private Language language;
	
	public Movie(String movie){
		//name has to be set
		this.name=movie;
		
	}
}
