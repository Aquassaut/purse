/**
 * Created with IntelliJ IDEA.
 * User: aquassaut
 * Date: 2/2/14
 * Time: 5:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class InvalidSecretCodeException extends IllegalArgumentException{
    public InvalidSecretCodeException() {
        super("Mauvais code secret");
    }
}
