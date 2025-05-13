public class Company {
    private String name;
    private Flight flights[] = new Flight[10];
    private int flightNumber = 0;

    // CONSTRUCTOR
    public Company(String name) {
        this.name = name;
    }

    public Company(String name, Flight f[]){
        this.name = name;
        flights = f;
        flightNumber = f.length;
    }

    // METHOD
    public void addFlight(Flight flight){
        flights[flightNumber] = flight;
        flightNumber++;
    }

    // GETTERS
    public String getName() {
        return name;
    }

    public int getFlightNumber(){
        return flightNumber;
    }
    // OVERLOADING
    // SEQUENTIAL SEARCH TO OBTAIN FLIGHT DATA
    public Flight getFlight(int i) {
        return flights[i];
    }

    public Flight getFlight(String id) {
        boolean found = false;
        int i = 0;
        Flight f = null;

        //sequential search
        while ((!found)&&(i<flights.length)) {
            // we compare the id that the user entered and the one we have
            if(id.equals(flights[i].getId())){
                found = true;
                f = flights[i];
            }
            i++;
        }
        return f;
    }

}
