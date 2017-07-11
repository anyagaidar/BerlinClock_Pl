import java.util.Arrays;
import java.util.Collections;

/**
 * Created by Анна on 03.07.2017.
 */
public class BerlinClock {
    private String formattedTime;
    private static final String NEW_LINE = System.getProperty("line.separator");
    private static final String NO_TIME_ERROR = "Please, enter the time";
    private static final String INVALID_TIME_ERROR = "Invalid time";
    private static final String NUMERIC_TIME_ERROR = "Time must be numeric format";

    public BerlinClock(String time) {
        if(time == null) {
            throw new IllegalArgumentException(NO_TIME_ERROR);
        }

        String[] times = time.split(":", 3);
        if(times.length != 3) throw new IllegalArgumentException(INVALID_TIME_ERROR);
        int hours;
        int minutes;
        int seconds;
        try {
            hours = Integer.parseInt(times[0]);
            minutes = Integer.parseInt(times[1]);
            seconds = Integer.parseInt(times[2]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMERIC_TIME_ERROR);
        }
        if (hours < 0 || hours > 23) throw new IllegalArgumentException("Hours are not correct, should be between 0 to 23");
        if (minutes < 0 || minutes > 59) throw new IllegalArgumentException("Minutes are not correct, should be between 0 to 59");
        if (seconds < 0 || seconds > 59) throw new IllegalArgumentException("Seconds are not correct, should be between 0 to 59");
        formattedTime = processTime(hours, minutes, seconds);
    }

    public String processTime(int hours, int minutes, int seconds) {
        String line1 = (seconds % 2 == 0) ? "Y" : "0";
        String line2 = rowString(hours / 5, 4, "R");
        String line3 = rowString(hours % 5, 4, "R");
        String line4 = rowString(minutes / 5, 11, "Y").replace("YYY", "YYR");
        String line5 = rowString(minutes % 5, 4, "Y");
        return String.join(NEW_LINE, Arrays.asList(line1, line2, line3, line4, line5));
    }

    public String rowString(int litLights, int lightsInRow, String lampType) {
        int unlitLights = lightsInRow - litLights;
        String lit = String.join("", Collections.nCopies(litLights, lampType));
        String unlit = String.join("", Collections.nCopies(unlitLights, "0"));
        return lit + unlit;
    }

    public void printTime() {
        System.out.println(formattedTime);
    }

    @Override
    public String toString() {
        return formattedTime;
    }
}
