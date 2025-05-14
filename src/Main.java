import java.util.Scanner;

public class Main {
    // static because is global
    static Scanner input = new Scanner(System.in);
    final static int num = 5; // Number of airports is a constant
    static Airport[] airports = new Airport[num];

    public static void main(String[] args) {
        addDataToAirport(airports);
        menu();
    }

    public static void addDataToAirport(Airport[] aero){
        // Airport 0 ok
        aero[0] = new PublicAirport("Jorge Chavez", "Lima", "Peru", 80000);
        aero[0].addCompany(new Company("AeroPeru"));
        aero[0].addCompany(new Company("LATAM"));
        // flights and passengers...

        // --- Airport ---
        aero[1] = new PublicAirport("Heathrow", "Londres", "Reino Unido", 90000);
        aero[1].addCompany(new Company("AirEurope"));                      // ← aquí
        aero[1].getCompany("AirEurope")
                .addFlight(new Flight("AE50", "Madrid", "Barcelona", 150.0, 20));
        aero[1].getCompany("AirEurope")
                .getFlight("AE50")
                .addPassenger(new Passenger("Draken", "30Bjhp", "Japanese"));

        // Airport 2
        aero[2] = new PublicAirport("El Dorado", "Bogota", "Colombia", 50000);
        aero[2].addCompany(new Company("AirColombia"));
        aero[2].addCompany(new Company("Ariadna"));
        // flights and passengers...

        // --- Airport 3 ---
        aero[3] = new PublicAirport("Benito Juárez", "CDMX", "México", 120000);
        aero[3].addCompany(new Company("Volaris"));                        // ← aquí
        aero[3].addCompany(new Company("Aeromexico"));                     // ← y aquí
        aero[3].getCompany("Volaris")
                .addFlight(new Flight("MI64", "CDMX", "Tokyo", 800.90, 500));
        aero[3].getCompany("Aeromexico")
                .addFlight(new Flight("MI65", "CDMX", "Seul", 900.00, 500));

        aero[4] = new PrivateAirport("Pearson", "Toronto", "Canada");
        PrivateAirport priv3 = (PrivateAirport) aero[4];
        priv3.addCompany("Grupo VIP");
        priv3.addCompany("Empresa X");
    }

    public static void menu(){
        String airportName, companyName, origin, destiny;
        int option = 0;
        // this will continue to repeat until the user wants it to
        Airport airport = null;
        Company company;

        do {
            System.out.println("\\t.:MENU:.");
            System.out.println("1. See Managed Airports (Public or Private)");
            System.out.println("2. See companies (Private) or subsidized (Public)");
            System.out.println("3. Lists of companies at an airport");
            System.out.println("4. List of flights by company");
            System.out.println("5. List possible flights from Origin to Destination");
            System.out.println("6. Exit");
            System.out.println("Option: ");

            option = input.nextInt();

            switch (option){
                case 1: // See managed airports (public or private)
                    System.out.println("");
                    showAirportData(airports);
                    break;
                case 2:// See companies(private) or subsidy(Public)
                    System.out.println("");
                    showSponsorship(airports);
                    break;
                case 3: // List of companies of an airport
                    input.nextLine();

                    System.out.println("Enter the name of the airport: ");
                    airportName = input.nextLine(); // We have to send this name to a method
                    airport = searchAirport(airportName, airports);
                    //airport has two values or null, or the airport we are searching
                    if(airport == null){
                        System.out.println("The airport does not exist");
                    } else {
                        // list of companies at the airport entered
                        showCompanies(airport);
                    }
                    break;
                case 4:
                    // List of flights of some company
                    input.nextLine();

                    System.out.println("\\nEnter the name of the Airport: ");
                    airportName = input.nextLine();
                    // search if the airport entered exists
                    airport = searchAirport(airportName, airports);
                    if(airport== null){
                        System.out.println("The airport does not exist");
                    } else {
                        System.out.print("Enter the name of the company: ");
                        companyName = input.nextLine();

                        company = airport.getCompany(companyName);
                        showFlights(company);
                    }
                    break;
                case 5:
                    // List possible flights from origin to destination
                    input.nextLine();
                    System.out.println("\nEnter the city of origin: ");
                    origin = input.nextLine();
                    System.out.println("Enter the destination city: ");
                    destiny = input.nextLine();

                    // Show all flights from the city of origin to the destination city
                    showOriginToDestinyFlight(origin, destiny, airports);
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Error, invalid menu option");
            }

            System.out.println("");

        } while (option != 6);
    }

