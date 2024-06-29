package Logging;

public abstract class LogProcessor {
	
	LogProcessor nextLogProcessor;  // next me kiska log ko call karna h
	
	// Jiske pass next h usko hi call karna h ki nhi iske liye
	public static int INFO =   1;
	public static int DEBUG =  2;
	public static int ERROR = 3;
	
	// jiske pass log h agar usse logLevel match nhi kiya to super() constructor ko call kar dega
	// next wale ko bhejne ke liye
	LogProcessor(LogProcessor logProcessor) {
		this.nextLogProcessor = logProcessor;
	}
	
	public void log(int logLevel , String message) {
		if(nextLogProcessor != null) {
			// agar sb process nhi kiya h then next wale ke pass bhej dega jb hm parent ka(is class) 'log' call kareneg tb
			nextLogProcessor.log(logLevel, message) ;
		}
	}

}
