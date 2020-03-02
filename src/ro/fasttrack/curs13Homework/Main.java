package ro.fasttrack.curs13Homework;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static ro.fasttrack.curs13Homework.DaysOfTheWeek.*;

public class Main {
    public static void main(String[] args) {
        DayPlanner planner = new DayPlanner();
        try {
            planner.addActivity(MONDAY, "swim");
        } catch (NoActivityException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(planner.getDay(MONDAY));
        planner.removeActivity(MONDAY, "swim");
        System.out.println(planner.getDay(MONDAY));
        planner.addActivity(THURSDAY, "Box");
        planner.addActivity(THURSDAY, "Sleep");
        System.out.println(planner.getDay(THURSDAY));
        try {
            planner.removeActivity(TUESDAY, "Sleep");
        } catch (NoActivityException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(planner.getDay(TUESDAY));
        System.out.println(planner.getActivities(WEDNESDAY));
        try {
            System.out.println(planner.endPlanning());
        } catch (NoActivitiesForDayException e) {
            System.out.println(e.getMessage());
        }
        app();
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

    public static void app() {
        App newApp = new App();
        Scanner scanner = new Scanner(System.in);
        int n;
        do {
            System.out.println(newApp.printMenu());
            System.out.println("Select option:");
            n = scanner.nextInt();
            switch (n) {
                case 1:
                    newApp.addActivity();
                    break;
                case 2:
                    try {
                        newApp.removeActivity();
                    }catch (NoActivityException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println(newApp.getActivities());
                    break;
                case 4:
                    try {
                        System.out.println(newApp.endPlanning());
                    } catch (NoActivitiesForDayException e) {
                        e.getMessage();
                    }
                    break;
            }
        } while (n != 4);
    }
}