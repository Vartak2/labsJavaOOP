public class Main {
	public static void main(String[] args) {
		new NewThread();
		
		try {
		    for (int i = 0; i < 5; i++) {
		        System.out.println("Главный поток: " + i);
		        Thread.sleep(1000);
		    }
		} catch (InterruptedException e) {
		    System.out.println("Главный поток прерван!");
		}
		System.out.println("Главный поток завершен!");
	}
}

class NewThread extends Thread {
    NewThread() {
        super("Дочерний поток");
        System.out.println("Дочерний поток "+ this);
        start();
    }
    
    public void run() {
        try{
            for (int i = 0; i< 5;i++) {
                System.out.println("Дочерний поток "+ i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("Дочерний поток прерван!");
        }
        System.out.println("Дочерний поток завершен!");
    }
}