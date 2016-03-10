package org.slevin.dao;

import org.slevin.common.Emotion;


public interface EmotionDao extends EntityDao<Emotion> {
	
	public String sendFile(byte[] data);
}
