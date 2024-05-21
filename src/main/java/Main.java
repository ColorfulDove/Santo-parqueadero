import entities.parking.Car;
import services.crud.CarServiceImp;
import services.crud.CrudService;

public class Main {

    public static void main(String[] args) {
        Car car = new Car("XXX123", "2024", "Truck", 1);
        CrudService<Car> crudService = new CarServiceImp();
        crudService.create(car);
    }
}
