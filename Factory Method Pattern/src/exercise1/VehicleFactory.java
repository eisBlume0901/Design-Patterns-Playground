package exercise1;

import static java.lang.System.*;

public abstract class VehicleFactory
{
    protected abstract Vehicle buildVehicle(String type);
    public Vehicle orderVehicle(String type)
    {
        Vehicle vehicle = null;

        vehicle = buildVehicle(type);

        vehicle.assemble();
        vehicle.testRun();

        return vehicle;
    }
}

class CarFactory extends VehicleFactory
{
    @Override
    protected Vehicle buildVehicle(String type) {
        if (type.equals("Sedan"))
            return new Sedan();
        else if (type.equals("SUV"))
            return new SportsUtilityVehicle();
        else
            return null;
    }
}

class MotorcycleFactory extends VehicleFactory
{
    @Override
    protected Vehicle buildVehicle(String type) {
        if (type.equals("Cruiser"))
            return new Cruiser();
        else if (type.equals("SportBike"))
            return new SportBike();
        else
            return null;
    }
}
abstract class Vehicle
{
    private String model;
    private String description;
    public void assemble()
    {
        out.println("Manufacturing " + model);
        out.println("Constructing chassis that forms foundation of the vehicle");
        out.println("Installing the vehicle's internal combustion or electric engine");
        out.println("Providing the vehicle with the necessary fuel for combustion or energy");
    }

    public void testRun()
    {
        out.println("Conducting thorough visual inspection");
        out.println("Verify the functionality of key systems and components");
        out.println("Utilize diagnostic tools to assess the vehicle's electronic systems");
        out.println("Conduct on-road testing to assess dynamic performance");
        out.println("Validate safety features and systems");
        out.println("Ensure compliance with emission standards");
        out.println("Confirm overall quality and adherence to standards");
        out.println("Address any issues identified during testing");
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

class Car extends Vehicle
{

}

class Sedan extends Car
{
    // Toyota Camry
    public Sedan()
    {
        setModel("Camry");
        setDescription("It is reliable and fuel-efficient sedan known for its\n" +
                "comfortable interior and smooth ride. Ideal for daily\n" +
                "commuting and family travel.");
    }
}

class SportsUtilityVehicle extends Car
{
    // Ford Explorer
    public SportsUtilityVehicle()
    {
        setModel("Explorer");
        setDescription("It is rugged Sports Utility Vehicle (SUV) with ample\n" +
                "space for passengers and cargo. Designed for adventurous\n" +
                "journeys and off-road capabilities");
    }
}

class Motorcycle extends Vehicle
{

}

class Cruiser extends Motorcycle
{
    // Harley Davidson Fat Boy
    public Cruiser()
    {
         setModel("Fat Boy");
         setDescription("IT is a classic cruiser with a distinctive design,\n" +
                 "comfortable ride, and powerful engine, perfect for laid-back cruising");
    }
}

class SportBike extends Motorcycle
{
    // Ducati Panigale V4
    public SportBike()
    {
        setModel("Panigale V4");
        setDescription("It is a high-performance sportbike designed for speed\n" +
                "and agility, featuring advanced aerodynamics and cutting-edge technology");
    }
}

class Main
{
    public static void main(String[] args)
    {
        VehicleFactory carFactory = new CarFactory();
        Vehicle sedanCar = carFactory.orderVehicle("Sedan");

        out.println();
        VehicleFactory motorcycleFactory = new MotorcycleFactory();
        Vehicle sportBikeMotorCycle = motorcycleFactory.orderVehicle("SportBike");

    }
}