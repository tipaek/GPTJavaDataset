package com.yeshj.pacman.jms.impl;

import com.yeshj.pacman.jms.IMessageBuilder;
import com.yeshj.pacman.jms.message.AudioTranscodingMessage;
import com.yeshj.pacman.jms.message.BaseMessage;
import com.yeshj.pacman.jms.message.FeedbackMessage;
import com.yeshj.pacman.jms.message.VideoTranscodingMessage;
import com.yeshj.pacman.utils.IdGenerator;

public class DefaultMessageBuilder implements IMessageBuilder {

    @Override
    public BaseMessage buildAudioTaskMessage(int taskId, int classId, int lessonId, int type, String guid, String codec, int bitrate, int sample, int duration, String media) {
        AudioTranscodingMessage message = new AudioTranscodingMessage();
        message.setClassId(classId);
        message.setLessonId(lessonId);
        message.setAudioBitRate(bitrate);
        message.setAudioSamplingRate(sample);
        message.setAudioDuration(duration);
        message.setCommandId(taskId);
        message.setAudioCodec(codec);
        message.setMediaFile(media);
        message.setGuid(guid);
        message.setCommandType(type);
        return message;
    }

    @Override
    public BaseMessage buildVideoTaskMessage(int taskId, int classId, int lessonId, int type, String guid, String acodec, String vcodec, int audioBitrate, int audioSample, int videoBitrate, int videoWidth, int videoHeight, int duration, String media) {
        VideoTranscodingMessage message = new VideoTranscodingMessage();
        message.setCommandId(taskId);
        message.setClassId(classId);
        message.setLessonId(lessonId);
        message.setAudioBitRate(audioBitrate);
        message.setAudioSamplingRate(audioSample);
        message.setVideoBitRate(videoBitrate);
        message.setVideoWidth(videoWidth);
        message.setVideoHeight(videoHeight);
        message.setAudioCodec(acodec);
        message.setVideoCodec(vcodec);
        message.setMediaFile(media);
        message.setGuid(guid);
        message.setCommandType(type);
        return message;
    }

    @Override
    public BaseMessage buildFeedbackMessage(int cmdId, boolean success, String msg) {
        FeedbackMessage message = new FeedbackMessage();
        message.setCommandId(cmdId);
        message.setSuccess(success);
        message.setMsg(msg);
        return message;
    }

    @Override
    public BaseMessage buildCommandMessage(String msg) {
        FeedbackMessage message = new FeedbackMessage();
        message.setCommandId(IdGenerator.nextInt());
        message.setMsg(msg);
        return message;
    }

    @Override
    public BaseMessage buildHeartbeatMessage() {
        FeedbackMessage message = new FeedbackMessage();
        message.setCommandId(IdGenerator.nextInt());
        return message;
    }
}
