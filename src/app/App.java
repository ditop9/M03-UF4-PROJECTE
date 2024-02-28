package app;

import interfaces.LoadData;
import location.Concessionaire;
import location.Workshop;
import ui.Home;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static final List<Concessionaire> concessionaires = new ArrayList<>();
    public static final List<Workshop> workshops = new ArrayList<>();


    public static void main(String[] args) {
        LoadData.loadData();
        Home.runMenu();
    }
    public static void showAvailableLocations(List<?> locations) {
        for (int i = 0; i < locations.size(); i++) {
            System.out.println((i + 1) + ". " + locations.get(i));
        }
    }
    public static Object chooseLocation(List<?> locations, int index) {
        try {
            return locations.get(index);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }
    public static void addConcessionaire(Concessionaire c) {
        concessionaires.add(c);
    }
    public static void addWorkshop(Workshop w) {
        workshops.add(w);
    }
}