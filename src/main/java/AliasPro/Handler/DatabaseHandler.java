package AliasPro.Handler;

import AliasPro.Main;
import NukkitDB.NukkitDB;
import org.bson.Document;

public class DatabaseHandler {

    public static Document query(String key, String fieldName) {
        String database = Main.getInstance().getConfig().getString("database");
        String collection = Main.getInstance().getConfig().getString("collection");
        return NukkitDB.query(key.toLowerCase(), fieldName, database, collection);
    }

    public static void createNew(Document document) {
        NukkitDB.insertDocument(document, Main.getInstance().getConfig().getString("database"), Main.getInstance().getConfig().getString("collection"));
    }

    public static void update(String query, String key, String value) {
        NukkitDB.updateDocument(query, "uuid", key.toLowerCase(), value, Main.getInstance().getConfig().getString("database"), Main.getInstance().getConfig().getString("collection"));
    }

}
