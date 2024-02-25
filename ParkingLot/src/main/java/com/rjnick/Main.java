/**
 * @author : Rajamanickam S
 */
package com.rjnick;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    static Map<Integer, Car> parkingCar = new HashMap<>();
    static List<ParkingNote> totalCarNote = new ArrayList<>();
    static List<Integer> lotNumber = IntStream.rangeClosed(1, 100).boxed().collect(Collectors.toList());

    static Scanner getInput = new Scanner(System.in);

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println("--- WELCOME TO PARKING LOT ---");
        boolean notExit=true;
        while(notExit){
            System.out.println("1.Parking \n2.Parking Close \n3.Check Availability \n4.Show History \n5.Exit");
            System.out.println("Enter the Option : ");
            int option = getInput.nextInt();
            switch (option) {
                case 1:
                    main.bookParking();
                    break;
                case 2:
                    main.closeParking();
                    break;
                case 3:
                    main.checkParkingLotAvailability();
                    break;
                case 4:
                    main.showFullHistory();
                    break;
                case 5:
                    notExit=false;
                    break;
                default:
                    System.out.println("Invalid option selected by user, Please enter valid Option.");
            }
        }
    }

    void bookParking() {
        System.out.println("--- BOOK PARKING LOT ---");
        if (!lotNumber.isEmpty()) {
            int firstAvailableLot = Collections.min(lotNumber);
            System.out.println("Parking place Available on " + firstAvailableLot);
            System.out.println("Enter the Car Number : ");
            String carNumber = getInput.next();
            System.out.println("Enter the Car Color : ");
            String carColor = getInput.next();
            Car car = new Car(carNumber, carColor, getCurrentDateAndTime(), firstAvailableLot);
            parkingCar.put(firstAvailableLot, car);
            lotNumber.remove(firstAvailableLot);
            System.out.println("Car " + carNumber + " Parked at " + firstAvailableLot + " Lot");
        } else {
            System.out.println("No Parking place Available at the moment...");
        }
    }

    void closeParking() {
        System.out.println("--- PARKING CLOSING ---");
        System.out.println("Enter the Parking Lot Number : ");
        int parkingLotNumber = getInput.nextInt();
        if(parkingCar.containsKey(parkingLotNumber)){
            String carNumber = parkingCar.get(parkingLotNumber).getCarRegistrationNumber();
            ParkingNote parkingNote = new ParkingNote(parkingCar.get(parkingLotNumber), getCurrentDateAndTime());
            totalCarNote.add(parkingNote);
            lotNumber.add(parkingLotNumber);
            parkingCar.remove(parkingLotNumber);
            System.out.println("Parking Closed for " + carNumber);
        }else{
            System.out.println("Wrong parking lot number ..");
        }

    }

    void checkParkingLotAvailability() {
        System.out.println("--- PARKING AVAILABILITY CHECK ---");
        if (!lotNumber.isEmpty()) {
            System.out.println("Total Available Parking place : " + lotNumber.size());
        } else {
            System.out.println("No Parking place Available at the moment...");
        }
        System.out.println("Parking lot Details ...");
        for (int i = 1; i <= 100; i++) {
            if (parkingCar.containsKey(i)) {
                System.out.println("Lot " + i + " Already Parked by " + parkingCar.get(i).getCarRegistrationNumber());
            } else {
                System.out.println("Lot " + i + " Available");
            }
        }
    }

    void showFullHistory() {
        System.out.println("--- PARKING LOT HISTORY ---");
        System.out.println("LotNo   CarNumber   CarColor    StartTime   EndTime");
        for(ParkingNote parkingNote:totalCarNote){
            parkingNote.getData();
        }
    }

    Date getCurrentDateAndTime() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        return Date.from(currentDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }
}
