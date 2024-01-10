package chap11;
import javax.sound.midi.*;

public class MiniMiniMusicApp {
    public static void main(String[] args) {
        MiniMiniMusicApp mini = new MiniMiniMusicApp();
        mini.play();
    }

    public void play() {
        try {
            // Make (and open) a sequencer, make a sequence and track
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();

            Sequence seq = new Sequence(Sequence.PPQ, 4);
            Track track = seq.createTrack();

            // Now make two midi events (containing a midi message)
            MidiEvent event = null;

            // First, make the message
            // Then, stick the message into a midi event
            // Finally, add the event to the track

            ShortMessage a = new ShortMessage();
            a.setMessage(144, 1, 44, 100); // Note On message (channel 1, note 44, velocity 100)
            MidiEvent noteOn = new MidiEvent(a, 1); // At tick 1, the above Note On event happens
            track.add(noteOn);

            ShortMessage b = new ShortMessage();
            b.setMessage(128, 1, 44, 100); // Note Off message (channel 1, note 44, velocity 100)
            MidiEvent noteOff = new MidiEvent(b, 16); // At tick 16, the above Note Off event happens
            track.add(noteOff);

            // Add the events to the track

            // Add the sequence to the sequencer, set timing, and start
            sequencer.setSequence(seq);
            sequencer.start();

            // Sleep for a while to allow the sequencer to play
            Thread.sleep(1000);

            // Close the sequencer and exit
            sequencer.close();
            System.exit(0);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    } // close play
} // close class
