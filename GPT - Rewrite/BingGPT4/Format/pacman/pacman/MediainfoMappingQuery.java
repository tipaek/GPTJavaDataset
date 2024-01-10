package com.yeshj.pacman.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.object.MappingSqlQuery;
import com.yeshj.pacman.model.MediainfoModel;

public class MediainfoMappingQuery extends MappingSqlQuery<MediainfoModel> {

	@Override
	protected MediainfoModel mapRow(ResultSet rs, int row) throws SQLException {
		MediainfoModel mediainfo = new MediainfoModel();

		mediainfo.setTid(rs.getInt("tid"));
		mediainfo.setMedia(rs.getString("media"));
		mediainfo.setAudio_rate(rs.getInt("audio_rate"));
		mediainfo.setAudio_sampling(rs.getInt("audio_sampling"));
		mediainfo.setAudio_duration(rs.getInt("audio_duration"));
		mediainfo.setAudio_codec(rs.getString("audio_codec"));
		mediainfo.setVideo_width(rs.getInt("video_width"));
		mediainfo.setVideo_height(rs.getInt("video_height"));
		mediainfo.setVideo_rate(rs.getInt("video_rate"));
		mediainfo.setVideo_duration(rs.getInt("video_duration"));
		mediainfo.setVideo_codec(rs.getString("video_codec"));

		return mediainfo;
	}
}
