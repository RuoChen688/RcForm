package RcForm.form.window;

import RcForm.form.element.ElementButton;
import RcForm.form.response.FormResponse;
import RcForm.form.response.FormResponseModal;

public class FormModal extends FormRoot{

    private final String type = "modal";
    private String title = "";
    private String content = "";

    private ElementButton elementButton1;

    private ElementButton elementButton2;
    private String button1;
    private String button2;
    private FormResponseModal response = null;

    public FormModal(String title){
        this(title,"");
    }

    public FormModal(String title,String content){
        this(title,content,new ElementButton("确认"),new ElementButton("取消"));
    }

    public FormModal(String title, String content, ElementButton button1, ElementButton button2) {
        this.title = title;
        this.content = content;
        this.button1 = button1.getText();
        this.elementButton1 = button1;
        this.button2 = button2.getText();
        this.elementButton2 = button2;
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

    public String getButton1() {
        return this.button1;
    }

    public void setButton1(ElementButton button1) {
        this.button1 = button1.getText();
        this.elementButton1 = button1;
    }

    public String getButton2() {
        return this.button2;
    }

    public void setButton2(ElementButton button2) {
        this.button2 = button2.getText();
        this.elementButton2 = button2;
    }

    public FormResponseModal getResponse() {
        return this.response;
    }

    public void setResponse(String data) {
        if (data.equals("null")) {
            this.closed = true;
        } else {
            if (data.equals("true")) {
                this.response = new FormResponseModal(0, this.elementButton1);
            } else {
                this.response = new FormResponseModal(1, this.elementButton2);
            }

        }
    }

}
