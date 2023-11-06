package RcForm;

import RcForm.form.PlayerForm;
import RcForm.form.event.FormCustomRespondEvent;
import RcForm.form.event.FormModalRespondEvent;
import RcForm.form.event.FormSimpleRespondEvent;
import RcForm.form.window.FormCustom;
import RcForm.form.window.FormModal;
import RcForm.form.window.FormSimple;
import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerInteractEvent;
import cn.nukkit.event.player.PlayerJoinEvent;
import cn.nukkit.event.server.DataPacketReceiveEvent;
import cn.nukkit.form.element.ElementLabel;
import cn.nukkit.form.window.FormWindowCustom;
import cn.nukkit.network.protocol.DataPacket;
import cn.nukkit.network.protocol.ModalFormResponsePacket;
import cn.nukkit.plugin.PluginBase;

public class Main extends PluginBase implements Listener {

    @Override
    public void onEnable(){
        this.getLogger().info("插件加载成功,作者：若尘");
        this.getServer().getPluginManager().registerEvents(this,this);
    }

    @EventHandler
    public void onRespond(DataPacketReceiveEvent event){
        Player player = event.getPlayer();
        DataPacket packet = event.getPacket();
        if(packet instanceof ModalFormResponsePacket){
            boolean flag = true;
            if(((ModalFormResponsePacket) packet).data.trim().equals("null")) {
                flag = false;
            }
            if(PlayerForm.getForm(player) instanceof FormSimple){
                FormSimple form = (FormSimple) PlayerForm.getForm(player);
                if (form != null) {
                    FormSimpleRespondEvent ev;
                    if(!flag){
                        form.setClosed(true);
                        ev = new FormSimpleRespondEvent(player,form);
                        PlayerForm.clearForm(player);
                    }else{
                        form.setResponse(((ModalFormResponsePacket) packet).data.replaceAll("[^0-9]",""));
                        ev = new FormSimpleRespondEvent(player,form,form.getResponse().getClickedButtonId(),form.getResponse().getClickedButton());
                    }
                    this.getServer().getPluginManager().callEvent(ev);
                }
            }else if(PlayerForm.getForm(player) instanceof FormModal){
                FormModal form = (FormModal) PlayerForm.getForm(player);
                if(form != null){
                    FormModalRespondEvent ev;
                    if(!flag){
                        form.setClosed(true);
                        ev = new FormModalRespondEvent(player,form);
                        PlayerForm.clearForm(player);
                    }else{
                        form.setResponse(((ModalFormResponsePacket) packet).data.replaceAll("[^a-z]",""));
                        ev = new FormModalRespondEvent(player,form,form.getResponse().getClickedButton());
                    }
                    this.getServer().getPluginManager().callEvent(ev);
                }
            }else if(PlayerForm.getForm(player) instanceof FormCustom){
                FormCustom form = (FormCustom) PlayerForm.getForm(player);
                if(form != null){
                    FormCustomRespondEvent ev;
                    if(!flag){
                        form.setClosed(true);
                        ev = new FormCustomRespondEvent(player,form);
                        PlayerForm.clearForm(player);
                    }else{
                        form.setResponse(((ModalFormResponsePacket) packet).data.trim());
                        ev = new FormCustomRespondEvent(player,form,form.getResponse().getResponses());
                    }
                    this.getServer().getPluginManager().callEvent(ev);
                }
            }
        }
    }

}
