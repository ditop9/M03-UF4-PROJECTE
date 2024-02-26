package location;

public class Concessionaire extends Location {
    private String mainBrand;
    private boolean sellSecondHandVehicle;
    public Concessionaire(String cityLocation, String countryLocation, int workersAmount, String mainBrand, boolean sellSecondHandVehicle) {
        super(cityLocation, countryLocation, workersAmount);
        this.mainBrand = mainBrand;
        this.sellSecondHandVehicle = sellSecondHandVehicle;
    }

    @Override
    public void addNewVehicle() {

    }
}
