package Modules.Event;

abstract class Event {
    private boolean textField;
    private boolean button;
    private String moduleTitle;
    private String hint1;
    private String hint2;
    private String hint3;
    private String hint4;

    public abstract boolean checkEvent();

    public void setTextField(boolean textField) {
        this.textField = textField;
    }
    public void setButton(boolean button) {
        this.button = button;
    }
    public void setModuleTitle(String moduleTitle) {
        this.moduleTitle = moduleTitle;
    }
    public void setHint1(String hint1) {
        this.hint1 = hint1;
    }
    public void setHint2(String hint2) {
        this.hint2 = hint2;
    }
    public void setHint3(String hint3) {
        this.hint3 = hint3;
    }
    public void setHint4(String hint4) {
        this.hint4 = hint4;
    }

    public boolean getTextField() {
        return this.textField;
    }
    public boolean getButton() {
        return this.button;
    }
    public String getModuleTitle() {
        return this.moduleTitle;
    }
    public String getHint1() {
        return this.hint1;
    }
    public String getHint2() {
        return this.hint2;
    }
    public String getHint3() {
        return this.hint3;
    }
    public String getHint4() {
        return this.hint4;
    }


}
