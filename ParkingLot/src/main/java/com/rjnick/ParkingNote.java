/**
 * @author : Rajamanickam S
 */
package com.rjnick;

import java.util.Date;

public class ParkingNote {
    Car car;
    Date endTime;

    ParkingNote(Car car,Date endTime){
        this.car =car;
        this.endTime=endTime;
    }

    void getData(){
        System.out.println(car.getParkingLotNumber()+"  | "+car.getCarRegistrationNumber()+" |   "+car.getColor()+"  |   "+car.getStartTime()+"  |   "+endTime);
    }
}
