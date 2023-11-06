package RcForm.form.window;

import RcForm.form.element.*;
import RcForm.form.response.FormResponse;
import RcForm.form.response.FormResponseCustom;
import RcForm.form.response.FormResponseData;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class FormCustom extends FormRoot{

    private final String type = "custom_form";
    private String title;
    private ElementButtonImageData icon;
    private List<Element> content;
    private FormResponseCustom response;

    public FormCustom(String title) {
        this(title, new ArrayList());
    }

    public FormCustom(String title, List<Element> contents) {
        this(title, contents, (ElementButtonImageData)null);
    }

    public FormCustom(String title, List<Element> contents, String icon) {
        this(title, contents, icon.isEmpty() ? null : new ElementButtonImageData("url", icon));
    }

    public FormCustom(String title, List<Element> contents, ElementButtonImageData icon) {
        this.title = title;
        this.content = contents;
        this.icon = icon;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Element> getElements() {
        return this.content;
    }

    public void addElement(Element element) {
        this.content.add(element);
    }

    public void setElement(List<Element> content){ this.content = content; }

    public ElementButtonImageData getIcon() {
        return this.icon;
    }

    public void setIcon(String icon) {
        if (!icon.isEmpty()) {
            this.icon = new ElementButtonImageData("url", icon);
        }

    }

    public void setIcon(ElementButtonImageData icon) {
        this.icon = icon;
    }

    public FormResponseCustom getResponse() {
        return this.response;
    }

    public void setResponse(String data) {
        if (data.equals("null")) {
            this.closed = true;
        } else {
            List<String> elementResponses = GSON.fromJson(data, (new TypeToken<List<String>>() {}).getType());
            int i = 0;
            HashMap<Integer, FormResponseData> dropdownResponses = new HashMap();
            HashMap<Integer, String> inputResponses = new HashMap();
            HashMap<Integer, Float> sliderResponses = new HashMap();
            HashMap<Integer, FormResponseData> stepSliderResponses = new HashMap();
            HashMap<Integer, Boolean> toggleResponses = new HashMap();
            HashMap<Integer, Object> responses = new HashMap();
            HashMap<Integer, String> labelResponses = new HashMap();

            for(Iterator var11 = elementResponses.iterator(); var11.hasNext(); ++i) {
                String elementData = (String)var11.next();
                if (i >= this.content.size()) {
                    break;
                }

                Element e = this.content.get(i);
                if (e == null) {
                    break;
                }

                if (e instanceof ElementLabel) {
                    labelResponses.put(i, ((ElementLabel)e).getText());
                    responses.put(i, ((ElementLabel)e).getText());
                } else {
                    if (e instanceof ElementDropdown) {
                        String answer = ((ElementDropdown)e).getOptions().get(Integer.parseInt(elementData));
                        FormResponseData formResponseData = new FormResponseData(Integer.parseInt(elementData), answer);
                        dropdownResponses.put(i, formResponseData);
                        responses.put(i, formResponseData);
                    } else if (e instanceof ElementInput) {
                        inputResponses.put(i, elementData);
                        responses.put(i, elementData);
                    } else if (e instanceof ElementSlider) {
                        Float answer = Float.parseFloat(elementData);
                        sliderResponses.put(i, answer);
                        responses.put(i, answer);
                    } else if (e instanceof ElementStepSlider) {
                        String answer = ((ElementStepSlider)e).getSteps().get(Integer.parseInt(elementData));
                        FormResponseData formResponseData = new FormResponseData(Integer.parseInt(elementData), answer);
                        stepSliderResponses.put(i, formResponseData);
                        responses.put(i, formResponseData);
                    } else if (e instanceof ElementToggle) {
                        Boolean answer = Boolean.parseBoolean(elementData);
                        toggleResponses.put(i, answer);
                        responses.put(i, answer);
                    }
                }
            }

            this.response = new FormResponseCustom(responses, dropdownResponses, inputResponses, sliderResponses, stepSliderResponses, toggleResponses, labelResponses);
        }
    }

    public void setElementsFromResponse() {
        if (this.response != null) {
            this.response.getResponses().forEach((i, response) -> {
                Element e = this.content.get(i);
                if (e != null) {
                    if (e instanceof ElementDropdown) {
                        ((ElementDropdown)e).setDefaultOptionIndex(((ElementDropdown)e).getOptions().indexOf(response));
                    } else if (e instanceof ElementInput) {
                        ((ElementInput)e).setDefaultText((String)response);
                    } else if (e instanceof ElementSlider) {
                        ((ElementSlider)e).setDefaultValue((Float)response);
                    } else if (e instanceof ElementStepSlider) {
                        ((ElementStepSlider)e).setDefaultOptionIndex(((ElementStepSlider)e).getSteps().indexOf(response));
                    } else if (e instanceof ElementToggle) {
                        ((ElementToggle)e).setDefaultValue((Boolean)response);
                    }
                }

            });
        }

    }

}
