package exercise1;

public interface Publisher
{
    public void registerSubscriber(Subscriber subscriber);
    public void removeSubscriber(Subscriber subscriber);
    public void notifySubscribers();
}
