package MockExamples.MockExamples;

public interface RaceResultServiceInterface {
    void addSubscriber(Client client);

    void send(Message message, Client client);

    void removeSubscriber(Client client);

    Client getSubscriber(String name);

    boolean isMessageSent(Client client);
}
