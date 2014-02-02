/**
 * Created with IntelliJ IDEA.
 * User: aquassaut
 * Date: 2/2/14
 * Time: 5:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class ExcessiveSoldeCreationException extends IllegalArgumentException{
    public ExcessiveSoldeCreationException() {
        super("Création de purse au solde plus grand que le plafond impossible");
    }
}
