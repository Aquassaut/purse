/**
 * Created with IntelliJ IDEA.
 * User: aquassaut
 * Date: 2/3/14
 * Time: 11:46 AM
 * To change this template use File | Settings | File Templates.
 */
public class PurseBloqueException extends Exception {
    public PurseBloqueException() {
        super("Opération impossible : le purse est bloqué");
    }
}
