package fr.intech.Java9.Object.Quest.controller;

public class Main {

    public static void main(String[] args) {
        ImageService service = new GoogleImageService();
        MonController controller = new MonController(service);
    }
}
