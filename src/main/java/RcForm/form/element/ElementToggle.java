package RcForm.form.element;

import RcForm.form.ExecuteFunction;
import RcForm.form.response.FormResponse;
import cn.nukkit.Player;
import com.google.gson.annotations.SerializedName;

public class ElementToggle extends Element{

    private final String type = "toggle";
    private String text;
    @SerializedName("default")
    private boolean defaultValue;

    private ExecuteFunction function;

    public ElementToggle(String text) {
        this(text, false);
    }

    public ElementToggle(String text, boolean defaultValue) {
        this.text = text;
        this.defaultValue = defaultValue;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isDefaultValue() {
        return this.defaultValue;
    }

    public void setDefaultValue(boolean defaultValue) {
        this.defaultValue = defaultValue;
    }

    public void setFunction(ExecuteFunction function){
        this.function = function;
    }

    public void execute(Player player, FormResponse formResponse){
        this.function.dispose(player,formResponse);
    }

}
