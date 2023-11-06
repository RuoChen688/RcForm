package RcForm.form;

import RcForm.form.event.ServerSettingRequestEvent;
import RcForm.form.window.FormRoot;
import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.event.player.PlayerServerSettingsRequestEvent;
import cn.nukkit.network.protocol.ModalFormRequestPacket;
import cn.nukkit.network.protocol.ServerSettingsRequestPacket;
import cn.nukkit.network.protocol.ServerSettingsResponsePacket;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class PlayerForm {

    private static LinkedHashMap<Player, FormRoot> playerForm = new LinkedHashMap<>();

    public static FormRoot getForm(Player player){
        if(!PlayerForm.playerForm.containsKey(player) || PlayerForm.playerForm.get(player) == null){
            return null;
        }else{
            return PlayerForm.playerForm.get(player);
        }
    }

    public static void setForm(Player player,FormRoot form){
        PlayerForm.playerForm.put(player,form);
    }

    public static void clearForm(Player player){
        if(PlayerForm.playerForm.containsKey(player)){
            PlayerForm.playerForm.remove(player);
        }
    }

    public static void showForm(Player player,FormRoot form){
        ModalFormRequestPacket packet = new ModalFormRequestPacket();
        packet.formId = form.getFormId();
        packet.data = form.getJSONData();
        player.dataPacket(packet);
        PlayerForm.setForm(player,form);
    }

    public static void showServerSetting(Player player,FormRoot form){
        ServerSettingRequestEvent ev = new ServerSettingRequestEvent(player,new HashMap<>(){{
            put(10086,form);
        }});
        Server.getInstance().getPluginManager().callEvent(ev);
        ServerSettingsResponsePacket packet = new ServerSettingsResponsePacket();
        packet.formId = 10086;
        packet.data = form.getJSONData();
        player.dataPacket(packet);
    }

}
