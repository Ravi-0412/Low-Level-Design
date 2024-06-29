package Logging;

public class InfoLogProcessor extends LogProcessor{
	
	// contructor bnate samay hi btana hoga ki iska 'next' kon h
	public InfoLogProcessor(LogProcessor nexLogProcessor) {
		super(nexLogProcessor);
	}
	
	@Override
	public void log(int logLevel, String message) {
		if(logLevel == INFO) {
			System.out.println("INFO: " + message);
		}
		else {
			// apne super ko call karega taki iska next ke pass ye ja sake 
			super.log(logLevel, message);
		}
	}

}
