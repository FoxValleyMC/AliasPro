package AliasPro;

import AliasPro.Handler.DatabaseHandler;

import java.util.Map;

public class AliasPro {

    public static String getAlias(String uuid) {
        return DatabaseHandler.query(uuid, "uuid").get("alias").toString();
    }

    public static String getNick(String uuid) {
        return DatabaseHandler.query(uuid, "uuid").get("alias").toString();
    }

    public static Map<String, Object> getPlayer (String name) {
        return DatabaseHandler.query(name, "name");
    }

}
