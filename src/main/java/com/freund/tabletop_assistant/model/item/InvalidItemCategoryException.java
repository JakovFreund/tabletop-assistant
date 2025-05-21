package com.freund.tabletop_assistant.model.item;

public class InvalidItemCategoryException extends RuntimeException {
    public InvalidItemCategoryException(String message) {
        super(message);
    }
}