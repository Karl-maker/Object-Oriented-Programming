import java.util.ArrayList;

public class TransitSystem {

    private String name;
    private ArrayList<Bus> buses = new ArrayList<Bus>();
    private int numBuses = 0;

    public TransitSystem(String name){
        this.name = name;
    }

    public Boolean addBus(String model, int numPassengers){

        Bus bus = new Bus(model, numPassengers);

        buses.add(bus);

        int generatedId = buses.size();

        buses.get(buses.size() - 1).setBusID(generatedId);

        this.numBuses = buses.size();

        return true;
    }

    public int getNumBuses(){
        return numBuses;
    }

    public Boolean addBusStop(String address, int busID){

        //int index = 0;

            try{
                buses.get(busID - 1).addBusStop(address);
                return true;
            }catch(Exception e){
                return false;
            }

        /*
        while(buses.size() > index){
            if(busID == buses.get(index).getBusID()){
                ///int genId = 1000 + (10 * buses.get(index).getNumBusStops()); //add all bus stops then do the math
                buses.get(index).addBusStop(address); //Bus Stop ID is handled in TransitSystemApplication.java
                ///buses.get(index).getBusStop(0).setBusStopID(genId);

                //Error Handle



                return true;
            }
            index++;
        }
        return false;
         */


    }

    public Bus getBus(int busID){
        int index = 0;

        while(buses.size() > index){
            if(busID == buses.get(index).getBusID()){
                return buses.get(index);
            }
            index++;
        }
        return null;
    }

    public String listBuses(){

        StringBuffer listOfBuses = new StringBuffer();

        int index = 0;

        while(buses.size() > index){
                listOfBuses.append(buses.get(index).toString());
                index++;
        }

        return listOfBuses.toString();
    }

    public String listBusStops(){
        StringBuffer listOfBusStops = new StringBuffer();

        int index = 0;

        while(buses.size() > index){
            listOfBusStops.append(buses.get(index).listBusStops());
            index++;
        }
        return listOfBusStops.toString();
    }

    public String listBusStopsByBus(int busID){

        int index = 0;

        while(buses.size() > index) {
            if (busID == buses.get(index).getBusID()) {
                return buses.get(index).listBusStops();
            }
            index++;
        }
        return "No BusStops Related To The Bus ID: " +busID+ "\n";
    }

    public String listBusStopsbyStreet(String address){

        StringBuffer listOfBusStops = new StringBuffer();

        int index = 0;

        while(buses.size() > index) {
            listOfBusStops.append(buses.get(index).getAllBusStops(address));
            index++;
            }
        return listOfBusStops.toString();
    }
}
