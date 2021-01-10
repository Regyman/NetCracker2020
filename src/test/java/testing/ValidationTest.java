package testing;

import Validation.*;
import body.Client;
import body.Gender;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.List;

public class ValidationTest {
    @Test
    public void test() {
        ValidatorBuilder<Client> builder = new ValidatorBuilder<>();

        Client client = new Client(0, "test", 2500L, Gender.MALE, 1234,4321);

        builder.add(new Condition<>("wow", Client::getFullName));
        builder.add(new Condition<>(1234, Conditions.EQUALS, Client::getPassportS,
                (expected, actual) -> expected.equals(actual)
        ));
        builder.add(new Condition<>(2499L, Conditions.GREATER_THAN_OR_EQUALS, Client::getBirthday,
                (expected, actual) -> expected >= actual
        ));


        Validator<Client> v = builder.build();
        List<Result> results = v.validate(client);

        assertFalse(results.get(0).isValid());
        assertTrue(results.get(1).isValid());
        assertFalse(results.get(2).isValid());
    }
}
