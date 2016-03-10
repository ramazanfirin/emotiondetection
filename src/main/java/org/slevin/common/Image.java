package org.slevin.common;

import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashSet;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.slevin.common.Item;

@Entity
@Table(name="IMAGE")
public class Image {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String path;
	
	private String reference;
	
	private Date insertDate;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="IMAGE_ID")
	private Collection<Face> facelist = new LinkedHashSet<Face>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public Date getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}

	public Collection<Face> getFacelist() {
		return facelist;
	}

	public void setFacelist(Collection<Face> facelist) {
		this.facelist = facelist;
	}

	

	

}
