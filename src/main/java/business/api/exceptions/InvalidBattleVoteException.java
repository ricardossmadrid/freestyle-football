package business.api.exceptions;

public class InvalidBattleVoteException extends ApiException {

    private static final long serialVersionUID = -1344640670884805385L;

    public static final String DESCRIPTION = "Voto no válido";

    public static final int CODE = 1;

    public InvalidBattleVoteException() {
        this("");
    }

    public InvalidBattleVoteException(String detail) {
        super(DESCRIPTION + ". " + detail, CODE);
    }

}