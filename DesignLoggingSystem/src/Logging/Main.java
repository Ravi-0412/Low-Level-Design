package Logging;

public class Main {
	
	public static void main(String[] args) {
		
		// Jis sequence me chahte ko check karna us sequence me next ko pass kar do
		// here sequence for check: info -> debug -> error
		LogProcessor logObject = new InfoLogProcessor(new DebugLogProcessor(new ErrorLogProcessor(null)));
		
		logObject.log(LogProcessor.ERROR, "Exception happens");
		logObject.log(LogProcessor.DEBUG, "Needs to debug this");
		logObject.log(LogProcessor.ERROR, "Just for INFO");
	}
	
}
