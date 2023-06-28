package Trip;

public class TestTrip {
    private int max = 10;

    // 這裡是多型的概念
    private Trip allTrips[] = new Trip[max];
    private int numOfTrips;

    public TestTrip() {
        allTrips[0] = new RegularTrip("A", 3, 100);
        allTrips[1] = new HolidayTrip("B", 4, 200);
        allTrips[2] = new HolidayTrip("C", 1, 100);
        allTrips[3] = new HolidayTrip("D", 1, 300);
        allTrips[4] = new RegularTrip("E", 3, 300);
        numOfTrips = 5;
    }

    public double getTotalTripCharge() {
        double total = 0;
        for (int i = 0; i < numOfTrips; i++) {
            total += allTrips[i].getCharge();
        }
        return total;
    }

    public void showAllTrips() {
        for (int i = 0; i < numOfTrips; i++) {
            System.out.println("Trip " + (i + 1) + ": " + allTrips[i]);
        }
        System.out.println();
    }

    public void run() {
        showAllTrips();
        System.out.println(getTotalTripCharge());
    }

    public static void main(String args[]) {
        TestTrip trips = new TestTrip();
        trips.run();
    }
}
