package controller;

import entities.Student;
import exceptions.ServerException;
import main.MainTest;
import models.Statuses;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StudentControllerTest extends MainTest {
    List<Student> list = new ArrayList<>(){{
        add(new Student(1L, "n", "s", "p", Statuses.ACTIVE,  1L));
    }};

    @Test
    public void addStudentTest1() throws IOException {
        String json1;
        try {
            json1 = new JSONObject().put("name", "student3_1").put("idGroup", 1L)
                    .put("status", Statuses.ACTIVE).toString();
            assertEquals(201, new JSONObject(server.executeRequest(json1, "add student")).get("httpStatus"));
        } catch (Exception e) {
            throw new IOException(e.getMessage());
        }
    }

    @Test
    public void deleteStudentTest1() throws IOException {
        String json1;
        String json2;
        try {
            json1 = new JSONObject().put("name", "student3_1").put("idGroup", 1L)
                    .put("status", Statuses.ACTIVE).toString();
            long x = Long.decode(
                    new JSONObject(server.executeRequest(json1, "add student"))
                            .getJSONObject("body").getJSONObject("data").getString("idStudent")
            );
            json2 = new JSONObject().put("id", x).toString();
            assertEquals(200,new JSONObject(server.executeRequest(json2, "delete student")).get("httpStatus"));
        } catch (Exception e) {
            throw new IOException(e.getMessage());
        }
    }

    @Test
    public void editAndGetByIdStudentTest1() throws IOException {
        String jsonAdd;
        String jsonGet;
        String jsonEdit;
        String jsonDelete;

        try {
            jsonAdd = new JSONObject().put("name", "StudentV1").put("idGroup", 1L)
                    .put("status", Statuses.ACTIVE).toString();
            Long idStudent = Long.decode(
                    new JSONObject(server.executeRequest(jsonAdd, "add student"))
                            .getJSONObject("body").getJSONObject("data").getString("idStudent")
            );
            jsonGet = new JSONObject().put("id", idStudent).toString();
            jsonEdit = new JSONObject().put("id", idStudent)
                    .put("name", "StudentV2").put("idGroup", 1L).put("status", Statuses.ACTIVE)
                    .toString();
            assertEquals(200,new JSONObject(server.executeRequest(jsonEdit, "edit student")).get("httpStatus"));
            assertEquals("StudentV2", new JSONObject(server.executeRequest(jsonGet, "get student by id"))
                    .getJSONObject("body").getJSONObject("data").getJSONObject("student").getString("name"));
            jsonDelete = new JSONObject().put("id", idStudent).toString();
            server.executeRequest(jsonDelete, "delete student");
        } catch (Exception e) {
            throw new IOException(e.getMessage());
        }
    }

    @Test
    public void getByGroupIdTest() throws IOException {
        String jsonGet;
        try {
            jsonGet = new JSONObject().put("id", 0L).toString();
            long[] expectedArr = new long[]{0L, 1L};
            System.out.println(server.executeRequest(jsonGet,"get students by group"));
            assertEquals(200 ,Integer.decode(new JSONObject(server.executeRequest(jsonGet,"get students by group"))
                    .getString("httpStatus")));
        } catch (Exception e) {
            throw new IOException(e.getMessage());
        }
    }

    @Test
    public void invalidEndpointTest() {
        ServerException thrown = assertThrows(ServerException.class, () ->{
            server.executeRequest(null, "");
        });
        assertEquals("No such endpoint", thrown.getMessage());
    }
}
