package org.slevin.common;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="EMOTION")
public class Emotion {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	private Face face;
	
	
	private Double contempt;
	
	private Double surprise;
	
	private Double happiness;
	
	private Double neutral;
	
	private Double sadness;
	
	private Double disgust;
	
	private Double anger;
	
	private Double fear;
	
	private String result;
	
	
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date insertDateTime;
	
	@Temporal(TemporalType.DATE)
	private java.util.Date insertDate;
	    
	@Temporal(TemporalType.TIME)
	private java.util.Date insertTime;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getContempt() {
		return contempt;
	}

	public void setContempt(Double contempt) {
		this.contempt = contempt;
	}

	public Double getSurprise() {
		return surprise;
	}

	public void setSurprise(Double surprise) {
		this.surprise = surprise;
	}

	public Double getHappiness() {
		return happiness;
	}

	public void setHappiness(Double happiness) {
		this.happiness = happiness;
	}

	public Double getNeutral() {
		return neutral;
	}

	public void setNeutral(Double neutral) {
		this.neutral = neutral;
	}

	public Double getSadness() {
		return sadness;
	}

	public void setSadness(Double sadness) {
		this.sadness = sadness;
	}

	public Double getDisgust() {
		return disgust;
	}

	public void setDisgust(Double disgust) {
		this.disgust = disgust;
	}

	public Double getAnger() {
		return anger;
	}

	public void setAnger(Double anger) {
		this.anger = anger;
	}

	public Double getFear() {
		return fear;
	}

	public void setFear(Double fear) {
		this.fear = fear;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Face getFace() {
		return face;
	}

	public void setFace(Face face) {
		this.face = face;
	}

	public java.util.Date getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(java.util.Date insertDate) {
		this.insertDate = insertDate;
	}

	public java.util.Date getInsertTime() {
		return insertTime;
	}

	public void setInsertTime(java.util.Date insertTime) {
		this.insertTime = insertTime;
	}

	public java.util.Date getInsertDateTime() {
		return insertDateTime;
	}

	public void setInsertDateTime(java.util.Date insertDateTime) {
		this.insertDateTime = insertDateTime;
	}

	
	
	
}