    // static so that it belongs directly to the class
    // tour and show all airports
    public static void showAirportData(Airport[] airports){
        for (Airport airport : airports) { // if it is a private airport we show its data
            // instanceof determines whether the i we are going to belongs to the private airport class
            if (airport instanceof PrivateAirport) {
                System.out.println("Private airport");
                System.out.println("Name: " + airport.getName());
                System.out.println("City: " + airport.getCity());
                System.out.println("Country: " + airport.getCountry());
            } else {
                // Public airport
                System.out.println("Public airport");
                System.out.println("Name: " + airport.getName());
                System.out.println("City: " + airport.getCity());
                System.out.println("Pais: " + airport.getCountry());
            }
            System.out.println("");
        }
    }

    public static void showSponsorship(Airport[] airports){
        for (Airport airport : airports) {
            if (airport instanceof PrivateAirport) {
                PrivateAirport priv = (PrivateAirport) airport;
                System.out.println("Private Airport: " + priv.getName());

                for (int i = 0; i < priv.getCompanyNumber(); i++) {
                    System.out.println(priv.getCompaniesList()[i]);
                }
                System.out.println();
            }
        }
    }


    // We want to return to an airport exactly the one we are looking for.
    // We pass the name of the aero we want to search for and the list.
    public static Airport searchAirport(String name, Airport[] airports){
        boolean found = false;
        int i = 0;
        Airport airport = null;
        // sequential search - as long as found remains false and i is less than the number of aero in the list
        while ((!found) && (i<airports.length)){
            if(name.equals(airports[i].getName())){
                found = true;
                airport = airports[i];
            }
            i++;
        }
        return airport;
    }

    public static void showCompanies(Airport airport){
        // to show companies just scroll through
        System.out.println("\nThe airport companies: " + airport.getName());
        for (int i = 0; i < airport.getCompanyNum(); i++) {
            System.out.println(airport.getCompany(i).getName());
        }
    }

    public static void showFlights(Company company){
        Flight flight;
        System.out.println("The company's flights: " + company.getName());
        for (int i = 0; i < company.getFlightNumber(); i++) {
            flight = company.getFlight(i);
            System.out.println("Id: " + flight.getId());
            System.out.println("Origin city: " + flight.getOriginCity());
            System.out.println("Destiny city: " + flight.getDestinyCity());
            System.out.println("Prize: " + flight.getPrize());
            System.out.println("");
        }
    }

    public static Flight[] searchOriginToDestinyFlights(String origin, String destiny, Airport[] airports){
       Flight flight;
       int counter = 0;
       Flight[] flightList;

        for (Airport airport : airports) { // We loop airports
            for (int j = 0; j < airport.getCompanyNum(); j++) { // Looping companies inside airports
                // Inside companies, we have the flights
                for (int k = 0; k < airport.getCompany(j).getFlightNumber(); k++) { // Looping flights
                    flight = airport.getCompany(j).getFlight(k); // We save each of the flights here
                    if ((origin.equals(flight.getOriginCity())) && (destiny.equals(flight.getDestinyCity()))) {
                        counter++;
                    }
                }
            }
        }
        flightList = new Flight[counter]; // Saving flights
        int q = 0;
        // save all the origin flights to destiny
        for (Airport airport : airports) {
            for (int j = 0; j < airport.getCompanyNum(); j++) {
                for (int k = 0; k < airport.getCompany(j).getFlightNumber(); k++) {
                    // We save each flight
                    flight = airport.getCompany(j).getFlight(k);
                    if ((origin.equals(flight.getOriginCity())) && (destiny.equals(flight.getDestinyCity()))) {
                        flightList[q] = flight;
                        q++;
                        // COMPARING IF THE CITY OF ORIGIN IS SOMETHING WE ALREADY HAVE, SAME AS THE DESTINATION CITY
                    }
                }
            }
        }
        return flightList;
    }

    public static void showOriginToDestinyFlight(String origin, String destiny, Airport airports[]){
        Flight[] flights;
        flights = searchOriginToDestinyFlights(origin, destiny, airports);

        if(flights.length == 0){
            System.out.println("There are no flights from that city of origin to the destination");
        } else {
            System.out.println("\nFlights found: ");
            for (Flight flight : flights) {
                System.out.println("Id: " + flight.getId());
                System.out.println("Origin city: " + flight.getOriginCity());
                System.out.println("Destiny city: " + flight.getDestinyCity());
                System.out.println("Prize: $" + flight.getPrize());
                System.out.println("");
            }
        }
    }
}