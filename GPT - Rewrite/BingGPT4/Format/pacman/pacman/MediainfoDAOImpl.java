package com.yeshj.pacman.dao.impl;

import java.sql.Types;
import javax.sql.DataSource;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.object.SqlUpdate;
import com.yeshj.pacman.dao.IMediainfoDAO;
import com.yeshj.pacman.model.MediainfoModel;

public class MediainfoDAOImpl extends JdbcDaoSupport implements IMediainfoDAO {

	private MiAddAction addAction;
	private MiSaveAction saveAction;

	private class MiAddAction extends SqlUpdate {

		private static final String INSERT_SQL = "INSERT INTO mediainfo (" +
				"tid, media, audio_rate, audio_sampling, audio_duration, audio_codec, " +
				"video_width, video_height, video_rate, video_duration, video_codec)" +
				"VALUES(?, ?, ?, ?, ?, ?,  ?, ?, ?, ?, ?)";

		public MiAddAction(DataSource ds) {
			setDataSource(ds);
			setSql(INSERT_SQL);
			declareParameters();
			compile();
		}

		private void declareParameters() {
			declareParameter(new SqlParameter(Types.INTEGER));
			declareParameter(new SqlParameter(Types.VARCHAR));
			declareParameter(new SqlParameter(Types.INTEGER));
			declareParameter(new SqlParameter(Types.INTEGER));
			declareParameter(new SqlParameter(Types.INTEGER));
			declareParameter(new SqlParameter(Types.VARCHAR));
			declareParameter(new SqlParameter(Types.INTEGER));
			declareParameter(new SqlParameter(Types.INTEGER));
			declareParameter(new SqlParameter(Types.INTEGER));
			declareParameter(new SqlParameter(Types.INTEGER));
			declareParameter(new SqlParameter(Types.VARCHAR));
		}
	}

	private class MiSaveAction extends SqlUpdate {

		private static final String UPDATE_SQL = "UPDATE mediainfo " +
				"SET media=?," +
				"    audio_rate=?," +
				"    audio_sampling=?," +
				"    audio_duration=?," +
				"    audio_codec=?," +
				"    video_width=?," +
				"    video_height=?," +
				"    video_rate=?," +
				"    video_duration=?," +
				"    video_codec=?" +
				"WHERE tid=?";

		public MiSaveAction(DataSource ds) {
			setDataSource(ds);
			setSql(UPDATE_SQL);
			declareParameters();
			compile();
		}

		private void declareParameters() {
			declareParameter(new SqlParameter(Types.VARCHAR));
			declareParameter(new SqlParameter(Types.INTEGER));
			declareParameter(new SqlParameter(Types.INTEGER));
			declareParameter(new SqlParameter(Types.INTEGER));
			declareParameter(new SqlParameter(Types.VARCHAR));
			declareParameter(new SqlParameter(Types.INTEGER));
			declareParameter(new SqlParameter(Types.INTEGER));
			declareParameter(new SqlParameter(Types.INTEGER));
			declareParameter(new SqlParameter(Types.INTEGER));
			declareParameter(new SqlParameter(Types.VARCHAR));
			declareParameter(new SqlParameter(Types.INTEGER));
		}
	}

	@Override
	public void add(MediainfoModel mi) {
		if (addAction == null) {
			addAction = new MiAddAction(getDataSource());
		}
		addAction.update(
				mi.getTid(),
				mi.getMedia(),
				mi.getAudio_rate(),
				mi.getAudio_sampling(),
				mi.getAudio_duration(),
				mi.getAudio_codec(),
				mi.getVideo_width(),
				mi.getVideo_height(),
				mi.getVideo_rate(),
				mi.getVideo_duration(),
				mi.getVideo_codec());
	}
}
