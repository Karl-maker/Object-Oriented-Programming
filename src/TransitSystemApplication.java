import java.io.IOException;
import java.util.Scanner;

public class TransitSystemApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bus bus = new Bus(null, 0); //
        TransitSystem transitSystem = new TransitSystem("WorldWideTransitSystem");
        Boolean run = true;


        while(run){
            switch(displayOptions()){

                case '1': {

                    int error = 1;
                    System.out.print("\n\nEnter Bus Model: ");
                    String model = scanner.nextLine();

                    do {
                        try {
                            System.out.print("\nEnter Number of Passengers: ");
                            int numPassengers = scanner.nextInt();
                            scanner.nextLine();

                            //Create New Bus
                            transitSystem.addBus(model, numPassengers);
                            promptEnterKey();

                            error = 0; //No Error
                        } catch (Exception e) {
                            System.out.println("\nPlease Enter Appropriate Information!\n");
                            scanner.nextLine();
                        }
                    }while(error == 1);

                    break;
                }
                case '2': {

                    int error = 1;
                    do{
                        try{
                            System.out.print("Enter Bus ID: ");
                            int busId = scanner.nextInt();
                            scanner.nextLine();
                            System.out.print("Enter Address: ");
                            String address = scanner.nextLine();

                            if(transitSystem.addBusStop(address, busId)){

                                /*

                                int index = 0;
                                int loop = 0;
                                int busstops = 0;
                                int genId = 1000;

                                //Get number of BusStops in each Bus

                                while(transitSystem.getNumBuses() > loop){
                                    busstops = busstops + transitSystem.getBus(loop).getNumBusStops();
                                    loop++;
                                }

                                while(busstops > index  - 1){//(transitSystem.getNumBuses() > index){
                                    genId = genId + (10 * (transitSystem.getBus(index).getNumBusStops() + 1)); //Generate Unique ID
                                    index++;
                                }

                                transitSystem.getBus(busId).getBusStop(0).setBusStopID(genId);
                                 */

                                System.out.println("Bus Stop has been added to Bus No." + busId);
                            }
                            else{
                                System.out.println("Bus No." +busId+ " does not exist.");
                            }
                            promptEnterKey();
                            error = 0;
                        }catch(Exception e){

                            System.out.println("\nPlease Enter Appropriate Information!\n");
                            scanner.nextLine();
                        }
                    }while(error == 1);

                    break;
                }
                case '3': {

                    System.out.print("Enter Street Address: ");
                    String street = scanner.nextLine();
                    System.out.println(transitSystem.listBusStopsbyStreet(street));
                    promptEnterKey();
                    break;
                }
                case '4':{
                    int error = 1;

                    do{
                        try{
                            System.out.print("Enter Bus ID: ");
                            int busId = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println(transitSystem.listBusStopsByBus(busId));
                            promptEnterKey();
                            error = 0;
                        }catch(Exception e){
                            System.out.println("\nPlease Enter Appropriate Information!\n");
                            scanner.nextLine();
                        }
                    }while(error == 1);


                    break;
                }
                case '5':{

                    System.out.println(transitSystem.listBusStops());
                    promptEnterKey();
                    break;
                }
                case '6':{

                    System.out.println(transitSystem.listBuses());
                    promptEnterKey();
                    break;
                }
                case '7': {
                    run = false; //to exit program
                    System.out.println("Thank you for using our program");
                    promptEnterKey();
                    break;
                }
                default:{
                    System.out.println("Please Enter Option Presented On List");
                    promptEnterKey();
                }
            }
            //scanner.nextLine(); //Sometimes the input is glitchy
        }
    }

    public static char displayOptions(){
        Scanner scanner = new Scanner(System.in);
        System.out.print(
                "Please Select Option Below By Entering Corresponding Number:\n\n" +
                        "1) Add new bus to system\n" +
                        "2) Add new bus stop to system\n" +
                        "3) Display bus stop by street address\n" +
                        "4) Display bus stop for a given bus\n" +
                        "5) Display information about all bus stops in system\n" +
                        "6) Display information about all buses in system\n" +
                        "7) Exit System\n\nEnter Option Here: ");

        char option = scanner.next().charAt(0);
        return option;
    }

    public static void promptEnterKey(){
        System.out.println("Press \"ENTER\" to continue...");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/*
int error = 1;

                    do{
                        try{

                        }catch(Exception e){

                        }
                    }while(error == 1);
 */

