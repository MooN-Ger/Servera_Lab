package server;

import exceptions.ServerException;

public interface IServer {
    String executeRequest(String json, String endPoint) throws ServerException;
}
