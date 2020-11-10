package testing;


import body.Client;
import body.Gender;
import body.Repository;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class RepositoryTest {

@Test
    public void addTest(){
    Repository temp = new Repository();
    String test= "heh";
    temp.add(test);
    assertEquals(test,temp.getByID(0));
    Repository temp2= new Repository();
    Client test2= new Client(0,"John",973532985L,Gender.male,141,1515);
    temp2.add(test2);
    assertEquals(test2,temp2.getByID(0));
    }
    @Test
    public void DeleteTest() {
        Repository<String> temp= new Repository<String>();
        String test= "heh";
        temp.add(test);
        String trash= temp.delete(0);
        assertNotNull(trash);
        Repository<Client> temp2= new Repository<Client>();
        Client test2= new Client(0,"John",973532985L,Gender.male,141,1515);
        temp2.add(test2);
        Client trash2= temp2.delete(0);
        assertNotNull(trash2);
    }

    @Test
    public void getByIdTest(){
        Repository<String> temp= new Repository<String>();
        String test= "heh";
        String test2="heh2";
        String test3="heh3";
        String test4="heh4";
        temp.add(test);
        temp.add(test2);
        temp.add(test3);
        temp.add(test4);

        assertEquals("heh3",temp.getByID(2));
        assertEquals("heh",temp.getByID(0));

    }

    @Test
    public void isNullTest(){
        Repository<String> temp= new Repository<String>();
        assertEquals(true,temp.isNull());
    }





}
