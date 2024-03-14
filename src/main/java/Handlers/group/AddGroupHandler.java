package Handlers.group;

import Handlers.IHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import controllers.GroupController;
import exceptions.HandlerException;
import requests.group.AddGroupRequest;
import responses.CommonResponse;
import responses.EntityResponse;
import responses.group.AddGroupResponse;

public class AddGroupHandler implements IHandler {
    private final GroupController controller;

    public AddGroupHandler(GroupController controller) {
        this.controller = controller;
    }

    @Override
    public String handle(String json) throws HandlerException {
        ObjectMapper mapper = new ObjectMapper();
        try {
            EntityResponse<CommonResponse<AddGroupResponse>> res = controller.
                    addGroup(mapper.readValue(json, AddGroupRequest.class));
            return mapper.writeValueAsString(res);
        } catch (Exception e) {
            throw new HandlerException(e.getMessage());
        }
    }
}
