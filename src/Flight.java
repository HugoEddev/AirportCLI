public class Flight {
    // Encapsulation
    private String id;
    private String originCity;
    private String destinyCity;
    private double prize;
    private int maximumPassengersNumber;
    // We are not going to start these two below, we are going to put them manually
    private int currentPassengerNumber;
    private Passenger[] passengers;

    // CONSTRUCTOR
    public Flight(String id, String originCity, String destinyCity, double prize, int maximumPassengersNumber){
        this.id = id;
        this.originCity = originCity;
        this.destinyCity = destinyCity;
        this.prize = prize;
        // we start manually
        this.currentPassengerNumber = 0;
        this.passengers = new Passenger[maximumPassengersNumber];
    }

    // METHODS

    public void addPassenger(Passenger passenger){
        passengers[currentPassengerNumber] = passenger;
        // It starts as 0, and we set it equal to what the user sets
        currentPassengerNumber++; // Since we have a pass, the number of passengers is increasing.
    }

    // GETTERS
    public String getId(){
        return id;
    }

    public String getOriginCity(){
        return originCity;
    }

    public String getDestinyCity() {
        return destinyCity;
    }

    public double getPrize() {
        return currentPassengerNumber;
    }

    public int getMaximumPassengersNumber() {
        return maximumPassengersNumber;
    }

    public int getCurrentPassengerNumber() {
        return currentPassengerNumber;
    }

    // SEARCH FOR A USER - CAN BE SEQUENTIAL OR BINARY (WE USE SEQUENTIAL IN THIS EXERCISE)
    // OVERLOADING

    public Passenger getPassenger(int i) {
        // From my passenger list, the same one that we are passing returns
        return passengers[i];
    }

    public Passenger getPassenger(String passport){
        boolean found = false;
        int i = 0;
        Passenger pas = null; // that starts with null, to finally realize if we have found something or not

        // SEQUENTIAL SEARCH
        while((!found)&&(i<passengers.length)){ // iterator(i) remains less than the size of the list
            if(passport == passengers[i].getPassport()){
                //passport.equals(passengers[i].getPassport()) -> the same
                // passport equal to one of my passports list passports[i]
                found = true;
                pas = passengers[i];
            }
            i++; // ending the while loop
        }

        return pas;
    }


}
