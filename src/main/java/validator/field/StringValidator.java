package validator.field;

import java.util.List;

public class StringValidator {
    public boolean validateStringNotEmpty(String str, List<String> errors, String fieldName, String errorMessage) {
        if (str == null || str.isEmpty()) {
            errors.add(fieldName + ": " + errorMessage);
            return false;
        }
        return true;
    }

    public boolean validateStringMaxLength(String str, int maxLength, List<String> errors, String fieldName, String errorMessage) {
        if (str.length() > maxLength) {
            errors.add(fieldName + ": " + errorMessage);
            return false;
        }
        return true;
    }
}
