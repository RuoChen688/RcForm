package RcForm.form.event;

import RcForm.form.element.*;
import RcForm.form.response.FormResponse;
import RcForm.form.response.FormResponseData;
import RcForm.form.window.FormCustom;
import RcForm.form.window.FormRoot;
import cn.nukkit.Player;
import cn.nukkit.event.HandlerList;
import cn.nukkit.event.player.PlayerEvent;

import java.util.HashMap;

public class FormCustomRespondEvent extends PlayerEvent {

    private static final HandlerList handlers = new HandlerList();
    protected int formID;
    protected FormCustom form;
    protected boolean closed = false;
    protected HashMap<Integer, FormResponseData> dropdownResponses = new HashMap<>();
    protected HashMap<Integer, String> inputResponses = new HashMap<>();
    protected HashMap<Integer, Float> sliderResponses = new HashMap<>();
    protected HashMap<Integer, FormResponseData> stepSliderResponses = new HashMap<>();
    protected HashMap<Integer, Boolean> toggleResponses = new HashMap<>();
    protected HashMap<Integer, String> labelResponses = new HashMap<>();

    public static HandlerList getHandlers() {
        return handlers;
    }

    public FormCustomRespondEvent(Player player, FormCustom form) {
        this.player = player;
        this.formID = form.getFormId();
        this.form = form;
    }

    public FormCustomRespondEvent(Player player, FormCustom form, HashMap<Integer,Object> responses) {
        this.player = player;
        this.formID = form.getFormId();
        this.form = form;

        for(int i = 0;i < form.getElements().size();i++){
            Element element = form.getElements().get(i);
            if(element instanceof ElementLabel){
                this.labelResponses.put(i, String.valueOf(responses.get(i)));
            }else if(element instanceof ElementDropdown){
                this.dropdownResponses.put(i, (FormResponseData) responses.get(i));
            }else if(element instanceof ElementInput){
                this.inputResponses.put(i, String.valueOf(responses.get(i)));
            }else if(element instanceof ElementSlider){
                this.sliderResponses.put(i, (Float) responses.get(i));
            }else if(element instanceof ElementStepSlider){
                this.stepSliderResponses.put(i, (FormResponseData) responses.get(i));
            }else if(element instanceof ElementToggle){
                this.toggleResponses.put(i, (Boolean) responses.get(i));
            }
        }

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

    public HashMap<Integer, FormResponseData> getDropdownResponses() {
        return dropdownResponses;
    }

    public HashMap<Integer, String> getInputResponses() {
        return inputResponses;
    }

    public HashMap<Integer, Float> getSliderResponses() {
        return sliderResponses;
    }

    public HashMap<Integer, FormResponseData> getStepSliderResponses() {
        return stepSliderResponses;
    }

    public HashMap<Integer, Boolean> getToggleResponses() {
        return toggleResponses;
    }

    public HashMap<Integer, String> getLabelResponses() {
        return labelResponses;
    }
}
