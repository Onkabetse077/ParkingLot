import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    String parkingLotID;
    List<List<Slot>> slots;

    public ParkingLot(String parkingLotID,int numberOfFloors,int numberOfSlotsPerFloor){
        this.parkingLotID = parkingLotID;
        slots = new ArrayList<>();
        for (int i = 0;i < numberOfFloors; i++){
            slots.add(new ArrayList<>());
            List<Slot> floorSlots = slots.get(i);
            floorSlots.add(new Slot("truck"));
            floorSlots.add(new Slot("bike"));
            floorSlots. add(new Slot("bike"));

            for (int j = 3;j < numberOfSlotsPerFloor;j++){
                slots.get(i).add(new Slot("car"));
            }

        }
    }

    public String getParkingLotID() {
        return parkingLotID;
    }

    public void setParkingLotID(String parkingLotID) {
        this.parkingLotID = parkingLotID;
    }

    public List<List<Slot>> getSlots() {
        return slots;
    }

    public void setSlots(List<List<Slot>> slots) {
        this.slots = slots;
    }

    //Methods
    String parkVehicle(String type, String regNo, String color) {
        Vehicle vehicle = new Vehicle(type, regNo, color);

        for(int i=0; i<slots.size();i++){
            for(int j=0;j<slots.get(i).size(); j++){
                Slot slot = slots.get(i).get(j);
                if(slot.getType() == type && slot.getVehicle() == null) {
                    slot.setVehicle(vehicle);
                    slot.setTicketID(generateTicketId(i+1, j+1));
                    return slot.getTicketID();
                }
            }
        }
        System.out.println("NO slot available for given type");
        return null;

    }

    void unPark(String ticketId){
        String[] extract = ticketId.split("_");
        int flr_idx=Integer.parseInt(extract[1])-1;
        int slot_idx=Integer.parseInt(extract[2])-1;
        for(int i=0; i<slots.size();i++){
            for(int j=0;j<slots.get(i).size(); j++){
                if(i==flr_idx && j==slot_idx) {
                    Slot slot = slots.get(i).get(j);
                    slot.setVehicle(null);
                    slot.setTicketID(null);
                    System.out.println("Unpacked vehicle");
                }
            }
        }
    }

    private String generateTicketId(int floor, int slotNumber){
        return parkingLotID + "_" + floor + "_" + slotNumber;
    }

    int getNoOfOpenSlots(String type){
        int count=0;
        for(List<Slot> floor: slots){
            for(Slot slot: floor){
                if(slot.getVehicle() == null && slot.getType().equals(type)) count++;
            }
        }

        return count;
    }

    void displayOpenSlots(String type){
        System.out.println("Available slots for "+type);
        for(int i=0;i<slots.size();i++){
            for(int j=0;j<slots.get(i).size();j++){
                Slot slot=slots.get(i).get(j);
                if(slot.getVehicle() == null && slot.getType().equals(type))
                    System.out.println("Floor " + (i+1) + " slot " + (j+1));
            }
        }
    }

    void displayOccupiedSlots(String type){
        System.out.println("Occupied slots for "+type);
        for(int i=0;i<slots.size();i++){
            for(int j=0;j<slots.get(i).size();j++){
                Slot slot=slots.get(i).get(j);
                if(slot.getVehicle() != null && slot.getType().equals(type))
                    System.out.println("Floor " + (i+1) + " slot " + (j+1));
            }
        }
    }
}
