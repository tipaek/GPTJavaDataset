package chap11;
import javax.sound.midi.*;

public class MiniMiniMusicCmdLine {
    public static void main(String[] args) {
        MiniMiniMusicCmdLine mini = new MiniMiniMusicCmdLine();
        if (args.length < 2) {
            System.out.println("Don't forget the instrument and note args");
        } else {
            int instrument = Integer.parseInt(args[0]);
            int note = Integer.parseInt(args[1]);
            mini.play(instrument, note);
        }
    }

    public void play(int instrument, int note) {
        try {
            Sequencer player = MidiSystem.getSequencer();
            player.open();

            Sequence seq = new Sequence(Sequence.PPQ, 4);
            Track track = seq.createTrack();

            MidiEvent event = null;

            // Change instrument event
            ShortMessage first = new ShortMessage();
            first.setMessage(192, 1, instrument, 0);
            MidiEvent changeInstrument = new MidiEvent(first, 1);
            track.add(changeInstrument);

            // Note On event
            ShortMessage a = new ShortMessage();
            a.setMessage(144, 1, note, 100);
            MidiEvent noteOn = new MidiEvent(a, 1);
            track.add(noteOn);

            // Note Off event
            ShortMessage b = new ShortMessage();
            b.setMessage(128, 1, note, 100);
            MidiEvent noteOff = new MidiEvent(b, 16);
            track.add(noteOff);

            // Set the sequence and start playing
            player.setSequence(seq);
            player.start();

            // Sleep for a while to allow the sequencer to play
            Thread.sleep(5000);

            // Close the sequencer and exit
            player.close();
            System.exit(0);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    } // close play
} // close class
