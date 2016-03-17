package org.slevin.dao;

import java.util.List;

import org.slevin.common.Image;


public interface ImageDao extends EntityDao<Image> {
	public List<Image> findInRange(int firstResult, int maxResults,Boolean showFaces) throws Exception;
}
