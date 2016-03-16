package org.slevin.common;

import java.util.Collection;
import java.util.LinkedHashSet;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="FACE")
public class Face {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private Long topValue;
	
	private Long widthvalue;
	
	private Long leftValue;
	
	private Long heightValue;
	
	@ManyToOne
	private Image image;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="FACE_ID")
	private Collection<Emotion> emotionList = new LinkedHashSet<Emotion>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTopValue() {
		return topValue;
	}

	public void setTopValue(Long topValue) {
		this.topValue = topValue;
	}

	public Long getWidthvalue() {
		return widthvalue;
	}

	public void setWidthvalue(Long widthvalue) {
		this.widthvalue = widthvalue;
	}

	public Long getLeftValue() {
		return leftValue;
	}

	public void setLeftValue(Long leftValue) {
		this.leftValue = leftValue;
	}

	public Long getHeightValue() {
		return heightValue;
	}

	public void setHeightValue(Long heightValue) {
		this.heightValue = heightValue;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public Collection<Emotion> getEmotionList() {
		return emotionList;
	}

	public void setEmotionList(Collection<Emotion> emotionList) {
		this.emotionList = emotionList;
	}

	
	public Emotion getFirstEmotion(){
		if(emotionList.size()>0){
			Emotion strz[] = (Emotion[])emotionList.toArray();
			return strz[1];
		}
		return null;
	}

}
