package com.yeshj.pacman.dao;

import com.yeshj.pacman.model.MediainfoModel;

public interface IMediainfoDAO {

	/**
	 * Adds a new MediainfoModel.
	 *
	 * @param mi the MediainfoModel to add
	 */
	void add(MediainfoModel mi);

	/**
	 * Deletes a MediainfoModel.
	 *
	 * @param mi the MediainfoModel to delete
	 */
	void delete(MediainfoModel mi);

	/**
	 * Saves a MediainfoModel.
	 *
	 * @param mi the MediainfoModel to save
	 */
	void save(MediainfoModel mi);

	/**
	 * Finds a MediainfoModel by its primary key.
	 *
	 * @param taskid the primary key of the MediainfoModel
	 * @return the found MediainfoModel
	 */
	MediainfoModel findByPk(int taskid);
}
