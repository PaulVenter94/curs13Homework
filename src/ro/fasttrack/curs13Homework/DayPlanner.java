package ro.fasttrack.curs13Homework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DayPlanner {
    private final List<DaySchedule> list;

    public DayPlanner(List<DaySchedule> list) {
        this.list = list;
    }

    public DayPlanner() {
        this.list = new ArrayList<>();
    }

    public void addActivity(DaysOfTheWeek days, String activity) {
        boolean dayExists = false;
        if (activity != null) {
            for (DaySchedule schedule : list) {
                if (schedule.getDay().equals(days)) {
                    schedule.getActivities().add(activity);
                    dayExists = true;
                }
            }
            if (!dayExists) {
                list.add(new DaySchedule(days, new ArrayList<>(List.of(activity))));
            }
        } else {
            throw new NoActivityException();
        }
    }

    public void removeActivity(DaysOfTheWeek days, String activity) {
        for (DaySchedule schedule : list) {
            if (schedule.getDay().equals(days)) {
                if (!(schedule.getActivities().remove(activity))) {
                    throw new NoActivityException();
                }
            }
        }
    }

    public List<String> getActivities(DaysOfTheWeek days) {
        for (DaySchedule schedule : list) {
            if (schedule.getDay().equals(days)) {
                return schedule.getActivities();
            }
        }
        return new ArrayList<>(List.of("No activities for "+days));
    }

    public Map<DaysOfTheWeek, List<String>> endPlanning() throws NoActivitiesForDayException {
        Map<DaysOfTheWeek, List<String>> map = new HashMap<>();
        for (DaySchedule schedule : list) {
            if (schedule.getActivities().size() != 0) {
                map.put(schedule.getDay(), schedule.getActivities());
            } else {
                throw new NoActivitiesForDayException(schedule.getDay());
            }
        }
        return map;
    }

    public List<DaySchedule> getList() {
        return list;
    }

    public DaySchedule getDay(DaysOfTheWeek days) {
        for (DaySchedule schedule : list) {
            if (schedule.getDay().equals(days)) {
                return schedule;
            }
        }
        return null;
    }
}
