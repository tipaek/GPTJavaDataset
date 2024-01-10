package com.yeshj.pacman.utils;

import com.yeshj.pacman.config.AppConfig;
import org.apache.commons.lang3.StringUtils;

public final class ExternalTool {

    private static final String FFMPEG_TOOL = "/usr/bin/trans.sh";
    private static final String PYTHON_TOOL = AppConfig.getInstance().getExtool_python();
    private static final String PY_SCRIPT_PATH = AppConfig.getInstance().getExtool_flvslicer();

    public static String buildAudioCommand(String acodec, int bitrate, int sampling, int duration, String audioSrc, String outputFile) throws InvalidMediaParameterException {
        if (StringUtils.isEmpty(acodec)) {
            throw new InvalidMediaParameterException("Empty audio codec.");
        }

        if (bitrate < 1) {
            throw new InvalidMediaParameterException("Invalid audio bitrate.[" + bitrate + "]");
        }

        if (sampling < 11025) {
            throw new InvalidMediaParameterException("Audio sampling rate too low.[" + sampling + "]");
        }

        if (duration < 5) {
            throw new InvalidMediaParameterException("Too short audio, are you sure?[" + duration + "]");
        }

        if (!FileHelper.exists(audioSrc)) {
            throw new InvalidMediaParameterException("Audio doesn't exist![" + audioSrc + "]");
        }

        ShellCommand cmd = ShellCommand.create(FFMPEG_TOOL);

        if ("aac".equalsIgnoreCase(acodec) || "mpeg audio".equalsIgnoreCase(acodec)) {
            if (sampling == 44100 || sampling == 22050 || sampling == 11025) {
                cmd.add("-acopy");
            } else {
                cmd.add("-m44");
            }
        } else {
            cmd.add("-aac");
        }

        cmd.add(audioSrc)
           .add(outputFile);

        return cmd.toString();
    }

    public static String buildVideoCommand(String vcodec, String acodec, int bitrate_v, int bitrate_a, int sampling, String videoSrc, String outputFile) throws InvalidMediaParameterException {
        if (bitrate_v < 1) {
            throw new InvalidMediaParameterException("Invalid video bitrate.[" + bitrate_v + "]");
        }

        if (bitrate_a < 1) {
            throw new InvalidMediaParameterException("Invalid audio bitrate.[" + bitrate_a + "]");
        }

        ShellCommand cmd = ShellCommand.create(FFMPEG_TOOL);
        if ("aac".equalsIgnoreCase(acodec) || "mpeg audio".equalsIgnoreCase(acodec)) {
            if (sampling == 44100 || sampling == 22050 || sampling == 11025) {
                cmd.add("-acopy");
            } else {
                cmd.add("-m44");
            }
        } else {
            cmd.add("-aac");
        }

        if ("avc".equalsIgnoreCase(vcodec) && bitrate_v < 600) {
            cmd.add("-vcopy")
               .add("-g4x3");
        } else {
            cmd.add("-x264")
               .add("-q5")
               .add("-g4x3");
        }

        cmd.add(videoSrc)
           .add(outputFile);

        return cmd.toString();
    }

    // The rest of the code goes here...
}
