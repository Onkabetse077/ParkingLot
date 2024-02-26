public class Vehicle {
    private String type;
    private String registration;
    private String colour;

    public Vehicle(){
        type = "Sedan";
        registration = "XX 01 OG L";
        colour = "Blue";
    }
    public Vehicle(String type,String registration,String colour){
        this.type = type;
        this.registration = registration;
        this.colour = colour;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }
}
