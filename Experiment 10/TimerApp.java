import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimerApp {
    private JFrame frame;
    private JLabel timeLabel;
    private JButton startButton, stopButton;
    private Timer timer;
    private int seconds;

    public TimerApp() {
        frame = new JFrame("Timer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new FlowLayout());

        seconds = 0;

        timeLabel = new JLabel("00:00", SwingConstants.CENTER);
        timeLabel.setFont(new Font("Serif", Font.PLAIN, 30));
        frame.add(timeLabel);

        startButton = new JButton("Start");
        startButton.setFont(new Font("Serif", Font.PLAIN, 14));
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startTimer();
            }
        });
        frame.add(startButton);

        stopButton = new JButton("Stop");
        stopButton.setFont(new Font("Serif", Font.PLAIN, 14));
        stopButton.setEnabled(false);
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stopTimer();
            }
        });
        frame.add(stopButton);

        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seconds++;
                int minutes = seconds / 60;
                int secs = seconds % 60;
                timeLabel.setText(String.format("%02d:%02d", minutes, secs));
            }
        });

        frame.setVisible(true);
    }

    private void startTimer() {
        timer.start();
        startButton.setEnabled(false);
        stopButton.setEnabled(true);
    }

    private void stopTimer() {
        timer.stop();
        startButton.setEnabled(true);
        stopButton.setEnabled(false);
    }

    public static void main(String[] args) {
        new TimerApp();
    }
}
