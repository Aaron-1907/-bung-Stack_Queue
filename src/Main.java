import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;

public class Main extends JFrame {
    Random random = new Random();
    Queue<Integer> zufallsZahlen = new Queue();
    Stack<Integer> stack = new Stack();
    JPanel north;
    JPanel south;
    JButton generieren, unkehren, zuruecksetzen;
    JTextField generierteZahlen, umgekehrteZahlen;


    public Main() {
        super("Übung Stack und Queue");
        this.setSize(new Dimension(600, 130));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        north = new JPanel(new FlowLayout());
        south = new JPanel(new FlowLayout());
        Container cp = this.getContentPane();
        cp.add(north, BorderLayout.NORTH);
        cp.add(south, BorderLayout.SOUTH);
        generieren = new JButton("Zahlen generieren");
        unkehren = new JButton("Reihenfolge umgehren");
        zuruecksetzen = new JButton("Zurücksetzen");
        north.add(generieren);
        north.add(unkehren);
        north.add(zuruecksetzen);
        generieren.addActionListener(this::buttonKlick);
        unkehren.addActionListener(this::buttonKlick);
        zuruecksetzen.addActionListener(this::buttonKlick);
        generierteZahlen = new JTextField();
        umgekehrteZahlen = new JTextField();
        generierteZahlen.setBorder(BorderFactory.createTitledBorder("Generierte Zahlen"));
        umgekehrteZahlen.setBorder(BorderFactory.createTitledBorder("Umgekehrte Zahlen"));
        generierteZahlen.setPreferredSize(new Dimension(200, 40));
        umgekehrteZahlen.setPreferredSize(new Dimension(200, 40));
        south.add(generierteZahlen);
        south.add(umgekehrteZahlen);
        this.setVisible(true);
    }

    private void buttonKlick(ActionEvent actionEvent) {
        JButton quelle = (JButton) actionEvent.getSource();
        switch (quelle.getText()) {
            case "Zahlen generieren":
                queueGenerieren();
                break;
            case "Reihenfolge umgehren":
                queueToStack();
                stackToQueue();
                break;
            case "Zurücksetzen":
                zufallsZahlen = new Queue();
                stack = new Stack();
                generierteZahlen.setText("");
                umgekehrteZahlen.setText("");
                break;
        }


    }

    public void queueGenerieren() {
        zufallsZahlen = new Queue();
        String ausgabe = "";
        for (int i = 0; i < 10; i++) {
            int temp = random.nextInt(100);
            zufallsZahlen.enqueue(temp);
            ausgabe = ausgabe + temp + " ";
        }
        generierteZahlen.setText(ausgabe);
    }

    public void queueToStack() {
        while (!zufallsZahlen.isEmpty()) {
            int zahl = zufallsZahlen.front();
            stack.push(zahl);
            zufallsZahlen.dequeue();
        }
    }

    public void stackToQueue() {
        String ausgabe = "";
        while (!stack.isEmpty()) {
            int zahl = stack.top();
            zufallsZahlen.enqueue(zahl);
            stack.pop();
            ausgabe = ausgabe + zahl + " ";
        }
        umgekehrteZahlen.setText(ausgabe);
    }


    public static void main(String[] args) {
        new Main();
    }
}
