package interfaces;

import app.App;
import location.Concessionaire;
import location.Workshop;

public interface LoadData {
    static void loadData() {
        Concessionaire c1 = new Concessionaire("Barcelona", "Spain", 22, "Volkswagen", true);
        Concessionaire c2 = new Concessionaire("Madrid", "Spain", 18, "Ford", false);
        Concessionaire c3 = new Concessionaire("Paris", "France", 30, "Renault", true);
        Concessionaire c4 = new Concessionaire("Rome", "Italy", 25, "Fiat", false);
        Concessionaire c5 = new Concessionaire("Berlin", "Germany", 20, "BMW", true);

        Workshop w1 = new Workshop("Barcelona", "Spain", 15, "Taller del Motor");
        Workshop w2 = new Workshop("Madrid", "Spain", 20, "Mechanical Masters");
        Workshop w3 = new Workshop("Lyon", "France", 12, "Speedy Fix");
        Workshop w4 = new Workshop("Milan", "Italy", 18, "Car Care Center");
        Workshop w5 = new Workshop("Berlin", "Germany", 22, "Auto Tech");

        App.addConcessionaire(c1);
        App.addConcessionaire(c2);
        App.addConcessionaire(c3);
        App.addConcessionaire(c4);
        App.addConcessionaire(c5);

        App.addWorkshop(w1);
        App.addWorkshop(w2);
        App.addWorkshop(w3);
        App.addWorkshop(w4);
        App.addWorkshop(w5);
    }
}
