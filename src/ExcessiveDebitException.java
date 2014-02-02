/**
 * Created with IntelliJ IDEA.
 * User: aquassaut
 * Date: 2/2/14
 * Time: 5:11 PM
 * To change this template use File | Settings | File Templates.
 */
public class ExcessiveDebitException extends IllegalArgumentException{
    public ExcessiveDebitException() {
        super("Débit plus élevé que le solde impossible");
    }
}
