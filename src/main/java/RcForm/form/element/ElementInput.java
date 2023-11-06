package RcForm.form.element;

import RcForm.form.ExecuteFunction;
import RcForm.form.response.FormResponse;
import cn.nukkit.Player;
import com.google.gson.annotations.SerializedName;

public class ElementInput extends Element{

    private final String type = "input";
    private String text;
    private String placeholder;
    @SerializedName("default")
    private String defaultText;

    private ExecuteFunction function;

    public ElementInput(String text) {
        this(text, "");
    }

    public ElementInput(String text, String placeholder) {
        this(text, placeholder, "");
    }

    public ElementInput(String text, String placeholder, String defaultText) {
        this.text = text;
        this.placeholder = placeholder;
        this.defaultText = defaultText;
    }

    public ElementInput(String text, String placeholder, String defaultText,ExecuteFunction function) {
        this.text = text;
        this.placeholder = placeholder;
        this.defaultText = defaultText;
        this.function = function;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPlaceHolder() {
        return this.placeholder;
    }

    public void setPlaceHolder(String placeholder) {
        this.placeholder = placeholder;
    }

    public String getDefaultText() {
        return this.defaultText;
    }

    public void setDefaultText(String defaultText) {
        this.defaultText = defaultText;
    }

    public void setFunction(ExecuteFunction function){
        this.function = function;
    }

    public void execute(Player player, FormResponse formResponse){
        this.function.dispose(player, formResponse);
    }

}
