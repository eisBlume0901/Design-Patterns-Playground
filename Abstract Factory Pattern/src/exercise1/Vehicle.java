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
    private String description;
    public enum FuelType {
        HYBRID, CONVENTIONAL
    }

    public String emissionStandards;

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

    public String getEmissionStandards() {
        return emissionStandards;
    }

    public void setEmissionStandards(String emissionStandards) {
        this.emissionStandards = emissionStandards;
    }
}

interface CarPartsFactory
{
    public Chassis createChassis();
    public Engine createEngine();
    public Fuel createFuel();
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
    public Sedan()
    {
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

        Chassis sedanChassis = new Chassis();
        sedanChassis.setModel("S-1000");
        sedanChassis.setType("Sedan");
        sedanChassis.setMaterial("Steel Alloy");
        setChassis(sedanChassis);

        Engine sedanEngine = new Engine();
        sedanEngine.setModel("Standard Sedan Engine");
        sedanEngine.setType("Inline-4");
        sedanEngine.setCylinderConfiguration("Inline-4");
        sedanEngine.setFuelInjectionSystem("Multi-Point Fuel Injection");

        Fuel sedanFuel = new Fuel();

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

class ToyotaSedanCarFactory implements CarPartsFactory
{

    @Override
    public Chassis createChassis() {
        Chassis toyotaChassis = new Chassis();
        toyotaChassis.setModel("V6 Turbo Plus");
    }

    @Override
    public Engine createEngine() {
        return null;
    }

    @Override
    public Fuel createFuel() {
        return null;
    }
}