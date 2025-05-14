public class Airport {

    private String name;
    private String city;
    private String country;
    private Company companies[] = new Company[10];
    private int companyNum;

    // CONSTRUCTOR
    public Airport(String name, String city, String country) {
        this.name = name;
        this.city = city;
        this.country = country;
        this.companyNum = 0;
    }

    public Airport(String name, String city, String country, Company[] c) {
        this.name = name;
        this.city = city;
        this.country = country;
        companies = c;
        this.companyNum = c.length;
    }

    // Method to insert to the companies list
    public void addCompany(Company company) {
        companies[companyNum] = company;
        companyNum++;
    }

    // GETTER
    public String getName(){
        return name;
    }

    public String getCity(){
        return  city;
    }

    public String getCountry(){
        return country;
    }

    public Company[] getCompanies(){
        return companies;
    }

    public int getCompanyNum(){
        return companyNum;
    }

    //Method overloading

    // We will only return one company, depending on which one requests us.
    public Company getCompany(int i) {
        return companies[i];
    }

    public Company getCompany(String name) {
        for (int i = 0; i < companyNum; i++) {
            Company c = companies[i];
            if (c != null && c.getName().equals(name)) {
                return c;
            }
        }
        return null;  // si no se encuentra
    }
}
