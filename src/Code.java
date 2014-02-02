import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: aquassaut
 * Date: 2/2/14
 * Time: 5:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class Code {
    private String _code;
    private int _tentatives;
    public static String authorized = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private boolean _revele;

    public Code(Random r) {
        char code[] = new char[4];
        for (int i = 0; i < 4; i += 1) {
            int randIndex = r.nextInt(authorized.length());
            code[i] = authorized.charAt(randIndex);
        }
        _revele = false;
        _code = new String(code);
        _tentatives = 3;
    }


    public boolean verifierCode(String codeFourni) {
        if (_tentatives == 0) {
            return false;
        }
        boolean success = _code.equals(codeFourni);
        if (!success) {
            _tentatives -= 1;
        } else {
            _tentatives = 3;
        }
        return success;
    }

    public String revelerCode() {
        if (! _revele) {
            _revele = true;
            return _code;
        }
        return "xxxx";
    }




}
