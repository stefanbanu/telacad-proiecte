package client;

import client.controller.ClientController;

public class Client {

    public static void main(String[] args) {
        ClientController.getInstance().addProduct("bere2");
        ClientController.getInstance().deleteProduct("bere");
    }
    
}
