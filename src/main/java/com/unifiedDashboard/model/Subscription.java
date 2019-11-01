package com.unifiedDashboard.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@Table(name="unified_dashboard")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, 
allowGetters = true)

public class Subscription {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String country;
	private String subscriptionId;
	private String plan;
	private String odinId=null;
	private String date;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getSubscriptionId() {
		return subscriptionId;
	}
	public void setSubscriptionId(String subscriptionId) {
		this.subscriptionId = subscriptionId;
	}
	public String getPlan() {
		return plan;
	}
	public void setPlan(String plan) {
		this.plan = plan;
	}
	
	public String getOdinId() {
		if(odinId==null)
			return null;
		else
		return odinId;
	}
	public void setOdinId(String odinId) {
		this.odinId = odinId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Subscription [id=" + id + ", country=" + country + ", subscriptionId=" + subscriptionId + ", plan="
				+ plan + ", odinId=" + odinId + ", date=" + date + "]";
	}
	public Subscription(int id, String country, String subscriptionId, String plan, String odinId, String date) {
		super();
		this.id = id;
		this.country = country;
		this.subscriptionId = subscriptionId;
		this.plan = plan;
		this.odinId = odinId;
		this.date = date;
	}
	public Subscription() {
		
	}
	
	
}
