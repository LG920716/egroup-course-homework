package Trip;

public class TestGPS {
    private final int MAX = 10;
    private Rental allRental[] = new Rental[MAX];
    private int numOfRental = 0;

    public TestGPS() {
        allRental[0] = new GPS();
        allRental[1] = new GPS();
        numOfRental = 2;
    }

    public double getTotalRentalCharges() {
        double total = 0;
        for (int i = 0; i < numOfRental; i++) {
            total += allRental[i].getCharge();
        }
        return total;
    }

    public void showAllRentals() {
        for (int i = 0; i < numOfRental; i++) {
            System.out.println("Rental " + (i + 1) + ": " + allRental[i]);
        }
        System.out.println();
    }

    public void run() {
        showAllRentals();
        System.out.println(getTotalRentalCharges());
    }

    public static void main(String args[]) {
        TestGPS gps = new TestGPS();
        gps.run();
    }
}
