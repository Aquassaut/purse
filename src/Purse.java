import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: aquassaut
 * Date: 2/2/14
 * Time: 4:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class Purse {
    private double _solde;
    private double _plafond;
    private Code _code;
    private int _nbOps;

    public Purse() {
        this(100, 200, 100, new Random());
    }

    public Purse(double solde, double plafond, int nbOps, Random r)
            throws NegativePurseCreationException, ExcessiveSoldeCreationException {
        if (solde < 0) {
           throw new NegativePurseCreationException();
        }
        if (solde > plafond) {
            throw new ExcessiveSoldeCreationException();
        }

        _code = new Code(r);
        _solde = solde;
        _plafond = plafond;
        _nbOps = nbOps;
    }

    private void mouvement(double amount) throws TooManyOperationsException{
        if (_nbOps == 0) {
            throw new TooManyOperationsException();
        }
        _solde += amount;
        _nbOps -= 1;
    }


    public void debite(double amount, String code)
            throws InvalidSecretCodeException, ExcessiveDebitException, TooManyOperationsException {
        if (! _code.verifierCode(code)) {
            throw new InvalidSecretCodeException();
        }
        if (amount > _solde) {
            throw new ExcessiveDebitException();
        }
        mouvement(-amount);
    }

    public void credite(double amount) throws TooManyOperationsException {
        if (_solde + amount > _plafond) {
            throw new ExcessiveCreditException();
        }
        mouvement(amount);
    }

    public double get_solde() {
        return _solde;
    }

    public String revelerCode() {
        return _code.revelerCode();
    }
}
