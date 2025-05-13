public class PrivateAirport extends Airport {

    // ATTRIBUTES
    private String[] companiesList = new String[10];
    private int companyNumber;

    // CONSTRUCTOR
    public PrivateAirport(String name, String city, String country) {
        super(name, city, country);
    }

    public PrivateAirport(String name, String city, String country, Company[] c, String[] e) {
        super(name, city, country, c);
        this.companiesList = e;
        companyNumber = e.length;
    }

    // In the parameter we have to send all the companies
    public void addCompany(String[] e) {
        this.companiesList = e;
        this.companyNumber = e.length;
        // Up to this point we have installed the companies as a whole as an array
    }

    public void addCompany(String e){
        companiesList[companyNumber] = e; // we insert the string that is sent to us num Company;
        companyNumber++;
    }

    // SHOW ALL COMPANIES
    // GETTERS
    public String[] getCompaniesList() {
        return companiesList;
    }
    // a particular company number
    public int getCompanyNumber() {
        return companyNumber;
    }
}
