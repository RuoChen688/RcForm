package RcForm.form.element;

import RcForm.form.ExecuteFunction;
import RcForm.form.response.FormResponse;
import cn.nukkit.Player;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ElementDropdown extends Element{

    private final String type = "dropdown";
    private String text;
    private List<String> options;
    @SerializedName("default")
    private int defaultOptionIndex;

    private ExecuteFunction function;

    public ElementDropdown(String text) {
        this(text, new ArrayList());
    }

    public ElementDropdown(String text, List<String> options) {
        this(text, options, 0);
    }

    public ElementDropdown(String text, List<String> options, int defaultOption) {
        this.text = text;
        this.options = options;
        this.defaultOptionIndex = defaultOption;
    }

    public ElementDropdown(String text, List<String> options, int defaultOption,ExecuteFunction function) {
        this.text = text;
        this.options = options;
        this.defaultOptionIndex = defaultOption;
        this.function = function;
    }

    public int getDefaultOptionIndex() {
        return this.defaultOptionIndex;
    }

    public void setDefaultOptionIndex(int index) {
        if (index < this.options.size()) {
            this.defaultOptionIndex = index;
        }
    }

    public List<String> getOptions() {
        return this.options;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void addOption(String option) {
        this.addOption(option, false);
    }

    public void addOption(String option, boolean isDefault) {
        this.options.add(option);
        if (isDefault) {
            this.defaultOptionIndex = this.options.size() - 1;
        }
    }

    public void setFunction(ExecuteFunction function){
        this.function = function;
    }

    public void execute(Player player, FormResponse response){
        this.function.dispose(player,response);
    }

}
