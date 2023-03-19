package com.globaltransapp.globaltransappbackend.controller;

import com.globaltransapp.globaltransappbackend.exception.UserNotFoundException;
import com.globaltransapp.globaltransappbackend.model.Driver;
import com.globaltransapp.globaltransappbackend.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class DriverController {

    @Autowired
    private DriverRepository driverRepository;

    @PostMapping("/driver")
    public Driver addDriver(@RequestBody Driver newDriver) {
        return driverRepository.save(newDriver);
    }

    @GetMapping("/drivers")
    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }

    @GetMapping("/driver/{id}")
    public Driver getDriverById(@PathVariable Long id) {
        return driverRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @PutMapping("/driver/{id}")
    public Driver updateDriver(@RequestBody Driver newDriver, @PathVariable Long id) {
        return driverRepository.findById(id)
                .map(driver -> {
                    driver.setFirstName(newDriver.getFirstName());
                    driver.setLastName(newDriver.getLastName());
                    driver.setDateOfBirth(newDriver.getDateOfBirth());
                    driver.setDateOfEmployment(newDriver.getDateOfEmployment());
                    driver.setCodeOfUser(newDriver.getCodeOfUser());
                    return driverRepository.save(driver);
                })
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @DeleteMapping("/driver/{id}")
    public String deleteDriver(@PathVariable Long id) {
        if (!driverRepository.existsById(id)) {
            throw new UserNotFoundException(id);
        }
        driverRepository.deleteById(id);
        return "Driver with ID " + id + " has been deleted.";
    }
}
