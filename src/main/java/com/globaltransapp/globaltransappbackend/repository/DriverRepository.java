package com.globaltransapp.globaltransappbackend.repository;

import com.globaltransapp.globaltransappbackend.model.Driver;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver, Long> {
}
