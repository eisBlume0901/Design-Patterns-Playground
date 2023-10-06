package exercise2;

public interface Subject
{
    public void registerInvestor(Observer observer);
    public void removeInvestor(Observer observer);
    public void notifyInvestors();
}
