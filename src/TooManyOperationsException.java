/**
 * Created with IntelliJ IDEA.
 * User: aquassaut
 * Date: 2/2/14
 * Time: 5:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class TooManyOperationsException extends Exception {
    public TooManyOperationsException() {
        super("Impossible d'effectuer plus d'opérations avec ce purse");
    }
}
