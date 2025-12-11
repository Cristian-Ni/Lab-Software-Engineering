package com.parking.parkinglot.ejb;

import com.parking.parkinglot.common.CarDto;
import jakarta.ejb.EJBException;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.example.parkinglot.entities.Car;
import org.example.parkinglot.entities.Users;

import java.util.List;
import java.util.logging.Logger;

@Stateless
public class CarsBean
{
    private static final Logger LOG = Logger.getLogger(CarsBean.class.getName());

    @PersistenceContext
    EntityManager entityManager;



    public List<CarDto> findAllCars()
    {
        LOG.info("findAllCars");
        try
        {
            TypedQuery<Car> typedQuery = entityManager.createQuery("SELECT c FROM Car c", Car.class);
            List<Car> cars = typedQuery.getResultList();
            return copyCarsToDto(cars);
        } catch (Exception e) {
            throw new EJBException(e);
        }
    }

    private List<CarDto> copyCarsToDto(List<Car> cars) {
        return cars.stream().map(
                car -> new CarDto(car.getId(), car.getLicensePlate(), car.getParkingSpot(), car.getOwner().getUsername()
                )).toList();
    }

    public void createCar(String licensePlate, String parkingSpot, Long userId)
    {
        LOG.info("createCar");
        Car car = new Car();
        car.setLicensePlate(licensePlate);
        car.setParkingSpot(parkingSpot);

        Users user = entityManager.find(Users.class, userId);
        user.getCars().add(car);
        car.setOwner(user);

        entityManager.persist(car);
    }

    public CarDto findById(Long carId) {
        LOG.info("findById");
        Car car = entityManager.find(Car.class, carId);
        CarDto carDto = new CarDto(car.getId(), car.getLicensePlate(), car.getParkingSpot(), car.getOwner().getUsername());
        return carDto;
    }

    public void updateCar(Long carId, String licensePlate, String parkingSpot, Long userId)
    {
        Car car = entityManager.find(Car.class, carId);
        car.setLicensePlate(licensePlate);
        car.setParkingSpot(parkingSpot);

        //remove this car from old user
        Users oldUser = car.getOwner();
        oldUser.getCars().remove(car);

        //add car to new owner
        Users user = entityManager.find(Users.class, userId);;
        user.getCars().add(car);
        car.setOwner(user);
    }
}
