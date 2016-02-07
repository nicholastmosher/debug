import java.io.PrintStream;

/**
 * Created by Nick Mosher on 2/2/16.
 * This is a set of debug functions inspired by the debug macros from
 * c.learncodethehardway.org.
 */
public class Debug {

    private static boolean mDebug;

    public static void setDebug(boolean debug) {
        mDebug = debug;
    }

    /**
     * Prints a mDebug message to standard out.
     * @param message The mDebug message to print.
     */
    public static void debug(String message) {
        if(mDebug) {
            System.out.println("DEBUG (" + getFilename() + ":" + getLineNumber() + ") " +  message);
        }
    }

    /**
     * Prints a debug message on the given PrintStream.
     * @param message The message to print.
     * @param stream The PrintStream to print on.
     */
    public static void debug(String message, PrintStream stream) {

        if(mDebug) {
            stream.println("DEBUG (" + getFilename() + ":" + getLineNumber() + ") " +  message);
        }
    }

    /**
     * Prints an error to standard err.
     * @param error The error to print.
     */
    public static void logError(String error) {

        System.out.println("[ERROR] (" + getFilename() + ":" + getLineNumber() + ") " + error);
    }

    /**
     * Prints an error to the given PrintStream.
     * @param error The error to print.
     * @param stream The PrintStream to print on.
     */
    public static void logError(String error, PrintStream stream) {

        stream.println("[ERROR] (" + getFilename() + ":" + getLineNumber() + ") " + error);
    }

    /**
     * Prints a warning to standard out.
     * @param warning The warning to print.
     */
    public static void logWarning(String warning) {
        logWarning(warning, System.out);
    }

    /**
     * Prints a warning to the given PrintStream.
     * @param warning The warning to print.
     * @param stream The PrintStream to print on.
     */
    public static void logWarning(String warning, PrintStream stream) {

        stream.println("[WARNING] (" + getFilename() + ":" + getLineNumber() + ") " + warning);
    }

    /**
     * Prints an info message to standard out.
     * @param message The message to print.
     */
    public static void logInfo(String message) {

        System.out.println("[INFO] (" + getFilename() + ":" + getLineNumber() + ") " + message);
    }

    /**
     * Prints an info message to standard out.
     * @param message The message to print.
     * @param stream The PrintStream to print on.
     */
    public static void logInfo(String message, PrintStream stream) {

        stream.println("[INFO] (" + getFilename() + ":" + getLineNumber() + ") " + message);
    }

    /**
     * Prints an error if the given condition is false.
     * @param condition The condition to evaluate.
     * @param message The error to print.
     */
    public void check(boolean condition, String message) {

        if(!condition) {
            System.err.println("[ERROR] (" + getFilename() + ":" + getLineNumber() + ") " + message);
        }
    }

    /**
     * Returns the name of the file that called a Debug function.
     * @return The filename.
     */
    private static String getFilename() {
        return Thread.currentThread().getStackTrace()[3].getFileName();
    }

    /**
     * Returns the line number where a Debug function was called.
     * @return The line number.
     */
    private static String getLineNumber() {
        return String.valueOf(Thread.currentThread().getStackTrace()[3].getLineNumber());
    }
}
