package app;
import gui.GUIFactory;
import gui.Button;
import gui.Checkbox;
import logistics.Logistics;

public class DeliveryApplication {

    private final GUIFactory guiFactory;
    private final Logistics logistics;

    public DeliveryApplication(GUIFactory guiFactory,Logistics logistics){
        this.guiFactory = guiFactory;
        this.logistics = logistics;
    }

    public void run(String cargo, String destination){
        Button button = guiFactory.createButton();
        Checkbox checkbox = guiFactory.createCheckbox();

        button.paint();
        checkbox.paint();

        logistics.planDelivery(cargo, destination);
    }
}
