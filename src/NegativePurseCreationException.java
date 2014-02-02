/**
 * Created with IntelliJ IDEA.
 * User: aquassaut
 * Date: 2/2/14
 * Time: 4:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class NegativePurseCreationException extends IllegalArgumentException {
    public NegativePurseCreationException() {
        super("Création d'un purse au solde négatif impossible");
    }

}
