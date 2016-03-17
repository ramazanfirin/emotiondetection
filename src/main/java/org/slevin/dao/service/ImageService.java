package org.slevin.dao.service;


import java.util.List;

import org.slevin.common.Image;
import org.slevin.dao.ImageDao;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
@Transactional
public class ImageService extends EntityService<Image> implements ImageDao {

	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<Image> findInRange(int firstResult, int maxResults,Boolean showFaces) throws Exception {
        if(!showFaces)
        	return getEntityManager().createQuery("Select i from Image i order by i.insertDate desc").setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
        else
        	return getEntityManager().createQuery("Select i from Image i where i.faceCount > 0 order by i.insertDate desc").setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
	}
}

