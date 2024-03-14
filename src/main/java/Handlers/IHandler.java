package Handlers;

import exceptions.HandlerException;

public interface IHandler {
    String handle(String endpoint) throws HandlerException;
}
