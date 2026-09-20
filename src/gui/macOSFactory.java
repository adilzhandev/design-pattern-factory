package gui;

public class macOSFactory implements GUIFactory{

    @Override
    public Button createButton() {
        return new MacOSButton();

    }

    @Override
    public Checkbox createCheckbox() {
        return new MacOSCheckbox();
    }
}
