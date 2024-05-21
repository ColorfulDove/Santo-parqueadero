package services.crud;

import entities.parking.Car;
import services.database.Connector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class CarServiceImp implements CrudService<Car> {

    private Connector connector = new Connector();

    public CarServiceImp(){}

    @Override
    public void create(Car car) {
        String SQL = "INSERT INTO cars (plate, model, vehicle_type, user_id) VALUES (?, ?, ?, ?)";
        try {
            Connection conn = connector.connect();
            PreparedStatement pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, car.getPlate());
            pstmt.setString(2, car.getModel());
            pstmt.setString(3, car.getVehicleType());
            pstmt.setInt(4, car.getUserId());
            pstmt.executeUpdate();
            System.out.println("Car created successfully.");
        } catch (SQLException e) {
            System.out.println("Error creating car.");
            e.printStackTrace();
        }
    }

        @Override
    public Car read(String id) {
        return null;
    }

    @Override
    public List<Car> readAll() {
        return null;
    }

    @Override
    public void update(Car car) {

    }

    @Override
    public void delete(Long id) {

    }
}
