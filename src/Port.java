public class Port {
    public String name;
    public String country;

    public Port(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public Port(String name) {
        this.name = name;
        this.country = "N/A";
    }
}
