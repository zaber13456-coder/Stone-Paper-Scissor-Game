import javax.swing.*;
import java.util.Random;
import java.awt.*;

public class Game {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("Rock Paper Scissor Game");
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        JLabel label = new JLabel("Choose one", SwingConstants.CENTER);
        JButton stone = new JButton("Stone");
        JButton paper = new JButton("Paper");
        JButton scissor = new JButton("Scissor");
        panel.add(stone);
        panel.add(paper);
        panel.add(scissor);
        frame.add(panel, BorderLayout.SOUTH);
        frame.add(label, BorderLayout.CENTER);

        Random random = new Random();
        stone.addActionListener(e -> play("Stone", label, random));
        paper.addActionListener(e -> play("Paper", label, random));
        scissor.addActionListener(e -> play("Scissor", label, random));
        frame.setVisible(true);
    }

    public static void play(String user, JLabel label, Random random) {
        String[] choice = { "Stone", "Paper", "Scissor" };
        String cpu = choice[random.nextInt(3)];
        String result = "";

        if (user.equals(cpu))
            result = "Draw";

        else if ((user.equals("Scissor")) && (cpu.equals("Paper")) || (user.equals("Paper")) && (cpu.equals("Stone"))
                || (user.equals("Stone")) && (cpu.equals("Sscissor")))
            result = "You win!";
        else
            result = "You lost";

        label.setText("<html>You chose: " + user + "<br>CPU chose: " + cpu + "<br> Result: " + result + "<html>");
    }
}