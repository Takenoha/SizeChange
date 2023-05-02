package pro.freeserver.takenoh.SizeChange;

import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;
import pro.freeserver.takenoh.consts.BigBlockData;
import pro.freeserver.takenoh.events.BlockDamage;
import pro.freeserver.takenoh.events.PlayerInteract;

import java.util.HashMap;
import java.util.Map;

public final class SizeChange extends JavaPlugin {

    public static Map<Location,BigBlockData> bigBlockData1;
    @Override
    public void onEnable() {
        // Plugin startup logic
        bigBlockData1 = new HashMap<>();
        getServer().getPluginManager().registerEvents(new BlockDamage(), this);
        getServer().getPluginManager().registerEvents(new PlayerInteract(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


}
