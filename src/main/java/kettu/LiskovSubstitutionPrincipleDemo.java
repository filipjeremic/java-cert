package kettu;

import java.util.ArrayList;
import java.util.List;

abstract class Vehicle {

  abstract String getName();

  abstract int getWheelCount();

}

class Car extends Vehicle {

  @Override
  String getName() {
    return "Car";
  }

  @Override
  int getWheelCount() {
    return 4;
  }

}

class Motorcycle extends Vehicle {

  @Override
  String getName() {
    return "Motorcycle";
  }

  @Override
  int getWheelCount() {
    return 2;
  }

}

public class LiskovSubstitutionPrincipleDemo {

  // Objects of a superclass should be replaceable with objects of
  // a subclass without affecting the correctness of the program

  private static void printVehicle(Vehicle v) {
    System.out.println("Vehicle name: " + v.getName() + ", wheel count: " + v.getWheelCount());
  }

  private static void printVehicles(List<Vehicle> vehiclesList) {
    System.out.println("----- printVehicles -----");
    vehiclesList.forEach(LiskovSubstitutionPrincipleDemo::printVehicle);
    System.out.println();
  }

  private static void printVehiclesWildcard(List<? extends Vehicle> vehiclesList) {
    System.out.println("----- printVehiclesWildcard -----");
    vehiclesList.forEach(LiskovSubstitutionPrincipleDemo::printVehicle);
    System.out.println();
  }

  public static void test() {
    Car car = new Car();
    printVehicle(car);

    Motorcycle motorcycle = new Motorcycle();
    printVehicle(motorcycle);

    System.out.println();

    List<Vehicle> vehiclesList = new ArrayList<>();
    vehiclesList.add(car);
    vehiclesList.add(motorcycle);

    printVehicles(vehiclesList);

    Motorcycle motorcycle1 = new Motorcycle();
    Motorcycle motorcycle2 = new Motorcycle();
    List<Motorcycle> motorcyclesList = new ArrayList<>();
    motorcyclesList.add(motorcycle1);
    motorcyclesList.add(motorcycle2);

    // Doesn't compile
    // Motorcycle is a subtype of Vehicles
    // But List<Motorcycle> is not a subtype of List<Vehicle>
    // printVehicles(motorcyclesList);

    // Updated method that works
    printVehiclesWildcard(motorcyclesList);

  }

}
