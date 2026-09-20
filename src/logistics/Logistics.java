package logistics;

public abstract class Logistics {
    protected abstract Transport createTransport();


    public void planDelivery(String cargo, String destination){
        Transport transport = createTransport();
        transport.deliver(cargo, destination);
    }

}
