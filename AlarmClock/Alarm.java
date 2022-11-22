package AlarmClock;
import java.net.*;
import java.util.concurrent.TimeUnit;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

 class time {
	  int seconds,minutes,hours;
	  public static final long CURRENT_TIME_MILLIS = System.currentTimeMillis();

	  
		      
	  
	  public void input() {
		//   System.out.println(System.currentTimeMillis()/1000);
		  Scanner in=new Scanner(System.in);
		  System.out.println("Please enter the Hour in HH format");
		  hours=in.nextInt();
		  System.out.println("Please enter the Minutes in MM format");

		  minutes=in.nextInt();
		  System.out.println("Please enter the Seconds in SS format");

		  seconds=in.nextInt();
		  
	  }
	  void secconvert() {
		  
		  hours=hours*3600;
		  minutes=minutes*60;
		  seconds=seconds;
		  
	  }
	  public void start() {
		  Date instant = new Date(CURRENT_TIME_MILLIS);
		     SimpleDateFormat sdf = new SimpleDateFormat( "HH:mm:ss" );
		     String time = sdf.format( instant );
		    
		     String[] str=time.split(":",3);
		    
		      int[] x=new int[3];
		      int i=0;
		      for(String s:str) {
		    	  x[i]=Integer.parseInt(s);
		    	  i++;
		      }
		      int h1=x[0]*3600;
		      int m1=x[1]*60;
		      int s1=x[2];
		      int total1=h1+m1+s1;
		      
		     
		      int totalsec=hours+minutes+seconds;
		      int diff=totalsec-total1;
		      long diffsec=(System.currentTimeMillis()/1000)+(diff);
		      System.out.println(diffsec);
		      System.out.println(System.currentTimeMillis()/1000);
		      
		      
		      
		      while((System.currentTimeMillis()/1000)<(diffsec)) {
		    	  System.out.println(diffsec - (System.currentTimeMillis()/1000) + " seconds left in the alarm");
		    	  try {  Thread.sleep(1000);
		    	  }
		    	  catch(InterruptedException e) {
		    		Thread.currentThread().interrupt();
		    		
		    	  }
		      }
			  System.out.println("The alarm is beeping");
			  Scanner in = new Scanner(System.in);
			  int snooze_timer = 0;
				while(snooze_timer!=3){
					System.out.println("type yes if wanted to snooze or no to stop the alarm");

					String snooze = in.next();
					if(snooze.equals("yes")){
						snooze_timer+=1;
						int counter = 300;
						while(counter>=0){
							try {  Thread.sleep(1000);
							}
							catch(InterruptedException e) {
							  Thread.currentThread().interrupt();
							  
							}
							System.out.println(counter + " seconds left in snoozing");
							counter--;
						}
						System.out.println("The alarm is beeping");
					}else{
						System.out.println("alarm is off");
						break;
					}
				}
		      
		      }
		      
	  }    
	  


	  public class Alarm extends time{
	
		public static void main(String[] args) {
			
			 
			
			
			   
			 Alarm ob=new Alarm();
		 
			 ob.input();
			 ob.secconvert();
			 ob.start();
			 
	
			
			
		}
	}
	
	
	