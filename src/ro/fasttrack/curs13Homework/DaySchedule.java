package ro.fasttrack.curs13Homework;

import java.util.List;
import java.util.Objects;

public class DaySchedule {
    private final DaysOfTheWeek day;
    private final List<String> activities;

    public DaySchedule(DaysOfTheWeek day, List<String> activities) {
        this.day = day;
        this.activities = activities;
    }

    public DaysOfTheWeek getDay() {
        return day;
    }

    public List<String> getActivities() {
        return activities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DaySchedule)) return false;
        DaySchedule schedule = (DaySchedule) o;
        return getDay() == schedule.getDay() &&
                getActivities().equals(schedule.getActivities());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDay(), getActivities());
    }

    @Override
    public String toString() {
        return "DaySchedule{" +
                "day=" + day +
                ", activities=" + activities +
                '}';
    }
}
