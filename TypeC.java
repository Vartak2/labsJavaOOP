interface TypeCPort {
    void connectTypeC();
}

class Jack35Headphones {
    public void plugJack35() {
        System.out.println("Наушники подключены через jack 3.5 мм — играет музыка");
    }
}

class TypeCToJack35Adapter implements TypeCPort {
    private Jack35Headphones headphones;

    public TypeCToJack35Adapter(Jack35Headphones headphones) {
        this.headphones = headphones;
    }

    @Override
    public void connectTypeC() {
        System.out.println("Переходник: Type-C -> jack 3.5 мм");
        headphones.plugJack35();
    }
}

class Phone {
    private TypeCPort port;

    public Phone(TypeCPort port) {
        this.port = port;
    }

    public void playMusic() {
        port.connectTypeC();
    }
}

public class Main {
    public static void main(String[] args) {
        Jack35Headphones oldHeadphones = new Jack35Headphones();
        TypeCPort adapter = new TypeCToJack35Adapter(oldHeadphones);
        Phone phone = new Phone(adapter);
        phone.playMusic();
    }
}