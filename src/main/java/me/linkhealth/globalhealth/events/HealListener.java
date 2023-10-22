package me.linkhealth.globalhealth.events;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityRegainHealthEvent;

public class HealListener implements Listener {
    @EventHandler(ignoreCancelled = true)
    public void onEntityRegainHealth(EntityRegainHealthEvent event) {
        if (!(event.getEntity() instanceof Player)) return;
        double amount = event.getAmount();
        for (Player player : Bukkit.getOnlinePlayers()) {
            double newHealth = ((Player) event.getEntity()).getHealth() + amount;
            newHealth = Math.min(newHealth, 20.0); // Ensure newHealth is no more than 20
            player.setHealth(newHealth);
        }
    }
}
