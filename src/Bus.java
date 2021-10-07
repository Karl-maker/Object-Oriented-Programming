import java.util.ArrayList;

public class Bus {

    private int busID;
    private String model;
    private int numPassengers, numBusStops;
    private ArrayList<BusStop> busStops = new ArrayList<BusStop>( );

    //Constructor

    public Bus(String model, int numPassengers){
        this.model = model;
        this.numPassengers = numPassengers;
        this.numBusStops = 0; //It always should start at 0 and increase as they are added
    }

    //Assessors and Mutators


    public int getBusID() {
        return busID;
    }

    public void setBusID(int busID) {
        this.busID = busID;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getNumPassengers() {
        return numPassengers;
    }

    public void setNumPassengers(int number){
        this.numPassengers = number;
    }

    public int getNumBusStops() {
        return numBusStops;
    }

    public void setNumBusStops(int number){
        this.numBusStops = number;
    }

    //Update Number of Bus Stops

    public void updateNumStops(){
        this.numBusStops = busStops.size();
    }

    //Methods

    public Boolean addBusStop(String address){

        //Check if bus stop is already exists
        int index = 0;

        while(busStops.size() > index){
            if (address.equals(busStops.get(index).getAddress())){
                return false;
            }
            index++;
        }

        //Creates Bus then copies all data within the class that created it, into this one

        Bus bus = new Bus(this.model, this.numPassengers);

        /*
        Pass all relevant info into bus Object but he List of BusStops
        Reason being in memory that might cause a infinite loop.
        */

        bus.setBusID(this.busID);
        bus.setNumBusStops(getNumBusStops()+1); //Because BusStop needs to take an updated number

        BusStop busStop = new BusStop(address, bus);
        ///busStop.setBusStopID();

        busStops.add(busStop);
        updateNumStops();
        busStops.get(busStops.size() - 1).setBusStopID(1000+ (10 * (busStops.size() - 1)));

        //Update all Bus within the BusStops

        index = 0;

        while(busStops.size() > index){
            busStops.get(index).getBus().setNumBusStops(getNumBusStops());
            index++;
        }

        return true;
    }

    public BusStop getBusStop(int busStopID){

        int index = 0;

        while(busStops.size() > index){
            if(busStopID == busStops.get(index).getBusStopID()){
                return busStops.get(index);
            }
            index++;
        }

        return null; //This means it wasn't in the list
    }

    public String getAllBusStops(String streetName){

        //Store found bus stops toString methods in StringBuffer

        StringBuffer foundBusStops = new StringBuffer();

        //Search address String to find streetName

        int index = 0;

        while(busStops.size() > index){
            if(busStops.get(index).getAddress().toLowerCase().contains(streetName.toLowerCase())){
                foundBusStops.append(busStops.get(index).toString());
                /*
                    string.toLowerCase().contains(substring.toLowerCase());
                    // OR
                    string.toUpperCase().contains(substring.toUpperCase());
                 */
            }
            index++;
        }

        return foundBusStops.toString();
    }

    public String listBusStops(){

        StringBuffer busStopsList = new StringBuffer();

        int index = 0;

        while(busStops.size() > index){
            busStopsList.append(busStops.get(index).toString());
            index++;
        }

        return busStopsList.toString();
    }

    @Override
    public String toString() {
        return
                "Bus ID: " + busID + "\n" +
                "Model: " + model + "\n" +
                "Number of Passengers: " + numPassengers + "\n" +
                //"Bus Stop: " + busStops + "\n" + // Wouldn't want to display the bus stop info here as it would look messy
                "Number of Bus Stops: " + numBusStops + "\n\n";
    }
}
