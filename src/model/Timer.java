package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Timer implements Runnable {
    private int minutes;
    private int seconds;
    static SimpleDateFormat sdf = new SimpleDateFormat("mm:ss");

    public Timer(String input) {
        if (input.contains(",")) {
            String[] split = input.split(",");
            if (split.length == 2) {
                setMinutes(split[0]);
                setSeconds(split[1]);
            } else {
                UI.finishLabel.setText("Invalid input!");
                throw new RuntimeException("Invalid input!");
            }
        } else {
            UI.finishLabel.setText("Invalid input!");
            throw new RuntimeException("Invalid input!");
        }
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(String minutes) {
        try {
            this.minutes = Integer.parseInt(minutes);
        } catch (NumberFormatException e) {
            UI.finishLabel.setText("Invalid input!");
            throw new RuntimeException("Invalid input!");
        }
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(String seconds) {
        try {
            this.seconds = Integer.parseInt(seconds);
        } catch (NumberFormatException e) {
            UI.finishLabel.setText("Invalid input!");
            throw new RuntimeException("Invalid input!");
        }
    }

    @Override
    public void run() {
        UI.finishLabel.setText("");
        UI.startButton.setEnabled(false);
        int time = 60 * minutes + seconds;
        for (int i = 0; i <= time; i++) {
            UI.timeLabel.setText(sdf.format(new Date((60L * minutes + seconds) * 1000)));
            if (seconds == 0) {
                seconds = 60;
                minutes--;
            }
            seconds--;
            if (i != time)
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
        UI.finishLabel.setText("Finished!");
        UI.startButton.setEnabled(true);
    }
}