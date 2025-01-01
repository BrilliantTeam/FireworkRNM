package engineer.skyouo.plugins.fireworkrnm;

import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

public final class FireworkRNM extends JavaPlugin {
    public void onEnable() {
        getCommand("firework").setExecutor((CommandExecutor)new FireworkCommand());
    }
    
    public void onDisable() {}
}
