// Main.java
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        ToyQueue toyQueue = new ToyQueue();

        // Добавим игрушки в очередь
        toyQueue.addToQueue(new Toy(1, "конструктор", 2));
        toyQueue.addToQueue(new Toy(2, "робот", 2));
        toyQueue.addToQueue(new Toy(3, "кукла", 6));

        // Вызовем Get 10 раз и запишем результат в файл
        try (FileWriter writer = new FileWriter("output.txt")) {
            for (int i = 0; i < 10; i++) {
                int toyId = toyQueue.getToy();
                writer.write("Get result: " + toyId + " - " + getToyNameById(toyId) + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getToyNameById(int toyId) {
        switch (toyId) {
            case 1:
                return "конструктор";
            case 2:
                return "робот";
            case 3:
                return "кукла";
            default:
                return "Неизвестная игрушка";
        }
    }
}
