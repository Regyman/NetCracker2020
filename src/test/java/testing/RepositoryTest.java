package testing;


import Sorter.QuickSorter;
import body.BaseContract;
import body.Client;
import body.Gender;
import body.Repository;
import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


public class RepositoryTest {

@Test
    public void addTest(){
    Repository temp = new Repository();
    BaseContract test= new BaseContract(0, 1549755059L, 1581291059L, new Client(1, "test", 952731059L, Gender.MALE, 1234,4321));
    temp.add(test);
    assertEquals(test,temp.getByID(0));

    BaseContract test2= new BaseContract(1, 1552174259L, 1583796659L, new Client(2, "test2", 952817459L, Gender.MALE, 12345,54321));
    temp.add(test2);
    assertEquals(test2,temp.getByID(1));
    }
    @Test
    public void DeleteTest() {
        Repository temp= new Repository();
        BaseContract test= new BaseContract(0, 1549755059L, 1581291059L, new Client(1, "test", 952731059L, Gender.MALE, 1234,4321));
        temp.add(test);
        BaseContract trash= temp.delete(0);
        assertNotNull(trash);
        BaseContract test2= new BaseContract(0, 1552174259L, 1583796659L, new Client(2, "test2", 952817459L, Gender.MALE, 12345,54321));
        temp.add(test2);
        BaseContract trash2= temp.delete(0);
        assertNotNull(trash2);
    }

    @Test
    public void getByIdTest(){
        Repository temp = new Repository();
        BaseContract test = new BaseContract(0, 1549755059L, 1581291059L, new Client(1, "test", 952731059L, Gender.MALE, 1234,4321));
        BaseContract test2 = new BaseContract(1, 1552174259L, 1583796659L, new Client(2, "test2", 952817459L, Gender.MALE, 12345,54321));
        BaseContract test3 = new BaseContract(2, 1552174259L, 1583796659L, new Client(2, "test3", 952817459L, Gender.MALE, 12345,54321));
        BaseContract test4 = new BaseContract(3, 1549755059L, 1581291059L, new Client(1, "test", 952731059L, Gender.MALE, 1234,4321));
        temp.add(test);
        temp.add(test2);
        temp.add(test3);
        temp.add(test4);

        assertEquals( test3,temp.getByID(2));
        assertEquals(test,temp.getByID(0));

    }

    @Test
    public void isNullTest(){
        Repository temp= new Repository();
        assertTrue(temp.isNull());
    }
    @Test
    public void filterTest() {
        Repository temp = new Repository();
        BaseContract test = new BaseContract(5, 1549755059L, 1581291059L, new Client(1, "test", 952731059L, Gender.MALE, 1234,4321));
        BaseContract test2 = new BaseContract(3, 1552174259L, 1583796659L, new Client(2, "tast2", 952817459L, Gender.MALE, 12345,5321));
        BaseContract test3 = new BaseContract(2, 1552174259L, 1583796659L, new Client(3, "tast34", 952817459L, Gender.MALE, 12345,5321));
        BaseContract test4 = new BaseContract(4, 1549755059L, 1581291059L, new Client(4, "tast4", 952731059L, Gender.MALE, 1234,4321));
        temp.add(test);
        temp.add(test2);
        temp.add(test3);
        temp.add(test4);
        Repository afterfilter = temp.filter(it -> it.getOwner().getFullName().contains("4"));
        assertEquals(2, afterfilter.getSize());
        assertEquals(2,  afterfilter.getByPosition(0).getID());
        assertEquals(4,  afterfilter.getByPosition(1).getID());
        Repository afterfilter2 = temp.filter(it -> it.getOwner().getPassportN().equals(4321));
        assertEquals(2, afterfilter2.getSize());
        assertEquals(5,  afterfilter2.getByPosition(0).getID());
        assertEquals(4,  afterfilter2.getByPosition(1).getID());
    }

    @Test
    public void BubbleSortTest() {
        Repository temp = new Repository();
        BaseContract test = new BaseContract(5, 1549755059L, 1581291059L, new Client(1, "test", 952731059L, Gender.MALE, 1234,4321));
        BaseContract test2 = new BaseContract(3, 1552174259L, 1583796659L, new Client(2, "tast2", 952817459L, Gender.MALE, 12345,5321));
        BaseContract test3 = new BaseContract(2, 1552174259L, 1583796659L, new Client(3, "tast34", 952817459L, Gender.MALE, 12345,5321));
        BaseContract test4 = new BaseContract(4, 1549755059L, 1581291059L, new Client(4, "tast4", 952731059L, Gender.MALE, 1234,4321));
        temp.add(test);
        temp.add(test2);
        temp.add(test3);
        temp.add(test4);
        Repository afterfilter = temp.sort(Comparator.comparingInt(BaseContract::getID));
        assertEquals(2,  afterfilter.getByPosition(0).getID());
        assertEquals(3,  afterfilter.getByPosition(1).getID());
        assertEquals(4,  afterfilter.getByPosition(2).getID());
        assertEquals(5,  afterfilter.getByPosition(3).getID());
    }

    @Test
    public void QuickSortTest() {
        Repository temp = new Repository();
        BaseContract test = new BaseContract(5, 1549755059L, 1581291059L, new Client(1, "test", 952731059L, Gender.MALE, 1234,4321));
        BaseContract test2 = new BaseContract(3, 1552174259L, 1583796659L, new Client(2, "tast2", 952817459L, Gender.MALE, 12345,5321));
        BaseContract test3 = new BaseContract(2, 1552174259L, 1583796659L, new Client(3, "tast34", 952817459L, Gender.MALE, 12345,5321));
        BaseContract test4 = new BaseContract(4, 1549755059L, 1581291059L, new Client(4, "tast4", 952731059L, Gender.MALE, 1234,4321));
        temp.add(test);
        temp.add(test2);
        temp.add(test3);
        temp.add(test4);
        temp.setSorter(new QuickSorter());
        Repository filtered = temp.sort(Comparator.comparingInt(BaseContract::getID));
        assertEquals(2, filtered.getByPosition(0).getID());
        assertEquals(3, filtered.getByPosition(1).getID());
        assertEquals(4, filtered.getByPosition(2).getID());
        assertEquals(5, filtered.getByPosition(3).getID());
    }







}
