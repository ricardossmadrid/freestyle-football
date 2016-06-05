package business.api.exceptions;

public class InvalidFieldException extends ApiException {

    private static final long serialVersionUID = -1344640670884805385L;

    public static final String DESCRIPTION = "Campo vacio o inexistente";

    public static final int CODE = 1;

    public InvalidFieldException() {
        this("");
    }

    public InvalidFieldException(String detail) {
        super(DESCRIPTION + ". " + detail, CODE);
    }

}
