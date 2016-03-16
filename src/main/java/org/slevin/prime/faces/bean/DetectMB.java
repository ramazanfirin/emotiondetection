package org.slevin.prime.faces.bean;


import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.imageio.ImageIO;

import org.openimaj.image.ImageUtilities;
import org.openimaj.image.processing.face.detection.DetectedFace;
import org.openimaj.image.processing.face.detection.HaarCascadeDetector;
import org.slevin.common.Face;
import org.slevin.common.Image;
import org.slevin.dao.EmotionDao;
import org.slevin.dao.ImageDao;
import org.slevin.util.EmotionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.sarxos.webcam.Webcam;



@Component(value="detectMB")
@ApplicationScoped
public class DetectMB implements Serializable {
	
	static String recordPath ="c:\\snapshots\\";

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Autowired
	private ImageDao imageService;
	
	@Autowired
	private EmotionDao emotionService;

	
	private ScheduledExecutorService scheduler; 
	
	private static final HaarCascadeDetector detector = new HaarCascadeDetector();
	private List<DetectedFace> faces = null;
	
	@PostConstruct
    public void init() {
		//refreshList();
//		scheduler = Executors.newSingleThreadScheduledExecutor();
//		scheduler.scheduleAtFixedRate(new TakePictureJob(), 0, 5, TimeUnit.SECONDS);
    }
	
	
	
	
	
	
	public class TakePictureJob implements Runnable {

	    public void run() {
	    	try {
				
	    		Webcam webcam = Webcam.getDefault();
	    		webcam.open();
	    		BufferedImage image = webcam.getImage();
	    		String fileName=System.currentTimeMillis()+".png";
	    		String path=recordPath+fileName;
	    		ImageIO.write(image, "PNG", new File(path));
	    		System.out.println(path+ " kaydedildi.");
	    		
	    		Image imageObject = new Image();
	    		imageObject.setInsertDate(new Date());
	    		imageObject.setPath(path);
	    		imageObject.setFileName(fileName);
	    		imageService.persist(imageObject);
	    		
	    		List<DetectedFace> faces = detector.detectFaces(ImageUtilities.createFImage(image));
	    		imageObject.setFaceCount(new Long(faces.size()));
	    		if(faces.size()>0){
	    			ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    			ImageIO.write(image, "PNG", baos);
	    			baos.flush();
	    			byte[] bytes= baos.toByteArray();
	    			baos.close();

	    			String result = emotionService.sendFile(bytes);
	    			List<Face> list = EmotionUtil.parseEmotionResult(result);
	    			imageObject.getFacelist().addAll(list);
	    			
	    			
	    			
	    		}
	    		
	    		imageService.merge(imageObject);
	    		
	    		
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }

	}
	
	public class DetectFaceJob implements Runnable {

	    public void run() {
	    	try {
				//FImage a= new ;
	    		//faces = detector.detectFaces(ImageUtilities.createFImage(webcam.getImage()));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }

	}


public static void main(String[] args) throws IOException {
//Thread t = new Thread(new TakePictureJob())	;
//t.start();
	DetectMB detectMB = new DetectMB();
	detectMB.init();
//	Webcam webcam = Webcam.getDefault();
//	webcam.open();
//	BufferedImage image = webcam.getImage();
//	ImageIO.write(image, "PNG", new File(recordPath+System.currentTimeMillis()+".png"));
//	System.out.println(recordPath+System.currentTimeMillis()+".png"+ " kaydedildi.");
}
	
	
	
	
}


