package RcForm.form.response;

import RcForm.form.element.ElementButton;

public class FormResponseSimple extends FormResponse{

    private final int clickedButtonId;
    private final ElementButton clickedButton;

    public FormResponseSimple(int clickedButtonId, ElementButton clickedButton) {
        this.clickedButtonId = clickedButtonId;
        this.clickedButton = clickedButton;
    }

    public int getClickedButtonId() {
        return this.clickedButtonId;
    }

    public ElementButton getClickedButton() {
        return this.clickedButton;
    }

}
