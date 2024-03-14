package Handlers.student;

import Handlers.IHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import controllers.StudentController;
import entities.Student;
import exceptions.HandlerException;
import requests.IdRequest;
import responses.CommonResponse;
import responses.EntityResponse;

import java.util.List;

public class GetAllStudentsByGroupIdHandler implements IHandler {

    private final StudentController controller;

    public GetAllStudentsByGroupIdHandler(StudentController controller) {
        this.controller = controller;
    }

    @Override
    public String handle(String json) throws HandlerException {
        ObjectMapper mapper = new ObjectMapper();
        try {
            EntityResponse<CommonResponse<List<Student>>> res = controller.
                    getAllStudentsByGroupId(mapper.readValue(json, IdRequest.class));
            return mapper.writeValueAsString(res);
        } catch (Exception e) {
            throw new HandlerException(e.getMessage());
        }
    }
}
