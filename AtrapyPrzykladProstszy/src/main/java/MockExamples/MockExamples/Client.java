package MockExamples.MockExamples;

public class Client {

    public String email;
    public String getEmail(){
        return email;
    }

    boolean isMessageSent = false;
    public void receive(Message message) {
        isMessageSent = true;
    }

    public boolean isMessageSent(){
        return isMessageSent;
    }
}
