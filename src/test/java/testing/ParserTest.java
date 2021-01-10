package testing;

import CSV.CSVParser;
import body.BaseContract;
import body.Client;
import body.Gender;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;


public class ParserTest {

    private final CSVParser parser = new CSVParser();
    @Test
    public void ContractParserTest() {
        BaseContract temp = new BaseContract(0, 123L, 321L,
                new Client(0, "test", 973880009000L, Gender.MALE, 1234,4321)
        );

        String contractCSV = parser.to(temp);

        BaseContract contractConstructed = parser.from(contractCSV, BaseContract.class);
        
        
        assertEquals(temp.getID(), contractConstructed.getID());
        assertEquals(temp.getStartDate(), contractConstructed.getStartDate());
        assertEquals(temp.getOwner().getFullName(),
                contractConstructed.getOwner().getFullName()
        );
        assertEquals(temp.getOwner().getSex(), contractConstructed.getOwner().getSex());
    }

    @Test
    public void ClientFromCSVTest() {
        String tempClient = "0,test,0,MALE,1234,4321";

        Client client = parser.from(tempClient, Client.class);

        assertEquals(0, (int) client.getID());
        assertEquals("test", client.getFullName());
        assertEquals(51, (int) client.getAge());
    }

    @Test
    public void testParsingError() {
        String csvClient = "name,MALE,4321";

        Client client = parser.from(csvClient, Client.class);

        assertNull(client);
    }

    @Test
    public void ContractFromCSVTest() {
        String testContract = "1,123,321,0,test,0,MALE,1234,4321";

        BaseContract contract = parser.from(testContract, BaseContract.class);

        assertNotNull(contract);
        assertEquals(1, contract.getID());
        assertEquals(123, contract.getStartDate());
        assertEquals(321, contract.getEndDate());
        assertEquals("test", contract.getOwner().getFullName());

    }
}
