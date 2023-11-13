package exercise1;

import static java.lang.System.*;

public abstract class VehicleFactory
{
    protected abstract Vehicle createVehicle(String type);
    public Vehicle orderVehicle(String type)
    {
        Vehicle vehicle = null;

        vehicle = createVehicle(type);

        vehicle.assemble();

        return vehicle;
    }
}

class CarFactory
{

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

class Sedan
{

}