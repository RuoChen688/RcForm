package RcForm.form.event;

import RcForm.form.element.ElementButton;
import RcForm.form.response.FormResponse;
import RcForm.form.window.FormModal;
import RcForm.form.window.FormRoot;
import cn.nukkit.Player;
import cn.nukkit.event.HandlerList;
import cn.nukkit.event.player.PlayerEvent;

public class FormModalRespondEvent extends PlayerEvent {

    private static final HandlerList handlers = new HandlerList();
    protected int formID;
    protected FormModal form;
    protected boolean closed = false;
    protected ElementButton clickButton;

    public static HandlerList getHandlers() {
        return handlers;
    }

    public FormModalRespondEvent(Player player, FormModal form) {
        this.player = player;
        this.formID = form.getFormId();
        this.form = form;
    }

    public FormModalRespondEvent(Player player, FormModal form, ElementButton elementButton) {
        this.player = player;
        this.formID = form.getFormId();
        this.form = form;
        this.clickButton = elementButton;
    }

    public int getFormID() {
        return this.formID;
    }

    public FormRoot getForm() {
        return this.form;
    }

    public FormResponse getResponse() {
        return this.form.getResponse();
    }

    public boolean wasClosed() {
        return this.form.wasClosed();
    }

    public ElementButton getClickButton() {
        return clickButton;
    }

}
