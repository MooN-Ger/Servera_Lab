package validator.field;

import java.time.LocalDate;
import java.util.List;

public class DateValidator {
    public boolean validateDate(String date, List<String> errors, String fieldName, String errorMessage) {
        try {
            LocalDate.parse(date);
            return true;
        } catch (Exception e) {
            errors.add(fieldName + ": " + errorMessage);
            return false;
        }
    }
}
