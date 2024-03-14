package Handlers.professor;

import Handlers.IHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import controllers.ProfessorController;
import exceptions.HandlerException;
import requests.professor.EditProfessorRequest;
import responses.CommonResponse;
import responses.EntityResponse;

public class EditProfessorHandler implements IHandler {
    private final ProfessorController controller;

    public EditProfessorHandler(ProfessorController controller) {
        this.controller = controller;
    }

    @Override
    public String handle(String json) throws HandlerException {
        ObjectMapper mapper = new ObjectMapper();
        try {
            EntityResponse<CommonResponse<Void>> res = controller.
                    editProfessor(mapper.readValue(json, EditProfessorRequest.class));
            return mapper.writeValueAsString(res);
        } catch (Exception e) {
            throw new HandlerException(e.getMessage());
        }
    }
}
