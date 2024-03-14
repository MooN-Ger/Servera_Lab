package controllers;

import entities.Group;
import requests.IdRequest;
import requests.group.AddGroupRequest;
import requests.group.EditGroupRequest;
import responses.CommonResponse;
import responses.EntityResponse;
import responses.group.AddGroupResponse;
import responses.group.GetGroupByIdResponse;
import services.group.GroupService;
import validator.request.IdRequestValidator;
import validator.request.group.AddGroupRequestValidator;
import validator.request.group.EditGroupRequestValidator;

import java.util.List;

public class GroupController {
    private  final GroupService groupService;
    private final AddGroupRequestValidator addGroupValidator;
    private final EditGroupRequestValidator editGroupValidator;
    private final IdRequestValidator idValidator;

    public GroupController(GroupService groupService, AddGroupRequestValidator addGroupValidator,
                           EditGroupRequestValidator editGroupValidator, IdRequestValidator idValidator) {
        this.groupService = groupService;
        this.addGroupValidator = addGroupValidator;
        this.editGroupValidator = editGroupValidator;
        this.idValidator = idValidator;
    }

    public EntityResponse<CommonResponse<AddGroupResponse>> addGroup(AddGroupRequest request) {
        int status = 201;
        CommonResponse<AddGroupResponse> commonResponse;
        List<String> errors = addGroupValidator.validate(request);
        if (errors.isEmpty()) {
            try {
                commonResponse = new CommonResponse<>(new AddGroupResponse(groupService.addGroup(request.getName())));
            } catch (Exception e) {
                status = 500;
                commonResponse = new CommonResponse<>(1, e.getMessage());
            }
        } else {
            commonResponse = new CommonResponse<>(0, "Validation error", errors);
            status = 422;
        }
        return new EntityResponse<>(commonResponse, status);
    }

    public EntityResponse<CommonResponse<Void>> editGroup(EditGroupRequest request) {
        int status = 200;
        CommonResponse<Void> commonResponse;
        List<String> errors = editGroupValidator.validate(request);
        if (errors.isEmpty()) {
            try {
                groupService.editGroup(request.getGroup());
                commonResponse = new CommonResponse<>(null);
            } catch (Exception e) {
                status = 500;
                commonResponse = new CommonResponse<>(1, e.getMessage());
            }
        } else {
            commonResponse = new CommonResponse<>(2, "Validation error", errors);
            status = 422;
        }
        return new EntityResponse<>(commonResponse, status);
    }

    public EntityResponse<CommonResponse<GetGroupByIdResponse>> getGroupById(IdRequest request) {
        int status = 200;
        CommonResponse<GetGroupByIdResponse> commonResponse;
        List<String> errors = idValidator.validate(request);
        if (errors.isEmpty()) {
            try {
                commonResponse = new CommonResponse<>(new GetGroupByIdResponse(groupService.getGroupById(request.getId())));
            } catch (Exception e) {
                status = 500;
                commonResponse = new CommonResponse<>(1, e.getMessage());
            }
        } else {
            commonResponse = new CommonResponse<>(3, "Validation error", errors);
            status = 422;
        }
        return new EntityResponse<>(commonResponse, status);
    }

   public EntityResponse<CommonResponse<Void>> deleteGroup(IdRequest request) {
        int status = 200;
        CommonResponse<Void> commonResponse;
        List<String> errors = idValidator.validate(request);
        if (errors.isEmpty()) {
            try {
                groupService.deleteGroup(request.getId());
                commonResponse = new CommonResponse<>(null);
            } catch (Exception e) {
                status = 500;
                commonResponse = new CommonResponse<>(1, e.getMessage());
            }
        } else {
            commonResponse = new CommonResponse<>(1, "Validation error", errors);
            status = 422;
        }
        return new EntityResponse<>(commonResponse, status);
   }
}
