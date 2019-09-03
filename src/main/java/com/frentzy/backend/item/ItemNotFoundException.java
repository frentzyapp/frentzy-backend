package com.frentzy.backend.item;

public class ItemNotFoundException extends RuntimeException{
    ItemNotFoundException(long id){
        super("Could not find item" + id);
    }
}
