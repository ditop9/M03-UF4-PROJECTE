import location.Concessionaire;
import location.Workshop;
import ui.Home;

import java.util.ArrayList;
import java.util.List;

public class App {
    private final List<Concessionaire> concessionaires = new ArrayList<>();
    private final List<Workshop> workshops = new ArrayList<>();

    public static void main(String[] args) {

        Home.runMenu();
    }
}