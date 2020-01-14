package AliasPro.Events;

import AliasPro.Handler.DatabaseHandler;
import AliasPro.Main;
import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerJoinEvent;
import cn.nukkit.utils.TextFormat;
import org.bson.Document;

public class JoinEvent implements Listener {

    private Main plugin;

    public JoinEvent(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler()
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        String uuid = player.getUniqueId().toString();

        Document query = DatabaseHandler.query(uuid, "uuid");
        if (query == null) {
            Document document = new Document();
            document.append("uuid", uuid);
            document.append("alias", player.getName());
            DatabaseHandler.createNew(document);
        } else {
            String alias = query.getString("alias");
            player.setDisplayName(alias);
            player.setNameTag(alias);
            event.setJoinMessage(TextFormat.YELLOW + alias + " joined the game");
        }
    }
}
