public class BusStop {

    private Bus bus;
    private int busStopID = 0;
    private String address; //Name wasn't in description but in UML Diagram

    //Constructor

    public BusStop(String address, Bus bus){
        this.address = address;
        this.bus = bus;
    }

    //Accessors and Mutators

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    public int getBusStopID() {
        return busStopID;
    }

    public void setBusStopID(int busStopID) {
        this.busStopID = busStopID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    //toString

    @Override
    public String toString() {
        return
                "Bus Stop ID: " + busStopID + "\n" +
                "Bus ID: " + getBus().getBusID() + "\n" +
                "Address: " + address + "\n\n";
    }
}
