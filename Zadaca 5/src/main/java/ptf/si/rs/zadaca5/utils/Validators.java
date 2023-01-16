package ptf.si.rs.zadaca5.utils;

public class Validators {
    public static void checkRequiredField(String content, String fieldName) {
        if (content.isBlank()) throw new IllegalStateException("\"" + fieldName + "\" cannot be empty!");
    }

    public static void checkMinLength(String content, int minLength, String fieldName) {
        if (content.trim().length() < minLength) throw new IllegalStateException("\"" + fieldName + "\" must be at least " + minLength + " characters long!");
    }

    public static void checkMaxLength(String content, int maxLength, String fieldName) {
        if (content.trim().length() > maxLength) throw new IllegalStateException("\"" + fieldName + "\" can be only " + maxLength + " characters long!");
    }

    public static void checkNotNull(Object value, String fieldName) {
        if (value == null) throw new IllegalStateException("\"" + fieldName + "\" cannot be empty!");
    }
}
