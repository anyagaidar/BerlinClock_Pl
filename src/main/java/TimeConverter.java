/**
 * Created by Анна on 02.07.2017.
 */
public class TimeConverter {
    public static void main(String[] args) {
        String gmt = "07:34:9";
        BerlinClock time = new BerlinClock(gmt);
        System.out.println("GMT time is: \n" + gmt);
        System.out.println("\nBerlin clock shows: ");
        time.printTime();
    }


}
