package Handlers.student;

import Handlers.IHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import controllers.StudentController;
import exceptions.HandlerException;
import requests.IdRequest;
import responses.CommonResponse;
import responses.EntityResponse;
import responses.student.GetStudentByIdResponse;

public class GetStudentByIdHandler implements IHandler {

    private final StudentController controller;

    public GetStudentByIdHandler(StudentController controller) {
        this.controller = controller;
    }

    @Override
    public String handle(String json) throws HandlerException {
        ObjectMapper mapper = new ObjectMapper();
        try {
            EntityResponse<CommonResponse<GetStudentByIdResponse>> res = controller.
                    getStudentById(mapper.readValue(json, IdRequest.class));
            return mapper.writeValueAsString(res);
        } catch (Exception e) {
            throw new HandlerException(e.getMessage());
        }
    }
}
