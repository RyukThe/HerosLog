package log4j;

import org.apache.logging.log4j.*;

public class Log4J2 
{
	private static final Logger log= LogManager.getLogger(Log4J2.class.getName());
	
	public static void main(String[] args) 
	{
	
	
	System.out.println("keilo");
	log.debug("debug this ");
	
	log.always();
		
	}

}
