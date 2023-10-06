package exercise1;

public interface Subscriber
{
    public void update(String articleTitle);
}

class NewsReader implements Subscriber
{
    private NewsAgency newsAgency;

    public NewsReader(NewsAgency newsAgency)
    {
        this.newsAgency = newsAgency;
        newsAgency.registerSubscriber(this);
    }
    @Override
    public void update(String articleTitle) {
        System.out.println(articleTitle);
    }
}