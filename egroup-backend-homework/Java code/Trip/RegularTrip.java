package Trip;

public class RegularTrip extends Trip {

    public RegularTrip(String name, int days, int miles) {
        super(name, days, miles);
    }

    public double getCharge() {
        return (200 * super.getDays() + 1.5 * super.getMiles());
    }
}