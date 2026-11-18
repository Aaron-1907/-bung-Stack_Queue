import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Main extends JFrame {
Random random = new Random();
Queue<Integer> zufallsZahlen = new Queue();
Stack<Integer> stack = new Stack();


public Main(){
    super("Übung Stack und Queue");
    this.setSize(new Dimension(600, 600));
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    this.setVisible(true);
}

public void queueGenerieren(){
    for (int i = 0; i < 10; i++) {
        int temp = random.nextInt(100);
        zufallsZahlen.enqueue(temp);
    }

}

public void queueToStack(){
    while (!zufallsZahlen.isEmpty()) {
        int zahl = zufallsZahlen.front();
        stack.push(zahl);
        zufallsZahlen.dequeue();
    }
}

public void stackToQueue(){
    while (!stack.isEmpty()){
        int zahl = stack.top();
        zufallsZahlen.enqueue(zahl);
        stack.pop();
    }
}






    public static void main(String[] args) {
        new Main();
    }
}
