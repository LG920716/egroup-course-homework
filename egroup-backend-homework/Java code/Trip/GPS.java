package Trip;

public class GPS implements Rental {
    public double getCharge() {
        return 500;
    }

    public String toString() {
        return "GPS charge:" + getCharge();
    }
}
