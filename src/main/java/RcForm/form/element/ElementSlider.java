package RcForm.form.element;

import RcForm.form.ExecuteFunction;
import RcForm.form.response.FormResponse;
import cn.nukkit.Player;
import com.google.gson.annotations.SerializedName;

public class ElementSlider extends Element{

    private final String type = "slider";
    private String text;
    private float min;
    private float max;
    private int step;
    @SerializedName("default")
    private float defaultValue;

    private ExecuteFunction function;

    public ElementSlider(String text, float min, float max) {
        this(text, min, max, 1);
    }

    public ElementSlider(String text, float min, float max, int step) {
        this(text, min, max, step, min);
    }

    public ElementSlider(String text, float min, float max, int step, float defaultValue) {
        this.text = text;
        this.min = Math.max(min, 0.0F);
        this.max = Math.max(max, this.min);
        if ((float)step != 1 && step > 0) {
            this.step = step;
        }

        if (defaultValue != min) {
            this.defaultValue = defaultValue;
        }

    }

    public ElementSlider(String text, float min, float max, int step, float defaultValue,ExecuteFunction function) {
        this.text = text;
        this.min = Math.max(min, 0.0F);
        this.max = Math.max(max, this.min);
        if ((float)step != 1 && step > 0) {
            this.step = step;
        }

        if (defaultValue != min) {
            this.defaultValue = defaultValue;
        }

        this.function = function;

    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public float getMin() {
        return this.min;
    }

    public void setMin(float min) {
        this.min = min;
    }

    public float getMax() {
        return this.max;
    }

    public void setMax(float max) {
        this.max = max;
    }

    public int getStep() {
        return this.step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public float getDefaultValue() {
        return this.defaultValue;
    }

    public void setDefaultValue(float defaultValue) {
        this.defaultValue = defaultValue;
    }

    public void setFunction(ExecuteFunction function){
        this.function = function;
    }

    public void execute(Player player, FormResponse formResponse){
        this.function.dispose(player,formResponse);
    }

}
