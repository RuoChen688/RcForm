package RcForm.form.element;

import RcForm.form.ExecuteFunction;
import RcForm.form.response.FormResponse;
import cn.nukkit.Player;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ElementStepSlider extends Element{

    private final String type = "step_slider";
    private String text;
    private List<String> steps;
    @SerializedName("default")
    private int defaultStepIndex;

    private ExecuteFunction function;

    public ElementStepSlider(String text) {
        this(text, new ArrayList());
    }

    public ElementStepSlider(String text, List<String> steps) {
        this(text, steps, 0);
    }

    public ElementStepSlider(String text, List<String> steps, int defaultStep) {
        this.text = text;
        this.steps = steps;
        this.defaultStepIndex = defaultStep;
    }

    public ElementStepSlider(String text, List<String> steps, int defaultStep,ExecuteFunction function) {
        this.text = text;
        this.steps = steps;
        this.defaultStepIndex = defaultStep;
        this.function = function;
    }

    public int getDefaultStepIndex() {
        return this.defaultStepIndex;
    }

    public void setDefaultOptionIndex(int index) {
        if (index < this.steps.size()) {
            this.defaultStepIndex = index;
        }
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<String> getSteps() {
        return this.steps;
    }

    public void addStep(String step) {
        this.addStep(step, false);
    }

    public void addStep(String step, boolean isDefault) {
        this.steps.add(step);
        if (isDefault) {
            this.defaultStepIndex = this.steps.size() - 1;
        }

    }

    public void setFunction(ExecuteFunction function){
        this.function = function;
    }

    public void execute(Player player, FormResponse formResponse){
        this.function.dispose(player,formResponse);
    }

}
