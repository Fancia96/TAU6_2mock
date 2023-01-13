package MockExamples.MockExamples;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

public class RaceResultServiceTestMockito {

    private RaceResultServiceInterface raceResultServiceInterface;

    @BeforeEach
    public void setUp(){
        raceResultServiceInterface = mock(RaceResultServiceInterface.class);
    }

    @Test
    public void test_instance(){
        assertTrue(raceResultServiceInterface instanceof RaceResultServiceInterface);
    }

    @Test
    public void test_default_behavior_needsFuel(){

        //raceResultServiceInterface.addSubscriber();
        //assertFalse(myFerrari.needsFuel(), "New test double should return False as boolean");
    }

    @Test
    public void test_add_subscriber(){
        Client CLIENT = new Client();
        CLIENT.email = "email1";
        RaceResultService raceResultService = new RaceResultService();
        raceResultServiceInterface.addSubscriber(CLIENT);
        verify(raceResultServiceInterface).addSubscriber(CLIENT);
        when(raceResultServiceInterface.getSubscriber("email1")).thenReturn(CLIENT);
        assertTrue(raceResultServiceInterface.getSubscriber("email1").getEmail().equals("email1"));
    }


    @Test
    public void test_add_subscriber_fail(){
        Client CLIENT = new Client();
        CLIENT.email = "email1";

        raceResultServiceInterface.getSubscriber("abc");

        verify(raceResultServiceInterface).getSubscriber("abc");
        assertFalse(raceResultServiceInterface.getSubscriber("abc") != null); // Asercja nie powinna znajdować się z verify, ten test ma głównie za zadanie sprawdzenie czy atrapa wykonała metodę. Zbędne jest tutaj użycie asercji.
    }

    @Test
    public void test_sending_message() {
        Message MESSAGE = new Message();
        MESSAGE.message_text = "cbc";

        Client CLIENT = new Client();
        CLIENT.email = "email2";

        raceResultServiceInterface.addSubscriber(CLIENT);

        raceResultServiceInterface.send(MESSAGE, CLIENT);
        verify(raceResultServiceInterface).send(MESSAGE, CLIENT);

        when(raceResultServiceInterface.isMessageSent(CLIENT)).thenReturn(true);
        assertTrue(raceResultServiceInterface.isMessageSent(CLIENT));
    }

    @Test
    public void test_sending_message_fail() {
        Message MESSAGE = new Message();
        MESSAGE.message_text = "cbc";

        Client CLIENT = new Client();
        CLIENT.email = "email2";

        raceResultServiceInterface.addSubscriber(CLIENT);


        assertFalse(raceResultServiceInterface.isMessageSent(CLIENT));
    }


    @Test
    public void test_remove_subscriber() {
        Client CLIENT = new Client();
        CLIENT.email = "email2";

        raceResultServiceInterface.addSubscriber(CLIENT);

        raceResultServiceInterface.removeSubscriber(CLIENT);

        assertEquals(raceResultServiceInterface.getSubscriber("email2"), null);
    }

    @AfterEach
    public void tearDown(){
        raceResultServiceInterface = null;
    }

}
