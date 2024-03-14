package Handlers.professor;

import Handlers.IHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import controllers.ProfessorController;
import entities.Professor;
import exceptions.HandlerException;
import requests.StringRequest;
import responses.CommonResponse;
import responses.EntityResponse;

import java.util.List;

public class GetProfessorsByPositionHandler implements IHandler {
    private final ProfessorController controller;

    public GetProfessorsByPositionHandler(ProfessorController controller) {
        this.controller = controller;
    }

    @Override
    public String handle(String json) throws HandlerException {
        ObjectMapper mapper = new ObjectMapper();
        try {
            EntityResponse<CommonResponse<List<Professor>>> res = controller.
                    getProfessorsByPosition(mapper.readValue(json, StringRequest.class));
            return mapper.writeValueAsString(res);
        } catch (Exception e) {
            throw new HandlerException(e.getMessage());
        }
    }
}
