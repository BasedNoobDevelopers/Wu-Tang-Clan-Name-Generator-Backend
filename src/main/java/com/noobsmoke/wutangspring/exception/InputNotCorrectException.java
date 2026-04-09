package com.noobsmoke.wutangspring.exception;

public class InputNotCorrectException extends RuntimeException {
    private final String fieldName;
    private final Object fieldValue;

    public InputNotCorrectException(String fieldName, String fieldValue, String message) {
        super(message);
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public String getFieldName() {
        return fieldName;
    }

    public Object getFieldValue() {
        return fieldValue;
    }
}
