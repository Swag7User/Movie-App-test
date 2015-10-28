//created and maintained by Sandro Luck
//13-927-769
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;

public class Movie {
	private int wikiID;
	private String freebaseID;
	private String name;
	private Calendar releaseCalender;
	private double revenue;
	private double runtime;
	private DateFormat df;
	
	private ArrayBlockingQueue<String>language;
	private ArrayBlockingQueue<String>languageCode;
	private String []temporary;
	private String []temporaryTuple;
	
	private Date date;
	 //Set to whatever date you want as default

	
	//date formats
	
	public Movie(String raw){
		//String wiki, String freebase,String movie, String dateString, String revenue, String runtime,String [] languageCountryGenre
		releaseCalender = Calendar.getInstance();
		df = new SimpleDateFormat("yyyy-MM-dd"); 
		String [] tokens = raw.split("\t");
		language=new ArrayBlockingQueue<String>(10);
		languageCode=new ArrayBlockingQueue<String>(10);
		
		
		
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
			
			  
			
			if(tokens[3].length()==4){
				releaseCalender.set(Calendar.YEAR, Integer.parseInt(tokens[3]));
			}
			else if(tokens[3].length()==7){
				releaseCalender.set(Calendar.YEAR, Integer.parseInt(tokens[3].substring(0, 3)));
				releaseCalender.set(Integer.parseInt(tokens[3].substring(0, 3)), Integer.parseInt(tokens[3].substring(5, 6)), 0);
			}
			else{

					try {
						this.date = df.parse(tokens[3]);
						releaseCalender.setTime(date);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		}
		if(tokensFlag[4]){
			this.revenue=Double.parseDouble(tokens[4]);
		}
		if(tokensFlag[5]){
			this.runtime=Double.parseDouble(tokens[5]);
		}
		if(tokensFlag[6]){
			//take strig apart too save all in language array
			
			//first split at "," to take apart bsp.: {"/m/064_8sq": "French Language", "/m/05zjd": "Portuguese Language", "/m/02h40lc": "English Language"}
			tokens[6].replace("{", "");
			tokens[6].replace("}", "");
			//bsp.:"/m/064_8sq": "French Language", "/m/05zjd": "Portuguese Language", "/m/02h40lc": "English Language"		
			tokens[6].replace("\"","");
			//bsp.:/m/064_8sq: French Language, /m/05zjd: Portuguese Language, /m/02h40lc: English Language
			temporary=tokens[6].split(",");
			//bsp.:/m/064_8sq: French Language gggg
			for (int i = 0; i < temporary.length; i++) {
				temporaryTuple=temporary[i].split(":");
				if(temporaryTuple.length>=2){
					//bsp.:/m/064_8sq    bsp.: French Language
					
					System.out.println("temp:"+temporary[i]);
					if(temporaryTuple[0]!=null&&!temporaryTuple[0].isEmpty()){
						temporaryTuple[0].trim();
						languageCode.add(temporaryTuple[0]);
					}
					if(temporaryTuple[1]!=null&&!temporaryTuple[1].isEmpty()){
						temporaryTuple[1].trim();
						language.add(temporaryTuple[1]);
					}
				}
			}
		}
		//this.printMovie();
	}
	//mainly for test reasons
	public void printMovie(){
		System.out.println("WIKI ID:"+this.wikiID+
				"    freebaseID:"+this.freebaseID+
				"    Movie:"+this.name+
				"    release Date:"+this.releaseCalender+
				"    revenue:"+this.revenue+
				"    runtime:"+this.runtime
				);
	}
}
