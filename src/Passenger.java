public class Passenger {
    // ATTRIBUTES
    private String name;
    private String passport;
    private String nationality;

    // CONSTRUCTOR - start attributes
    public Passenger(String name, String passport, String nationality){
        this.name = name;
        this.passport = passport;
        this.nationality = nationality;
    }

    // GETTERS
    public String getName() {
        return name;
    }

    public String getPassport() {
        return passport;
    }

    public String getNationality() {
        return nationality;
    }
}
