package ch.fhnw.sportscarrental;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

import ch.fhnw.sportscarrental.business.service.BookingService;
import ch.fhnw.sportscarrental.business.service.CarService;
import ch.fhnw.sportscarrental.business.service.InsurancePackageService;
import ch.fhnw.sportscarrental.business.service.RacetrackService;
import ch.fhnw.sportscarrental.data.domain.Booking;
import ch.fhnw.sportscarrental.data.domain.Car;
import ch.fhnw.sportscarrental.data.domain.InsurancePackage;
import ch.fhnw.sportscarrental.data.domain.Racetrack;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.annotation.PostConstruct;

@SpringBootApplication
@RestController
@Hidden // Hide this controller from the Swagger UI
public class SportsCarRentalApplication {

    @Autowired
    private CarService carService;
    
    @Autowired
    private RacetrackService racetrackService;

    @Autowired
    private InsurancePackageService insurancePackageService;

    @Autowired
    private BookingService bookingService;


    public static void main(String[] args) {
        SpringApplication.run(SportsCarRentalApplication.class, args);
    }

    @PostConstruct
    private void initPlaceholderData() throws Exception {
        Car car = new Car();
        car.setCarName("Ferrari 488");
        car.setCarDetails("V8 engine, 661 hp, 0-60 mph in 3.0 seconds");
        car.setLicensePlate("AG 123 456");
        car.setAvailable(true);
        carService.addCar(car);

        car = new Car();
        car.setCarName("Lamborghini Huracan");
        car.setCarDetails("V10 engine, 630 hp, 0-60 mph in 2.9 seconds");
        car.setLicensePlate("ZG 789 012");
        car.setAvailable(true);
        carService.addCar(car);

        car = new Car();
        car.setCarName("Porsche 911 GT3");
        car.setCarDetails("Flat-six engine, 502 hp, 0-60 mph in 3.2 seconds");
        car.setLicensePlate("BL 345 678");
        car.setAvailable(true);
        carService.addCar(car);

        car = new Car();
        car.setCarName("McLaren 720S");
        car.setCarDetails("V8 engine, 710 hp, 0-60 mph in 2.8 seconds");
        car.setLicensePlate("BL 901 234");
        car.setAvailable(true);
        carService.addCar(car);

        car = new Car();
        car.setCarName("Aston Martin Vantage");
        car.setCarDetails("V8 engine, 503 hp, 0-60 mph in 3.5 seconds");
        car.setLicensePlate("SO 567 890");
        car.setAvailable(true);
        carService.addCar(car);

        Racetrack racetrack = new Racetrack();
        racetrack.setTrackName("Nürburgring - Grand Prix Track");
        racetrack.setTrackDescription("The Nürburgring is a motorsport complex around the village of Nürburg, Rhineland-Palatinate, Germany. This is the Grand Prix track.");
        racetrack.setTrackLocation("Nürburg, Germany");
        racetrack.setTrackLength(5.2);
        racetrackService.addRacetrack(racetrack);

        racetrack = new Racetrack();
        racetrack.setTrackName("Nürburgring - Nordschleife");
        racetrack.setTrackDescription("The Nürburgring is a motorsport complex around the village of Nürburg, Rhineland-Palatinate, Germany. This is the Nordschleife track.");
        racetrack.setTrackLocation("Nürburg, Germany");
        racetrack.setTrackLength(20.8);
        racetrackService.addRacetrack(racetrack); // Use instance to call the method

        InsurancePackage insurancePackage = new InsurancePackage();
        insurancePackage.setInsuranceName("Basic");
        insurancePackage.setInsuranceDescription("Basic insurance package");
        insurancePackage.setInsurancePrice(100.0);
        insurancePackage.setInsuranceDeductible(1000.0);
        insurancePackageService.addInsurancePackage(insurancePackage);

        insurancePackage = new InsurancePackage();
        insurancePackage.setInsuranceName("Advanced");
        insurancePackage.setInsuranceDescription("Advanced insurance package");
        insurancePackage.setInsurancePrice(500.0);
        insurancePackage.setInsuranceDeductible(300.0);
        insurancePackageService.addInsurancePackage(insurancePackage);

        insurancePackage = new InsurancePackage();
        insurancePackage.setInsuranceName("Premium");
        insurancePackage.setInsuranceDescription("Premium insurance package");
        insurancePackage.setInsurancePrice(800.0);
        insurancePackage.setInsuranceDeductible(0.0);
        insurancePackageService.addInsurancePackage(insurancePackage);

        Booking booking = new Booking();
        booking.setBookingDate("2021-12-24");
        booking.setBookingTime("10:00");
        booking.setBookingCarName("Ferrari 488");
        booking.setBookingRacetrackName("Nürburgring - Grand Prix Track");
        booking.setBookingInsurancePackageName("Basic");
        booking.setBookingFirstName("John");
        booking.setBookingLastName("Doe");
        booking.setBookingDriverLicenseID("1234567890");
        bookingService.addBooking(booking);
    }
}
