package riyaya1528.paper.nightskip;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class NightSkip extends JavaPlugin implements Listener {
    public static boolean NightSkip = true;
    public static int PlayerSleepNeed;
    public static String SleepNowMessage;
    public static String SleepSuccessMessage;

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new Sleep(), this);
        saveDefaultConfig();
        NightSkip = getConfig().getBoolean("NightSkip");
        PlayerSleepNeed = getConfig().getInt("PlayerSleepNeed");
        SleepNowMessage = getConfig().getString("SleepNowMessage");
        SleepSuccessMessage = getConfig().getString("SleepSuccessMessage");


        System.out.println("[NightSkip]プラグインが有効になりました");
    }

    @Override
    public void onDisable() {
        System.out.println("[NightSkip]プラグインが無効になりました");
    }
}
