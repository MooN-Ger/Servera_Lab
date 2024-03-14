package Handlers.group;

import Handlers.IHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import controllers.GroupController;
import exceptions.HandlerException;
import requests.IdRequest;
import responses.CommonResponse;
import responses.EntityResponse;
import responses.group.GetGroupByIdResponse;

public class GetGroupByIdHandler implements IHandler {

    private final GroupController controller;

    public GetGroupByIdHandler(GroupController controller) {
        this.controller = controller;
    }

    @Override
    public String handle(String json) throws HandlerException {
        ObjectMapper mapper = new ObjectMapper();
        try {
            EntityResponse<CommonResponse<GetGroupByIdResponse>> res = controller.
                    getGroupById(mapper.readValue(json, IdRequest.class));
            return mapper.writeValueAsString(res);
        } catch (Exception e) {
            throw new HandlerException(e.getMessage());
        }
    }
}
