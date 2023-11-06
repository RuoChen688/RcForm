package RcForm.form.element;

import RcForm.form.ExecuteFunction;
import RcForm.form.response.FormResponse;
import cn.nukkit.Player;

public class ElementButton extends Element{

    private String text = "";
    private ElementButtonImageData image;
    private ExecuteFunction function;

    public ElementButton(String text) {
        this.text = text;
    }

    public ElementButton(String text, ElementButtonImageData image) {
        this.text = text;
        if (!image.getData().isEmpty() && !image.getType().isEmpty()) {
            this.image = image;
        }

    }

    public ElementButton(String text, ElementButtonImageData image, ExecuteFunction function) {
        this.text = text;
        if (!image.getData().isEmpty() && !image.getType().isEmpty()) {
            this.image = image;
        }
        this.function = function;

    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ElementButtonImageData getImage() {
        return this.image;
    }

    public void setImage(ElementButtonImageData image) {
        if (!image.getData().isEmpty() && !image.getType().isEmpty()) {
            this.image = image;
        }

    }

    public void setFunction(ExecuteFunction function) {
        this.function = function;
    }

    public void execute(Player player, FormResponse response){
        this.function.dispose(player,response);
    }
}
