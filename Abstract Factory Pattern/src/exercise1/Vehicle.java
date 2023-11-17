package exercise1;

import static java.lang.System.*;

class Chassis
{
    private String model;
    private String type;
    private String material;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
}

class Engine
{
    private String model;
    private String type;
    private String cylinderConfiguration;
    private String fuelInjectionSystem;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCylinderConfiguration() {
        return cylinderConfiguration;
    }

    public void setCylinderConfiguration(String cylinderConfiguration) {
        this.cylinderConfiguration = cylinderConfiguration;
    }

    public String getFuelInjectionSystem() {
        return fuelInjectionSystem;
    }

    public void setFuelInjectionSystem(String fuelInjectionSystem) {
        this.fuelInjectionSystem = fuelInjectionSystem;
    }
}

class Fuel
{
    private String model;
    private String fuelType;
    public enum fuelTypeClassification {
        CONVENTIONAL, HYBRID
    }

    private fuelTypeClassification fuelTypeClassification;
    public String emissionStandards;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getEmissionStandards() {
        return emissionStandards;
    }

    public void setEmissionStandards(String emissionStandards) {
        this.emissionStandards = emissionStandards;
    }

    public Fuel.fuelTypeClassification getFuelTypeClassification() {
        return fuelTypeClassification;
    }

    public void setFuelTypeClassification(Fuel.fuelTypeClassification fuelTypeClassification) {
        this.fuelTypeClassification = fuelTypeClassification;
    }
}

interface CarPartsFactory
{
    public Chassis createChassis();
    public Engine createEngine();
    public Fuel createFuel();
}

class ToyotaSedanCarFactory implements CarPartsFactory
{
    @Override
    public Chassis createChassis() {
        Chassis toyotaSedanChassis = new Chassis();
        toyotaSedanChassis.setModel("T-200");
        toyotaSedanChassis.setType("Sedan");
        toyotaSedanChassis.setMaterial("Aluminum Alloy");
        return toyotaSedanChassis;
    }

    @Override
    public Engine createEngine() {
        Engine toyotaSedanEngine = new Engine();
        toyotaSedanEngine.setModel("V6 Turbo Plus");
        toyotaSedanEngine.setType("V6");
        toyotaSedanEngine.setCylinderConfiguration("V6");
        toyotaSedanEngine.setFuelInjectionSystem("Direct Injection");
        return toyotaSedanEngine;
    }

    @Override
    public Fuel createFuel() {
        Fuel toyotaSedanFuel = new Fuel();
        toyotaSedanFuel.setModel("Hybrid Flow");
        toyotaSedanFuel.setFuelType("Hybrid");
        toyotaSedanFuel.setFuelTypeClassification(Fuel.fuelTypeClassification.HYBRID);
        toyotaSedanFuel.setEmissionStandards("Euro 6");
        return toyotaSedanFuel;
    }
}
public abstract class Vehicle {

    private String model;
    private String description;
    private Chassis chassis;

    private Engine engine;
    private Fuel fuel;
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

    public Chassis getChassis() {
        return chassis;
    }

    public void setChassis(Chassis chassis) {
        this.chassis = chassis;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Fuel getFuel() {
        return fuel;
    }

    public void setFuel(Fuel fuel) {
        this.fuel = fuel;
    }

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
}

class Car extends Vehicle
{
    public int numberOfDoors;
    public int seatingCapacity;

    public enum TransmissionType {
        AUTOMATIC, MANUAL
    }

    public TransmissionType transmission;
    public boolean isConvertible;
    public boolean hasGPS;

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

    public TransmissionType getTransmission() {
        return transmission;
    }

    public void setTransmission(TransmissionType transmission) {
        this.transmission = transmission;
    }

    public boolean isConvertible() {
        return isConvertible;
    }

    public void setConvertible(boolean convertible) {
        isConvertible = convertible;
    }

    public boolean isHasGPS() {
        return hasGPS;
    }

    public void setHasGPS(boolean hasGPS) {
        this.hasGPS = hasGPS;
    }
}

class Sedan extends Car
{
    private CarPartsFactory carPartsFactory;
    public Sedan(CarPartsFactory carPartsFactory)
    {
        this.carPartsFactory = carPartsFactory;
        setModel("Sedan");
        setDescription("The Sedan class represents a versatile and popular category of\n" +
                "vehicles known for their comfort, practicality, and everyday usability.\n" +
                "Sedans typically feature a sleek and stylish design with four doors, making\n" +
                "an ideal choice for families and daily commuters. Known for their balanced\n" +
                "performance and spacious interiors, sedans offer a smooth and enjoyable\n" +
                "driving experience");
        setNumberOfDoors(4);
        setSeatingCapacity(5);
        setConvertible(false);
        setHasGPS(false);
        setTransmission(TransmissionType.MANUAL);
        setChassis(carPartsFactory.createChassis());
        setEngine(carPartsFactory.createEngine());
        setFuel(carPartsFactory.createFuel());
    }


}

abstract class VehicleFactory
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

class ToyotaCarFactory extends VehicleFactory
{
    @Override
    protected Vehicle buildVehicle(String type) {

        CarPartsFactory toyotaSedanCarFactory = new ToyotaSedanCarFactory();
        if (type.equals("Sedan"))
            return new Sedan(toyotaSedanCarFactory);
        else return null;
    }
}

class Main
{
    public static void main(String[] args)
    {
        VehicleFactory toyotaCarFactory = new ToyotaCarFactory();
        Vehicle toyotaSedan = toyotaCarFactory.orderVehicle("Sedan");

        out.println();
        out.println("Car Model: " + toyotaSedan.getModel());
        out.println("Chassis: " + toyotaSedan.getChassis().getModel());
        out.println("Engine: " + toyotaSedan.getEngine().getModel());
        out.println("Fuel: " + toyotaSedan.getFuel().getModel());

    }
}