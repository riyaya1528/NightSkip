package riyaya1528.paper.nightskip;

import io.papermc.paper.event.player.PlayerDeepSleepEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBedLeaveEvent;

public class Sleep implements Listener {
    int sleepPlayer = 0;

    @EventHandler
    public void onSleep(PlayerBedEnterEvent e) {
        sleepPlayer = sleepPlayer + 1;

        if(sleepPlayer >= NightSkip.PlayerSleepNeed) {
            e.getPlayer().getWorld().setTime(1000);
        }
    }
    @EventHandler
    public void onUnSleep(PlayerBedLeaveEvent e) {
        sleepPlayer = sleepPlayer - 1;

        if(sleepPlayer <= 0) {
            sleepPlayer = 0;
        }
    }
}
