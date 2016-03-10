package org.slevin.dao.service;


import org.slevin.common.Face;
import org.slevin.dao.FaceDao;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
@Transactional
public class FaceService extends EntityService<Face> implements FaceDao {

	
}

