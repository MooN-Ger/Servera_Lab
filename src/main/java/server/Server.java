package server;

import Handlers.IHandler;
import Handlers.group.AddGroupHandler;
import Handlers.group.DeleteGroupHandler;
import Handlers.group.EditGroupHandler;
import Handlers.group.GetGroupByIdHandler;
import Handlers.professor.EditProfessorHandler;
import Handlers.professor.GetProfessorsByPositionHandler;
import Handlers.student.*;
import controllers.GroupController;
import controllers.ProfessorController;
import controllers.StudentController;
import exceptions.ServerException;
import repositories.DataBase;
import repositories.group.GroupRepository;
import repositories.professor.ProfessorRepository;
import repositories.student.StudentRepository;
import services.group.GroupService;
import services.professor.ProfessorService;
import services.student.StudentService;
import validator.request.IdRequestValidator;
import validator.request.StringRequestValidator;
import validator.request.group.AddGroupRequestValidator;
import validator.request.group.EditGroupRequestValidator;
import validator.request.professor.EditProfessorRequestValidator;
import validator.request.student.AddStudentRequestValidator;
import validator.request.student.EditStudentRequestValidator;

import java.util.HashMap;
import java.util.Map;

public class Server implements IServer {

    private static Map<String, IHandler> handler;

    private static StudentController studentController;
    private static GroupController groupController;
    private static ProfessorController professorController;

    static {
        DataBase dataBase = new DataBase(new HashMap<>(), new HashMap<>(), new HashMap<>());
        StudentService studentService = new StudentService(new StudentRepository(dataBase));
        GroupService groupService = new GroupService(new GroupRepository(dataBase));
        ProfessorService professorService = new ProfessorService(new ProfessorRepository(dataBase));
        studentController = new StudentController(studentService, new AddStudentRequestValidator(),
                new EditStudentRequestValidator(), new IdRequestValidator());
        groupController = new GroupController(groupService, new AddGroupRequestValidator(),
                new EditGroupRequestValidator(), new IdRequestValidator());
        professorController = new ProfessorController(professorService,
                new EditProfessorRequestValidator(), new StringRequestValidator());
        handler = new HashMap<>();
        handler.put("add student", new AddStudentHandler(studentController));
        handler.put("edit student", new EditStudentHandler(studentController));
        handler.put("get student by id", new GetStudentByIdHandler(studentController));
        handler.put("get all students by group id", new GetAllStudentsByGroupIdHandler(studentController));
        handler.put("delete student", new DeleteStudentHandler(studentController));
        handler.put("add group", new AddGroupHandler(groupController));
        handler.put("edit group", new EditGroupHandler(groupController));
        handler.put("get group by id", new GetGroupByIdHandler(groupController));
        handler.put("delete group", new DeleteGroupHandler(groupController));
        handler.put("edit professor", new EditProfessorHandler(professorController));
        handler.put("get professors by position", new GetProfessorsByPositionHandler(professorController));
    }

    public Server() {}

    @Override
    public String executeRequest(String json, String endPoint) throws ServerException {
        if (!handler.containsKey(endPoint)) throw new ServerException("No such endpoint");
        try {
            return handler.get(endPoint).handle(json);
        } catch (Exception e) {
            throw new ServerException(e.getMessage());
        }
    }

}
