package org.slevin.prime.faces.bean;


import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.SelectEvent;
import org.slevin.common.Emotion;
import org.slevin.common.Face;
import org.slevin.common.Image;
import org.slevin.dao.EmotionDao;
import org.slevin.dao.FaceDao;
import org.slevin.dao.ImageDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component(value="reportMB")
@ViewScoped
public class ReportMB implements Serializable {
	
	static String recordPath ="c:\\snapshots\\";

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Autowired
	private ImageDao imageService;
	
	@Autowired
	private EmotionDao emotionService;
	
	@Autowired
	private FaceDao faceService;
	
	Long imageCount;
	
	Long faceCount;
	
	Long emotionCount;
	
	List<Image> imageList;
	
	Image selectedImage;
	
	List<Emotion> emotionList; 
	
	Boolean showOnlyFace;

	@PostConstruct
    public void init() throws Exception {
		imageCount = imageService.count();
		faceCount = faceService.count();
		emotionCount = emotionService.count();
    }

	public void list() throws Exception{
		imageCount = imageService.count();
		faceCount = faceService.count();
		emotionCount = emotionService.count();
		
		imageList = imageService.findInRange(0, 1000,showOnlyFace);
	}
	
	public void onRowSelect(SelectEvent event) throws Exception {
		selectedImage=(Image) event.getObject();
		Collection<Face> faceList= selectedImage.getFacelist();
		emotionList = emotionService.findByProperty("face.image.id", selectedImage.getId());
		System.out.println("bitti "+selectedImage.getFileName());
        
    }

	public static String getRecordPath() {
		return recordPath;
	}


	public static void setRecordPath(String recordPath) {
		ReportMB.recordPath = recordPath;
	}


	public ImageDao getImageService() {
		return imageService;
	}


	public void setImageService(ImageDao imageService) {
		this.imageService = imageService;
	}


	public EmotionDao getEmotionService() {
		return emotionService;
	}


	public void setEmotionService(EmotionDao emotionService) {
		this.emotionService = emotionService;
	}


	public FaceDao getFaceService() {
		return faceService;
	}


	public void setFaceService(FaceDao faceService) {
		this.faceService = faceService;
	}


	public Long getImageCount() {
		return imageCount;
	}


	public void setImageCount(Long imageCount) {
		this.imageCount = imageCount;
	}


	public Long getFaceCount() {
		return faceCount;
	}


	public void setFaceCount(Long faceCount) {
		this.faceCount = faceCount;
	}


	public Long getEmotionCount() {
		return emotionCount;
	}


	public void setEmotionCount(Long emotionCount) {
		this.emotionCount = emotionCount;
	}


	public List<Image> getImageList() {
		return imageList;
	}


	public void setImageList(List<Image> imageList) {
		this.imageList = imageList;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public Image getSelectedImage() {
		return selectedImage;
	}


	public void setSelectedImage(Image selectedImage) {
		this.selectedImage = selectedImage;
	}


	public List<Emotion> getEmotionList() {
		return emotionList;
	}


	public void setEmotionList(List<Emotion> emotionList) {
		this.emotionList = emotionList;
	}

	public Boolean getShowOnlyFace() {
		return showOnlyFace;
	}

	public void setShowOnlyFace(Boolean showOnlyFace) {
		this.showOnlyFace = showOnlyFace;
	}
	
	
	
	
	
	
	
	
	
	
	
}


