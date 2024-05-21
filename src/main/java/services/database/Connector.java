package services.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {

    //Atributos para conectarse a la base de datos
    private final String URL = "jdbc:postgresql://localhost:5432/parking";
    private final String USER = "postgres";
    private final String PASSWORD = "Borman15";

    //Establecer la conexión
    public Connection connect() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos PostgreSQL.");
            e.printStackTrace();
            return null;
        }
    }

    /*public Car readCar(int id) {
        String SQL = "SELECT id, make, model, year FROM cars WHERE id = ?";
        Car car = null;

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                car = new Car(rs.getInt("id"), rs.getString("make"), rs.getString("model"), rs.getInt("year"));
            }

        } catch (SQLException e) {
            System.out.println("Error reading car.");
            e.printStackTrace();
        }

        return car;
    }

    public List<Car> readAllCars() {
        String SQL = "SELECT id, make, model, year FROM cars";
        List<Car> cars = new ArrayList<>();

        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {

            while (rs.next()) {
                Car car = new Car(rs.getInt("id"), rs.getString("make"), rs.getString("model"), rs.getInt("year"));
                cars.add(car);
            }

        } catch (SQLException e) {
            System.out.println("Error reading all cars.");
            e.printStackTrace();
        }

        return cars;
    }

    public void updateCar(Car car) {
        String SQL = "UPDATE cars SET make = ?, model = ?, year = ? WHERE id = ?";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            pstmt.setString(1, car.getMake());
            pstmt.setString(2, car.getModel());
            pstmt.setInt(3, car.getYear());
            pstmt.setInt(4, car.getId());
            pstmt.executeUpdate();

            System.out.println("Car updated successfully.");
        } catch (SQLException e) {
            System.out.println("Error updating car.");
            e.printStackTrace();
        }
    }

    public void deleteCar(int id) {
        String SQL = "DELETE FROM cars WHERE id = ?";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();

            System.out.println("Car deleted successfully.");
        } catch (SQLException e) {
            System.out.println("Error deleting car.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Conector conector = new Conector();

        // Crear un nuevo coche
        Car car = new Car(0, "Toyota", "Corolla", 2020);
        conector.createCar(car);

        // Leer un coche por ID
        Car readCar = conector.readCar(1);
        if (readCar != null) {
            System.out.println("Car ID: " + readCar.getId());
            System.out.println("Make: " + readCar.getMake());
            System.out.println("Model: " + readCar.getModel());
            System.out.println("Year: " + readCar.getYear());
        }

        // Leer todos los coches
        List<Car> cars = conector.readAllCars();
        for (Car c : cars) {
            System.out.println("Car ID: " + c.getId() + ", Make: " + c.getMake() + ", Model: " + c.getModel() + ", Year: " + c.getYear());
        }

        // Actualizar un coche
        car.setId(1);  // Suponiendo que el ID del coche que quieres actualizar es 1
        car.setMake("Honda");
        car.setModel("Civic");
        car.setYear(2021);
        conector.updateCar(car);

        // Eliminar un coche
        conector.deleteCar(1);  // Suponiendo que el ID del coche que quieres eliminar es 1
    }*/
}