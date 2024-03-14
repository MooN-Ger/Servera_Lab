package main;

import com.fasterxml.jackson.core.JsonParseException;
import models.Statuses;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeAll;
import server.Server;

public class MainTest {
    protected static Server server;

    @BeforeAll
    public static void setup() throws JsonParseException {
        server = new Server();
        try {
            server.executeRequest(new JSONObject().put("name", "student0_0").put("idGroup", 0L)
                    .put("status", Statuses.ACTIVE).toString(), "add student");
            server.executeRequest(new JSONObject().put("name", "student1_0").put("idGroup", 0L)
                    .put("status", Statuses.ACTIVE).toString(), "add student");
            server.executeRequest(new JSONObject().put("name", "student2_1").put("idGroup", 1L)
                    .put("status", Statuses.ACTIVE).toString(), "add student");

            server.executeRequest(new JSONObject().put("name", "group0").toString(), "add group");
            server.executeRequest(new JSONObject().put("name", "group1").toString(), "add group");
        } catch (Exception e) {
            throw new JsonParseException(e.getMessage());
        }
    }

}
