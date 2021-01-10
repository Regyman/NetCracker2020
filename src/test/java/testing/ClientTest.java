package testing;

import body.Client;
import body.Gender;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ClientTest {

    @Test
    public void ageTest(){
        //Friday, 10 November 2000
        Client client = new Client(0, "test", 973880009000L, Gender.MALE,2515,515151);
        int age = client.getAge();
        assertEquals(19,age);
    }

}
