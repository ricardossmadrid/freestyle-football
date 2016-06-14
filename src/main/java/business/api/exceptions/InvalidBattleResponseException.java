package business.api.exceptions;

public class InvalidBattleResponseException extends ApiException {

    private static final long serialVersionUID = -1344640670884805385L;

    public static final String DESCRIPTION = "La respuesta no es válida";

    public static final int CODE = 1;

    public InvalidBattleResponseException() {
        this("");
    }

    public InvalidBattleResponseException(String detail) {
        super(DESCRIPTION + ". " + detail, CODE);
    }

}