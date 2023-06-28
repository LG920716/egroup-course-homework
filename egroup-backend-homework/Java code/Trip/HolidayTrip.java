package Trip;

public class HolidayTrip extends Trip {
    public static final int FIX_CHARGE = 500;// 低消

    public HolidayTrip(String name, int days, int miles) {
        super(name, days, miles);
    }

    private double getDaysMilesCharge() {
        return 300 * getDays() * .5 * getMiles();
    }

    public double getCharge() {
        if (getDaysMilesCharge() > FIX_CHARGE) {
            return FIX_CHARGE;
        }
        return getDaysMilesCharge();
    }
}
