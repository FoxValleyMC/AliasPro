package AliasPro.Events;

import AliasPro.Handler.DatabaseHandler;
import AliasPro.Main;
import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerJoinEvent;
import cn.nukkit.utils.TextFormat;

import java.util.HashMap;
import java.util.Map;

public class JoinEvent implements Listener {

    @EventHandler()
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        String uuid = player.getUniqueId().toString();

        Map<String, Object> query = DatabaseHandler.query(uuid, "uuid");
        if (query == null) {
            Map<String, Object> objectMap = new HashMap<String, Object>();
            objectMap.put("uuid", uuid);
            objectMap.put("alias", player.getName());
            DatabaseHandler.createNew(objectMap);
        } else {
            String alias = query.get("alias").toString();
            player.setDisplayName(alias);
            player.setNameTag(alias);
            event.setJoinMessage(TextFormat.YELLOW + alias + " joined the game");
        }
    }
}
