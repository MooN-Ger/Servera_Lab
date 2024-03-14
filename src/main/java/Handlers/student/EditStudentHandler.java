package Handlers.student;

import Handlers.IHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import controllers.StudentController;
import exceptions.HandlerException;
import requests.student.EditStudentRequest;
import responses.CommonResponse;
import responses.EntityResponse;

public class EditStudentHandler implements IHandler {

    private final StudentController controller;

    public EditStudentHandler(StudentController controller) {
        this.controller = controller;
    }

    @Override
    public String handle(String json) throws HandlerException {
        ObjectMapper mapper = new ObjectMapper();
        try {
            EntityResponse<CommonResponse<Void>> res = controller.
                    editStudent(mapper.readValue(json, EditStudentRequest.class));
            return mapper.writeValueAsString(res);
        } catch (Exception e) {
            throw new HandlerException(e.getMessage());
        }
    }
}
