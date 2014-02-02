/**
 * Created with IntelliJ IDEA.
 * User: aquassaut
 * Date: 2/2/14
 * Time: 5:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class ExcessiveCreditException extends IllegalArgumentException {
    public ExcessiveCreditException() {
        super("Crédit rendant le solde supérieur au plafond impossible");
    }
}
