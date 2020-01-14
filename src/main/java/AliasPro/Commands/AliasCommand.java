package AliasPro.Commands;

import AliasPro.Handler.DatabaseHandler;
import AliasPro.Main;
import cn.nukkit.Player;
import cn.nukkit.command.CommandSender;
import cn.nukkit.command.PluginCommand;

public class AliasCommand extends PluginCommand {

    private Main plugin;

    public AliasCommand (String name, Main plugin) {
        super(name, plugin);
        this.plugin = plugin;
        this.setAliases(new String[]{"nick"});
    }

    @Override
    public boolean execute(CommandSender sender, String commandLabel, String[] args) {
        if (sender instanceof Player) {

            if (sender.hasPermission("alias.set") || sender.isOp()) {
                if (args.length == 1) {
                    Player player = (Player) sender;
                    String uuid = player.getUniqueId().toString();
                    DatabaseHandler.update(uuid, "alias", args[0]);
                    player.setDisplayName(args[0]);
                    player.setNameTag(args[0]);
                    player.sendMessage("Set Alias/nickname to: "+args[0]);
                } else {
                    sender.sendMessage("Usage: { /nick : /alias } <new name>");
                }
            } else {
                sender.sendMessage("You do not have permission to set aliases!");
            }
        } else {
            sender.sendMessage("You cannot run command though console!");
        }
        return true;
    }
}
