package RcForm.form.event;

import RcForm.form.element.ElementButton;
import RcForm.form.response.FormResponse;
import RcForm.form.window.FormRoot;
import RcForm.form.window.FormSimple;
import cn.nukkit.Player;
import cn.nukkit.event.HandlerList;
import cn.nukkit.event.player.PlayerEvent;

public class FormSimpleRespondEvent extends PlayerEvent {

    private static final HandlerList handlers = new HandlerList();
    protected int formID;
    protected FormSimple form;
    protected boolean closed = false;
    protected int clickButtonId;
    protected ElementButton clickButton;

    public static HandlerList getHandlers() {
        return handlers;
    }

    public FormSimpleRespondEvent(Player player, FormSimple form) {
        this.player = player;
        this.formID = form.getFormId();
        this.form = form;
    }

    public FormSimpleRespondEvent(Player player, FormSimple form, int clickButtonId, ElementButton elementButton) {
        this.player = player;
        this.formID = form.getFormId();
        this.form = form;
        this.clickButtonId = clickButtonId;
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

    public int getClickButtonId() {
        return clickButtonId;
    }

    public ElementButton getClickButton() {
        return clickButton;
    }
}
