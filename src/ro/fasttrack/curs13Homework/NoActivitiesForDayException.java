package ro.fasttrack.curs13Homework;

public class NoActivitiesForDayException extends Exception {


    public NoActivitiesForDayException(DaysOfTheWeek day) {
        super("No activities for day " + day);
    }
}
