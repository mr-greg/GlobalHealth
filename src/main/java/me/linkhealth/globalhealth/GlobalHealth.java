package me.linkhealth.globalhealth;

import me.linkhealth.globalhealth.events.DamageListener;
import me.linkhealth.globalhealth.events.HealListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class GlobalHealth extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getPluginManager().registerEvents(new DamageListener(), this);
        Bukkit.getPluginManager().registerEvents(new HealListener(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
