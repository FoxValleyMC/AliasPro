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

    public static String getPlayer (String name) {
        Map<String, Object> objectMap = DatabaseHandler.query(name, "name");
        if (name == null) {
            return null;
        } else {
            return objectMap.get("uuid").toString();
        }
    }

}
