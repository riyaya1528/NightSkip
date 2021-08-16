package riyaya1528.paper.nightskip;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBedLeaveEvent;

import static org.bukkit.Bukkit.getServer;

public class Sleep implements Listener {
    int sleepPlayers = 0;
    String SleepNowMessage = NightSkip.SleepNowMessage;

    @EventHandler
    public void onSleep(PlayerBedEnterEvent e) {
        if(!isDay(e.getPlayer().getWorld().getName())) {
            sleepPlayers = sleepPlayers + 1;
            int SleepNowPlayers = NightSkip.PlayerSleepNeed - sleepPlayers;
            SleepNowMessage = NightSkip.SleepNowMessage.replace("[プレイヤーの数]",String.valueOf(SleepNowPlayers));

            if(SleepNowPlayers <= 0) {
                for (Player p : e.getPlayer().getWorld().getPlayers()) {
                    p.sendMessage(NightSkip.SleepSuccessMessage);
                }
            } else {
                for (Player p : e.getPlayer().getWorld().getPlayers()) {
                    p.sendMessage(SleepNowMessage);
                }
            }

            if(sleepPlayers >= NightSkip.PlayerSleepNeed) {
                e.getPlayer().getWorld().setTime(1000);
                sleepPlayers = 0;
            }
        }
    }
    @EventHandler
    public void onUnSleep(PlayerBedLeaveEvent e) {
        if(!isDay(e.getPlayer().getWorld().getName())) {
            sleepPlayers = sleepPlayers - 1;

            if (sleepPlayers <= 0) {
                sleepPlayers = 0;
            }

            int SleepNowPlayers = NightSkip.PlayerSleepNeed - sleepPlayers;
            SleepNowMessage = NightSkip.SleepNowMessage.replace("[プレイヤーの数]", String.valueOf(SleepNowPlayers));

            if(SleepNowPlayers <= 0) {
                for (Player p : e.getPlayer().getWorld().getPlayers()) {
                    p.sendMessage(NightSkip.SleepSuccessMessage);
                }
            } else {
                for (Player p : e.getPlayer().getWorld().getPlayers()) {
                    p.sendMessage(SleepNowMessage);
                }
            }
        }
    }

    public boolean isDay(String worldname) {

        long time = getServer().getWorld(worldname).getTime();
        return time < 12300 || time > 23850;

    }
}
