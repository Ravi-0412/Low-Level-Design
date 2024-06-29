package Logging;

public class ErrorLogProcessor extends LogProcessor{
	
	public ErrorLogProcessor(LogProcessor nexLogProcessor) {
		super(nexLogProcessor);
	}
	
	@Override
	public void log(int logLevel, String message) {
		if(logLevel == ERROR) {
			System.out.println("ERROR: " + message);
		}
		else {
			super.log(logLevel, message);
		}
	}

}