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
 * Time: 6:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class CodeTest {

    private Random r;
    private Code c;

    @Rule
    public ExpectedException e = ExpectedException.none();


    public CodeTest() {
        r = mock(Random.class);
        when(r.nextInt(anyInt())).thenReturn(0);
    }

    @Test
    public void testVerifierCode() throws Exception {
        c = new Code(r);
        Assert.assertTrue("Le code devrait se vérifier", c.verifierCode("0000"));
        Assert.assertFalse("Le code ne devrait pas se vérifier", c.verifierCode("FAUX"));
    }

    @Test
    public void testTentatives() throws Exception {
        c = new Code(r);
        c.verifierCode("FAUX");
        c.verifierCode("FAUX");
        c.verifierCode("FAUX");
        boolean res = c.verifierCode("0000");
        Assert.assertFalse("Le code ne devrait plus se vérifier après 3 tentatives manquées", res);

        c = new Code(r);
        c.verifierCode("FAUX");
        c.verifierCode("FAUX");
        //reset du compteur
        c.verifierCode("0000");
        c.verifierCode("FAUX");
        res = c.verifierCode("0000");
        Assert.assertTrue("Le compteur devrait se réinitialiser après une tentative fructueuse", res);
    }


    @Test
    public void testRevelerCode() throws Exception {
        String vraiCode, fauxCode;
        c = new Code(r);
        vraiCode = c.revelerCode();
        Assert.assertEquals("Le vrai code devrait être 0000", "0000", vraiCode);
        fauxCode = c.revelerCode();
        Assert.assertNotEquals("Le code ne devrait plus êrte révélé", "0000", fauxCode);
    }
}
