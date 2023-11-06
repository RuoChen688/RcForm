package RcForm.form.window;

import RcForm.form.element.ElementButton;
import RcForm.form.response.FormResponse;
import RcForm.form.response.FormResponseSimple;

import java.util.ArrayList;
import java.util.List;

public class FormSimple extends FormRoot{
    private final String type = "form";
    private String title;
    private String content;
    private List<ElementButton> buttons;
    private FormResponseSimple response;

    public FormSimple(String title) {
        this(title, "");
    }

    public FormSimple(String title, String content) {
        this(title, content, new ArrayList());
    }

    public FormSimple(String title, String content, List<ElementButton> buttons) {
        this.response = null;
        this.title = title;
        this.content = content;
        this.buttons = buttons;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<ElementButton> getButtons() {
        return this.buttons;
    }

    public void addButton(ElementButton button) {
        this.buttons.add(button);
    }

    public void setButton(List<ElementButton> buttons){ this.buttons = buttons; }

    public FormResponseSimple getResponse() {
        return this.response;
    }

    public void setResponse(String data) {
        if (data.equals("null")) {
            this.closed = true;
        } else {
            int buttonID;
            try {
                buttonID = Integer.parseInt(data);
            } catch (Exception var4) {
                return;
            }

            if (buttonID >= this.buttons.size()) {
                this.response = new FormResponseSimple(buttonID, null);
            } else {
                this.response = new FormResponseSimple(buttonID, this.buttons.get(buttonID));
            }
        }
    }
}
