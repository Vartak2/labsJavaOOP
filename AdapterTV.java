interface Device {
    void turnOn();
}

class TV implements Device {
    @Override
    public void turnOn() {
        System.out.println("Телевизор показывает картинку");
    }
}

class Radio implements Device {
    @Override
    public void turnOn() {
        System.out.println("Радио играет музыку");
    }
}

abstract class RemoteControl {
    protected Device device;

    public RemoteControl(Device device) {
        this.device = device;
    }

    public void pressPowerButton() {
        System.out.println("Пульт нажимает кнопку...");
        this.device.turnOn();
    }
}

class BasicRemote extends RemoteControl {
    public BasicRemote(Device device) {
        super(device);
    }

    @Override
    public void pressPowerButton() {
        System.out.println("Базовый пульт: Включение...");
        super.pressPowerButton();
    }
}

class SmartRemote extends RemoteControl {
    public SmartRemote(Device device) {
        super(device);
    }

    @Override
    public void pressPowerButton() {
        System.out.println("Умный пульт (с голосовым управлением): Включение...");
        super.pressPowerButton();
    }
}

public class Main {
    public static void main(String[] args) {

        Device myTv = new TV();
        Device myRadio = new Radio();
        RemoteControl basicForTv = new BasicRemote(myTv);
        RemoteControl smartForRadio = new SmartRemote(myRadio);
        RemoteControl smartForTv = new SmartRemote(myTv);

        System.out.println("--- Включаем ТВ базовым пультом ---");
        basicForTv.pressPowerButton();

        System.out.println("\n--- Включаем Радио умным пультом ---");
        smartForRadio.pressPowerButton();

        System.out.println("\n--- Базовый пульт сломался! Берем умный пульт для ТВ ---");
        smartForTv.pressPowerButton();
    }
}