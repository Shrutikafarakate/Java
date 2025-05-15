import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Stopwatch extends JFrame implements ActionListener {
    private JLabel timeLabel;
    private JButton startButton, stopButton, resetButton;

    private int hours = 0, minutes = 0, seconds = 0;
    private boolean running = false;
    private Thread timerThread;

    public Stopwatch() {
        setTitle("Stopwatch");
        setSize(300, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        timeLabel = new JLabel(formatTime(hours, minutes, seconds), SwingConstants.CENTER);
        timeLabel.setFont(new Font("Verdana", Font.BOLD, 30));
        add(timeLabel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        startButton = new JButton("Start");
        stopButton  = new JButton("Stop");
        resetButton = new JButton("Reset");

        buttonPanel.add(startButton);
        buttonPanel.add(stopButton);
        buttonPanel.add(resetButton);
        add(buttonPanel, BorderLayout.SOUTH);

        startButton.addActionListener(this);
        stopButton.addActionListener(this);
        resetButton.addActionListener(this);
    }

    private String formatTime(int h, int m, int s) {
        return String.format("%02d:%02d:%02d", h, m, s);
    }

    private void startStopwatch() {
        if (running) return;

        running = true;

        timerThread = new Thread(() -> {
            while (running) {
                try {
                    Thread.sleep(1000);
                    seconds++;

                    if (seconds == 60) {
                        seconds = 0;
                        minutes++;
                    }

                    if (minutes == 60) {
                        minutes = 0;
                        hours++;
                    }

                    timeLabel.setText(formatTime(hours, minutes, seconds));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        timerThread.start();
    }

    private void stopStopwatch() {
        running = false;
    }

    private void resetStopwatch() {
        running = false;
        hours = minutes = seconds = 0;
        timeLabel.setText(formatTime(hours, minutes, seconds));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == startButton) {
            startStopwatch();
        } else if (src == stopButton) {
            stopStopwatch();
        } else if (src == resetButton) {
            resetStopwatch();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Stopwatch stopwatch = new Stopwatch();
            stopwatch.setVisible(true);
        });
    }
}
