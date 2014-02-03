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
    private boolean _revele;
    private boolean _bloque;

    public Code(Random r) {
        StringBuilder code = new StringBuilder(4);
        for (int i = 0; i < 4; i += 1) {
            code.append(r.nextInt(10));
        }
        _revele = false;
        _bloque = false;
        _code = code.toString();
        _tentatives = 3;
    }


    public boolean verifierCode(String codeFourni) {
        if (_bloque) {
            return false;
        }
        boolean success = _code.equals(codeFourni);
        if (!success) {
            _tentatives -= 1;
            if (_tentatives == 0) {
                _bloque = true;
            }
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

    public boolean isBloque() {
        return _bloque;
    }
}
