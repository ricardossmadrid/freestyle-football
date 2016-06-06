package business.api;

import business.api.exceptions.InvalidFieldException;
import data.services.DataService;

public class DataServiceMock extends DataService {
	
	@Override
	public void validateField(Object field, String msg) throws InvalidFieldException {
        if (field == null || field.toString().isEmpty()) {
            throw new InvalidFieldException(msg);
        }
    }
}
