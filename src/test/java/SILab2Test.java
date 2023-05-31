import org.junit.Test;
import static org.junit.Assert.*;

public class SILab2Test {

    @Test
    public void testEveryBranchCriterion() {
        // Test case 1: Null user
        User user1 = null;
        List<User> allUsers1 = new ArrayList<>();
        try {
            SILab2.function(user1, allUsers1);
            fail("Expected RuntimeException");
        } catch (RuntimeException e) {
            assertEquals("Mandatory information missing!", e.getMessage());
        }

        // Test case 2: Null password
        User user2 = new User("username", null, "email");
        List<User> allUsers2 = new ArrayList<>();
        try {
            SILab2.function(user2, allUsers2);
            fail("Expected RuntimeException");
        } catch (RuntimeException e) {
            assertEquals("Mandatory information missing!", e.getMessage());
        }