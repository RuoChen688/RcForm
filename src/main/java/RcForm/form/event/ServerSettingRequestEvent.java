package RcForm.form.event;

import RcForm.form.window.FormRoot;
import cn.nukkit.Player;
import cn.nukkit.event.Cancellable;
import cn.nukkit.event.HandlerList;
import cn.nukkit.event.player.PlayerEvent;
import cn.nukkit.form.window.FormWindow;

import java.util.Map;

public class ServerSettingRequestEvent extends PlayerEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private Map<Integer, FormRoot> settings;

    public static HandlerList getHandlers() {
        return handlers;
    }

    public ServerSettingRequestEvent(Player player, Map<Integer, FormRoot> settings) {
        this.player = player;
        this.settings = settings;
        System.out.println("呵呵");
    }

    public Map<Integer, FormRoot> getSettings() {
        return this.settings;
    }

    public void setSettings(Map<Integer, FormRoot> settings) {
        this.settings = settings;
    }

    public void setSettings(int id, FormRoot window) {
        this.settings.put(id, window);
    }

}
