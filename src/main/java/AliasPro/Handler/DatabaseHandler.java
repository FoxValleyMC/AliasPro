package AliasPro.Handler;

import AliasPro.Main;
import NukkitDB.NukkitDB;

import java.util.Map;

public class DatabaseHandler {

    public static Map<String, Object> query(String key, String fieldName) {
        String database = Main.getInstance().getConfig().getString("database");
        String collection = Main.getInstance().getConfig().getString("collection");
        return NukkitDB.query(key, fieldName, database, collection);
    }

    public static void createNew(Map<String, Object> objectMap) {
        NukkitDB.insertDocument(objectMap, Main.getInstance().getConfig().getString("database"), Main.getInstance().getConfig().getString("collection"));
    }

    public static void update(String query, String key, String value) {
        NukkitDB.updateDocument(query, "uuid", key, value, Main.getInstance().getConfig().getString("database"), Main.getInstance().getConfig().getString("collection"));
    }

}
