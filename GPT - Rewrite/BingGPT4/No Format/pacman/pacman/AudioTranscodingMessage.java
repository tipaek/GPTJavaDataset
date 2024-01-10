package com.yeshj.pacman.jms.message;

import com.yeshj.pacman.annotation.Transmit;

public class AudioTranscodingMessage extends BaseMessage {

    @Transmit(key = "aubr")
    protected int audioBitRate;

    @Transmit(key = "ausamr")
    protected int audioSamplingRate;

    @Transmit(key = "audur")
    protected int audioDuration;

    @Transmit(key = "acodec")
    protected String audioCodec;

    @Transmit(key = "media")
    protected String mediaFile;

    @Transmit(key = "cid")
    protected int classId;

    @Transmit(key = "lid")
    protected int lessonId;

    @Transmit(key = "guid")
    protected String guid;

    public String getMediaFile() {
        return mediaFile;
    }

    public void setMediaFile(String mediaFile) {
        this.mediaFile = mediaFile;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public int getLessonId() {
        return lessonId;
    }

    public void setLessonId(int lessonId) {
        this.lessonId = lessonId;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getAudioCodec() {
        return audioCodec;
    }

    public void setAudioCodec(String audioCodec) {
        this.audioCodec = audioCodec;
    }

    public int getAudioBitRate() {
        return audioBitRate;
    }

    public void setAudioBitRate(int audioBitRate) {
        this.audioBitRate = audioBitRate;
    }

    public int getAudioSamplingRate() {
        return audioSamplingRate;
    }

    public void setAudioSamplingRate(int audioSamplingRate) {
        this.audioSamplingRate = audioSamplingRate;
    }

    public int getAudioDuration() {
        return audioDuration;
    }

    public void setAudioDuration(int audioDuration) {
        this.audioDuration = audioDuration;
    }
}
