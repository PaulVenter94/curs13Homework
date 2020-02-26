package ro.fasttrack.curs13Homework;

import java.util.ArrayList;
import java.util.List;

import static ro.fasttrack.curs13Homework.DaysOfTheWeek.*;

public class Main {
    public static void main(String[] args) {
        DayPlanner planner = new DayPlanner(getList());
        try {
            planner.addActivity(MONDAY, null);
        } catch (NoActivityException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(planner.getDay(MONDAY));
        try {
            planner.removeActivity(TUESDAY, "Sleep");
        } catch (NoActivityException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(planner.getDay(TUESDAY));
        System.out.println(planner.getActivities(WEDNESDAY));
        planner.removeActivity(THURSDAY, "Football");
        planner.removeActivity(THURSDAY, "Cooking");
        try {
            System.out.println(planner.endPlanning());
        } catch (NoActivitiesForDayException e) {
            System.out.println(e.getMessage());
        }
    }

    public static List<DaySchedule> getList() {
        DaySchedule schedule = new DaySchedule(MONDAY, new ArrayList<String>(List.of("Chess", "Running")));
        DaySchedule schedule2 = new DaySchedule(TUESDAY, new ArrayList<String>(List.of("Gaming", "Powerlifting")));
        DaySchedule schedule3 = new DaySchedule(WEDNESDAY, new ArrayList<String>(List.of("Reading", "Swimming")));
        DaySchedule schedule4 = new DaySchedule(THURSDAY, new ArrayList<String>(List.of("Cooking", "Football")));
        DaySchedule schedule5 = new DaySchedule(FRIDAY, new ArrayList<String>(List.of("Mental Breakdown")));
        DaySchedule schedule6 = new DaySchedule(SATURDAY, new ArrayList<String>(List.of("JavaExtraMile", "Running")));
        DaySchedule schedule7 = new DaySchedule(SUNDAY, new ArrayList<String>(List.of("Sleep", "Go get fresh air")));
        List<DaySchedule> list = new ArrayList<>();
        list.add(schedule);
        list.add(schedule2);
        list.add(schedule3);
        list.add(schedule4);
        list.add(schedule5);
        list.add(schedule6);
        list.add(schedule7);
        return list;
    }
}
