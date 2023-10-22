package me.linkhealth.globalhealth.events;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class DamageListener implements Listener {
    @EventHandler(ignoreCancelled = true)
    public void onEntityDamage(EntityDamageEvent event) {
        if (!(event.getEntity() instanceof Player)) return;
        double amount = event.getDamage();
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (!player.equals(event.getEntity())) {
                double newHealth = ((Player) event.getEntity()).getHealth() - amount;
                newHealth = Math.max(newHealth, 0.0); // Ensure newHealth is no less than 0
                player.setHealth(newHealth);
                player.playHurtAnimation(0);
                player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_HURT, 10, 1);
            }
        }
    }
}
