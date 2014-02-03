import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Random;

import static org.mockito.Mockito.*;

/**
 * Created with IntelliJ IDEA.
 * User: aquassaut
 * Date: 2/2/14
 * Time: 4:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class PurseTest {
    public static double TOLERANCE = 0.001;
    private Purse p;
    private Random r;

    @Rule
    public ExpectedException e = ExpectedException.none();

    public PurseTest() {
        r = mock(Random.class);
        when(r.nextInt(anyInt())).thenReturn(0);

    }

    @Test
    public void testDebite() throws Exception {
        p = new Purse(100, 200, 100, r);
        Assert.assertEquals("On devrait être à 100 euros à la creation", 100, p.get_solde(), TOLERANCE);
        p.debite(5, "0000");
        Assert.assertEquals("On devrait être à 95 euros", 95, p.get_solde(), TOLERANCE);

        e.expect(InvalidSecretCodeException.class);
        p.debite(5, "ZZZZ");
    }

    @Test
    public void testCredite() throws Exception {
        p = new Purse(100, 200, 100, r);
        Assert.assertEquals("On doit être à 100", 100, p.get_solde(), TOLERANCE);
        p.credite(20);
        Assert.assertEquals("On doit être à 120", 120, p.get_solde(), TOLERANCE);
    }

    @Test
    public void testCreationNegatif() throws Exception {
        e.expect(NegativePurseCreationException.class);
        p = new Purse(-20, 100, 100, r);
    }

    @Test
    public void testDebiteNegatif() throws Exception {
        p = new Purse(100, 200, 100, r);
        e.expect(ExcessiveDebitException.class);
        p.debite(150, "0000");
    }

    @Test
    public void testPlafondCreation() throws Exception {
        e.expect(ExcessiveSoldeCreationException.class);
        p = new Purse(100, 99, 100, r);
    }

    @Test
    public void testCreditePlafond() throws Exception {
        p = new Purse();
        e.expect(ExcessiveCreditException.class);
        p.credite(150);
    }

    @Test
    public void testExcessCreditOperations() throws Exception {
        p = new Purse(100, 200, 1, r);
        p.credite(1);
        e.expect(TooManyOperationsException.class);
        p.credite(1);
    }

    @Test
    public void testExcessDebitOperations() throws Exception {
        p = new Purse(100, 200, 1, r);
        p.debite(1, "0000");
        e.expect(TooManyOperationsException.class);
        p.debite(1, "0000");
    }

    @Test
    public void testPurseBloque() throws Exception {
        p = new Purse(100, 200, 1, r);
        try {
            p.debite(1, "9999");
        } catch (InvalidSecretCodeException ignore) {}
        try {
            p.debite(1, "9999");
        } catch (InvalidSecretCodeException ignore) {}
        try {
            p.debite(1, "9999");
        } catch (InvalidSecretCodeException ignore) {}

        e.expect(PurseBloqueException.class);
        p.credite(1);

    }
}
