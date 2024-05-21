package entities.parking;

public class Car {

    //Attributos
    private String plate;
    private String model;
    private String vehicle_type;
    private int user_id;

    //Constructor
    public Car(String plate, String model, String type, int user_id) {
        this.plate = plate;
        this.model = model;
        this.vehicle_type = type;
        this.user_id = user_id;
    }

    public String getPlate() {
        return plate;
    }

    public String getModel() {
        return model;
    }

    public String getVehicleType() {
        return vehicle_type;
    }

    public int getUserId() {
        return user_id;
    }
    @Override
    public String toString() {
        return "Car{" +
                "plate='" + plate + '\'' +
                ", model='" + model + '\'' +
                ", type='" + vehicle_type + '\'' +
                '}';
    }
}
