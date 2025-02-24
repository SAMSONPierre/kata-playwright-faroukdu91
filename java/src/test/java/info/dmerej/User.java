package info.dmerej;

public class User {
    private String zipCode;
    private String name;
    private String email;
    private String address;
    private String city;
    private String hiringDate;
    private String jobTitle;

    public User(String zipCode, String name, String email, String address, String city, String hiringDate, String jobTitle) {
        this.zipCode = zipCode;
        this.name = name;
        this.email = email;
        this.address = address;
        this.city = city;
        this.hiringDate = hiringDate;
        this.jobTitle = jobTitle;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getHiringDate() {
        return hiringDate;
    }

    public String getJobTitle() {
        return jobTitle;
    }
}