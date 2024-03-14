package Handlers.group;

import Handlers.IHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import controllers.GroupController;
import exceptions.HandlerException;
import requests.group.EditGroupRequest;
import responses.CommonResponse;
import responses.EntityResponse;

public class EditGroupHandler implements IHandler {

    private final GroupController controller;

    public EditGroupHandler(GroupController controller) {
        this.controller = controller;
    }

    @Override
    public String handle(String json) throws HandlerException {
        ObjectMapper mapper = new ObjectMapper();
        try {
            EntityResponse<CommonResponse<Void>> res = controller.
                    editGroup(mapper.readValue(json, EditGroupRequest.class));
            return mapper.writeValueAsString(res);
        } catch (Exception e) {
            throw new HandlerException(e.getMessage());
        }
    }
}
