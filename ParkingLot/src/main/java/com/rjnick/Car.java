/**
 * @author : Rajamanickam S
 */
package com.rjnick;

import java.util.Date;

public class Car {
    String carRegistrationNumber;
    String color;
    Date startTime;
    int parkingLotNumber;

    Car(String carRegistrationNumber, String color, Date startTime, int parkingLotNumber) {
        this.carRegistrationNumber = carRegistrationNumber;
        this.color = color;
        this.startTime = startTime;
        this.parkingLotNumber = parkingLotNumber;
    }

    public String getCarRegistrationNumber() {
        return carRegistrationNumber;
    }

    public void setCarRegistrationNumber(String carRegistrationNumber) {
        this.carRegistrationNumber = carRegistrationNumber;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public int getParkingLotNumber() {
        return parkingLotNumber;
    }

    public void setParkingLotNumber(int parkingLotNumber) {
        this.parkingLotNumber = parkingLotNumber;
    }
}
