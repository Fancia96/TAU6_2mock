package MockExamples.MockExamples;

import java.util.Collection;
import java.util.HashSet;

public class RaceResultService implements RaceResultServiceInterface {
    private Collection<Client> clients = new HashSet<Client>();

    public void addSubscriber(Client client){
        clients.add(client);
    }

    public void send(Message message, Client client_Search){
        System.out.println(message + " bcbcbcbc");
        for (Client client: clients){
            if(client.email.equals(client_Search.getEmail())) {
                client.receive(message);
            }
        }
    }

    public void removeSubscriber(Client client){
        clients.remove(client);
    }

    @Override
    public Client getSubscriber(String name) {
        for (Client client: clients){
            if(client.email.equals(name)){
                return client;
            }
        }
        return null;
    }

    @Override
    public boolean isMessageSent(Client client_search) {
        for (Client client: clients){
            if(client.email.equals(client_search.getEmail())){
                return client.isMessageSent();
            }
        }
        return false;
    }
}