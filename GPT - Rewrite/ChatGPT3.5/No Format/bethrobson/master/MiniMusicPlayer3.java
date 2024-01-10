package chap12;

import javax.sound.midi.*;
import javax.swing.*;
import java.awt.*;

public class MiniMusicPlayer3 {

    static JFrame frame = new JFrame("My First Music Video");
    static MyDrawPanel drawPanel;

    public static void main(String[] args) {
        MiniMusicPlayer3 mini = new MiniMusicPlayer3();
        mini.go();
    }

    public void setUpGui() {
        drawPanel = new MyDrawPanel();
        frame.setContentPane(drawPanel);
        frame.setBounds(30, 30, 300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void go() {
        setUpGui();

        try {
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();

            sequencer.addControllerEventListener(drawPanel, new int[]{127});
            Sequence sequence = new Sequence(Sequence.PPQ, 4);
            Track track = sequence.createTrack();

            int random = 0;
            for (int i = 0; i < 60; i += 4) {
                random = (int) ((Math.random() * 50) + 1);

                track.add(makeEvent(144, 1, random, 100, i));
                track.add(makeEvent(176, 1, 127, 0, i));
                track.add(makeEvent(128, 1, random, 100, i + 2));
            }

            sequencer.setSequence(sequence);
            sequencer.start();
            sequencer.setTempoInBPM(120);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public MidiEvent makeEvent(int command, int channel, int one, int two, int tick) {
        MidiEvent event = null;
        try {
            ShortMessage message = new ShortMessage();
            message.setMessage(command, channel, one, two);
            event = new MidiEvent(message, tick);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return event;
    }

    static class MyDrawPanel extends JPanel implements ControllerEventListener {
        boolean msg = false;

        @Override
        public void controlChange(ShortMessage event) {
            msg = true;
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            if (msg) {
                Graphics2D g2 = (Graphics2D) g;

                int r = (int) (Math.random() * 250);
                int gr = (int) (Math.random() * 250);
                int b = (int) (Math.random() * 250);

                g.setColor(new Color(r, gr, b));

                int ht = (int) ((Math.random() * 120) + 10);
                int width = (int) ((Math.random() * 120) + 10);

                int x = (int) ((Math.random() * 40) + 10);
                int y = (int) ((Math.random() * 40) + 10);

                g.fillRect(x, y, ht, width);
                msg = false;
            }
        }
    }
}
