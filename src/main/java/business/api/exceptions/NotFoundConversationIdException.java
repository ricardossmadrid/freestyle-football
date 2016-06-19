package business.api.exceptions;

public class NotFoundConversationIdException extends ApiException {

    private static final long serialVersionUID = -1344640670884805385L;

    public static final String DESCRIPTION = "La conversación referenciada no existe";

    public static final int CODE = 1;

    public NotFoundConversationIdException() {
        this("");
    }

    public NotFoundConversationIdException(String detail) {
        super(DESCRIPTION + ". " + detail, CODE);
    }

}