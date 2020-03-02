package ro.fasttrack.curs13Homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class App {
    private DayPlanner planner;

    public App(DayPlanner planner) {
        this.planner = planner;
    }

    public App() {
        this.planner = new DayPlanner();
    }

    public String printMenu() {
        return "1) add an activity\n" +
                "\n" +
                "2) remove an activity\n" +
                "\n" +
                "3) list all activities\n" +
                "\n" +
                "4) end planning";
    }

    public void addActivity() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Day: ");
        String day = scanner.next();
        System.out.println("Activity: ");
        String activity = scanner.next();
        planner.addActivity(DaysOfTheWeek.valueOf(day), activity);
    }

    public void removeActivity() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Day: ");
        String day = scanner.next();
        System.out.println("Activity: ");
        String activity = scanner.next();
        planner.removeActivity(DaysOfTheWeek.valueOf(day), activity);
    }

    public List<DaySchedule> getActivities() {
        return planner.getList();
    }

    public Map<DaysOfTheWeek, List<String>> endPlanning() throws NoActivitiesForDayException {
        return planner.endPlanning();
    }
}
