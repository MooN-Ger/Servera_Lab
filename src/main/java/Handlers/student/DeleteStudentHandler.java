package Handlers.student;

import Handlers.IHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import controllers.StudentController;
import exceptions.HandlerException;
import requests.IdRequest;
import responses.CommonResponse;
import responses.EntityResponse;

public class DeleteStudentHandler implements IHandler {

    private final StudentController controller;

    public DeleteStudentHandler(StudentController controller) {
        this.controller = controller;
    }

    @Override
    public String handle(String json) throws HandlerException {
        ObjectMapper mapper = new ObjectMapper();
        try {
            EntityResponse<CommonResponse<Void>> res = controller.
                    deleteStudent(mapper.readValue(json, IdRequest.class));
            return mapper.writeValueAsString(res);
        } catch (Exception e) {
            throw new HandlerException(e.getMessage());
        }
    }
}
