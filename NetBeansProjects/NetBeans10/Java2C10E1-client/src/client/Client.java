package client;

public class Client {

    public static void main(String[] args) {
        ClientController.getInstance().sendMessage("Mesaj 1");
        ClientController.getInstance().sendMessage("Mesaj 2");
        ClientController.getInstance().sendMessage("Mesaj 3");
        ClientController.getInstance().sendMessage("Mesaj 4");
        ClientController.getInstance().sendMessage("Mesaj 5");
    }
    
}
