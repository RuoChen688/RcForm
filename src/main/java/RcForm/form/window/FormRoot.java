package RcForm.form.window;

import RcForm.form.response.FormResponse;
import cn.nukkit.form.handler.FormResponseHandler;
import com.google.gson.Gson;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;

import java.util.List;

public abstract class FormRoot{

    protected int formId = 10000;

    protected static final Gson GSON = new Gson();
    protected transient boolean closed = false;
    protected final transient List<FormResponseHandler> handlers = new ObjectArrayList();

    public FormRoot() {
    }

    public String getJSONData() {
        return GSON.toJson(this);
    }

    public abstract void setResponse(String var1);

    public abstract FormResponse getResponse();

    public boolean wasClosed() {
        return this.closed;
    }

    public void setClosed(boolean closed){
        this.closed = closed;
    }

    public void addHandler(FormResponseHandler handler) {
        this.handlers.add(handler);
    }

    public List<FormResponseHandler> getHandlers() {
        return this.handlers;
    }

    public int getFormId(){
        return this.formId;
    }

    public void setFormId(int formId){
        this.formId = formId;
    }

}
