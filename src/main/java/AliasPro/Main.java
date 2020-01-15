package AliasPro;

import AliasPro.Commands.AliasCommand;
import AliasPro.Events.JoinEvent;
import cn.nukkit.command.CommandMap;
import cn.nukkit.plugin.PluginBase;

public class Main extends PluginBase {

    private static Main instance;

    @Override
    public  void onLoad() {
        instance = this;
        CommandMap commandMap = this.getServer().getCommandMap();
        commandMap.register("AliasPro", new AliasCommand("alias", this));
    }

    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        this.getServer().getPluginManager().registerEvents(new JoinEvent(), this);
    }

    public static Main getInstance() {
        return instance;
    }
}
