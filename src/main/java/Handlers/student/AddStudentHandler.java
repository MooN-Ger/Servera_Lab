package Handlers.student;

import Handlers.IHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import controllers.StudentController;
import exceptions.HandlerException;
import requests.student.AddStudentRequest;
import responses.CommonResponse;
import responses.EntityResponse;
import responses.student.AddStudentResponse;

public class AddStudentHandler implements IHandler {

    private final StudentController controller;

    public AddStudentHandler(StudentController controller) {
        this.controller = controller;
    }

    @Override
    public String handle(String json) throws HandlerException {
        ObjectMapper mapper = new ObjectMapper();
        try {
            EntityResponse<CommonResponse<AddStudentResponse>> res = controller.
                    addStudent(mapper.readValue(json, AddStudentRequest.class));
            return mapper.writeValueAsString(res);
        } catch (Exception e) {
            throw new HandlerException(e.getMessage());
        }
    }
}
