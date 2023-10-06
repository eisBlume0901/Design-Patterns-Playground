package exercise1;

public class Main {
    public static void main(String[] args)
    {
        NewsAgency newsAgency = new NewsAgency();

        NewsReader emerald = new NewsReader(newsAgency);
        NewsReader claire = new NewsReader(newsAgency);

        newsAgency.setArticleTitle("A New Scientific Breakthrough Changing the Engineering World");
        newsAgency.setArticleTitle("United Nations Coming Into One To Stop The Possibility of World War III");
    }
}
