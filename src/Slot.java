public class Slot {
    private String type;
    private  Vehicle vehicle;
    private String ticketID;

    public Slot(){
        type = "Sedan";
        vehicle = getVehicle();
        ticketID = "001";
    }
    public Slot(String type){
        this.type = type;
        this.vehicle = null;
        this.ticketID = null;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public String getTicketID() {
        return ticketID;
    }

    public void setTicketID(String ticketID) {
        this.ticketID = ticketID;
    }
}
