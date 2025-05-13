public class PublicAirport extends Airport {
    private double grant; // The subsidy is something that the government gives

    // CONSTRUCTORS

    public PublicAirport(String name, String city, String country){
        super(name, city, country); // calls the base class constructor
    }

    public PublicAirport(String name, String city, String country, Company[] c, double grant){
        super(name, city, country, c); // calls the base class constructor
        this.grant = grant;
    }

    public PublicAirport(String name, String city, String country, double grant){
        super(name, city, country); // calls the base class constructor
        this.grant = grant;
    }

    // GETTERS
    public double getGrant() {
        return grant;
    }
}
