import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class GameController {
	
	final int SafeLandingVelocity = 5;
	
	SpaceCraft mySpaceCraft;
	
	public GameController(){
		mySpaceCraft = new SpaceCraft();
		mySpaceCraft.init();
	}
	
	public SpaceCraft getSpaceCraft(){
		return this. mySpaceCraft;
	}
	
	public void run(){
	    //Send welcome message
	    System.out.println("#Welcome to Lunar Lander");
	    
	    try{
	      //Begin reading from System input
	      BufferedReader inputReader =
	      new BufferedReader(new InputStreamReader(System.in));
	      //Set initial burn rate to 0
	      int burnRate = 0;
	      do{
	        //Prompt user for burn rate and read user response
	        System.out.println("#Enter burn rate or <0 to quit:");
	        try{
	          String burnRateString = inputReader.readLine();
	          burnRate = Integer.parseInt(burnRateString);
	        } catch(NumberFormatException nfe){
		          System.out.println("#Invalid burn rate.");
		          continue;
		    }
	        if (burnRate >=0){
		        mySpaceCraft.setBurnRate(burnRate);
		        //Calculate new status
		        try {
			        mySpaceCraft.calcNewValues();	        	
		        } catch (Exception e){
		        	System.out.println(e.getMessage());
		        	continue;
		        }
		        //Display new status
		        mySpaceCraft.displayValues();
		        //Check if game is over
		        if (checkGameResult()>0){
		        	break;
		        }	        	        	
	        }
	      }
	      while(burnRate >= 0);
	      inputReader.close();
	    } catch(IOException ioe){
	      ioe.printStackTrace();
	    }
		
	}
	
	public int checkGameResult(){
        if(mySpaceCraft.getAltitude() == 0){
        	System.out.println("#Game is over.");
        	if(mySpaceCraft.getVelocity() <= SafeLandingVelocity){
        		System.out.println("#You have landed safely.");
        		return 1;	
        	} else{
        		System.out.println("#You have crashed.");
        		return 2;
        	}
        } else {
        	return 0;
        }
	}

}
