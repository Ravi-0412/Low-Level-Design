package Logging;

public class DebugLogProcessor extends LogProcessor{
	
	public DebugLogProcessor(LogProcessor nexLogProcessor) {
		super(nexLogProcessor);
	}
	
	@Override
	public void log(int logLevel, String message) {
		if(logLevel == DEBUG) {
			System.out.println("DEBUG: " + message);
		}
		else {
			super.log(logLevel, message);
		}
	}

}
