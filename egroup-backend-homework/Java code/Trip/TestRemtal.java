package Trip;

public class TestRemtal {
    private GPS gps;
    private Trip trip;

    public TestRemtal(Trip trip) {
        this.gps = null;
        this.trip = trip;
    };

    public TestRemtal(GPS gps, Trip trip) {
        this.gps = gps;
        this.trip = trip;
    }

    private int max = 10;
    private TestRemtal allRemtals[] = new TestRemtal[max];
    private int numOfRemtals;

    public TestRemtal() {
        allRemtals[0] = new TestRemtal(new RegularTrip("A", 3, 100));
        allRemtals[1] = new TestRemtal(new GPS(), new RegularTrip("A", 3, 100));
        numOfRemtals = 2;
    }

    public double getTotalTripCharge() {
        double total = 0;
        for (int i = 0; i < numOfRemtals; i++) {
            if(allRemtals[i].gps == null){
                total+=allRemtals[i].trip.getCharge();
            }else{
                total+=allRemtals[i].gps.getCharge();
                total += allRemtals[i].trip.getCharge();
            }
        }
        return total;
    }

    public static void main(String args[]) {
        TestRemtal remtal = new TestRemtal();
        System.out.println(remtal.getTotalTripCharge());
    }

}
