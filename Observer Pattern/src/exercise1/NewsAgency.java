package exercise1;
import java.util.*;
public class NewsAgency implements Publisher
{
    private String articleTitle;
    private List<Subscriber> subscribers;

    public NewsAgency()
    {
        this.subscribers = new ArrayList<>();
    }

    public void setArticleTitle(String articleTitle)
    {
        this.articleTitle = articleTitle;
        newsArticleUpdate();
    }

    @Override
    public void registerSubscriber(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void removeSubscriber(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    @Override
    public void notifySubscribers() {
        for (Subscriber subscriber : subscribers)
            subscriber.update(articleTitle);
    }

    public void newsArticleUpdate()
    {
        notifySubscribers();
    }
}
