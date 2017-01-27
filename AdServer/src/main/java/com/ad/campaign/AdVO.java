package com.ad.campaign;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "adVO")
public class AdVO {

	String partner_id;
	int duration;
	String ad_content;
	Date createdTime;
	
	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public AdVO() {
	}

	public AdVO(String partnerId, int duration, String adContent) {
		this.partner_id = partnerId;
		this.duration = duration;
		this.ad_content = adContent;
	}

	public String getPartner_id() {
		return partner_id;
	}

	@XmlElement
	public void setPartner_id(String partner_id) {
		this.partner_id = partner_id;
	}

	public int getDuration() {
		return duration;
	}

	@XmlElement
	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getAd_content() {
		return ad_content;
	}

	@XmlElement
	public void setAd_content(String ad_content) {
		this.ad_content = ad_content;
	}

}
