package com.unifiedDashboard.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="job_report")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, 
allowGetters = true)
public class JobReport {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String country=null;
	private String tenantId;
	private String month;
	private String billingPeriod=null;
	private String lastUpdated;
	private String processState;
	private String lastProcessed;
	private String notification;
	@Column(name="created_at", nullable = false, updatable = false)
	@CreatedDate
	private Date createdAt;
	
	private String status=null;
	private String ccTicketId=null;
	
	
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
	public String getTenantId() {
		return tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getBillingPeriod() {
		return billingPeriod;
	}
	public void setBillingPeriod(String billingPeriod) {
		this.billingPeriod = billingPeriod;
	}
	public String getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	public String getProcessState() {
		return processState;
	}
	public void setProcessState(String processState) {
		
		this.processState = processState;
	}
	public String getLastProcessed() {
		return lastProcessed;
	}
	public void setLastProcessed(String lastProcessed) {
		this.lastProcessed = lastProcessed;
	}
	public String getNotification() {
		return notification;
	}
	public void setNotification(String notification) {
		this.notification = notification;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCcTicketId() {
		return ccTicketId;
	}
	public void setCcTicketId(String ccTicketId) {
		this.ccTicketId = ccTicketId;
	}
	public JobReport(int id, String country, String tenantId, String month, String billingPeriod, String lastUpdated,
			String processState, String lastProcessed, String notification, Date createdAt, String status,
			String ccTicketId) {
		super();
		this.id = id;
		this.country = country;
		this.tenantId = tenantId;
		this.month = month;
		this.billingPeriod = billingPeriod;
		this.lastUpdated = lastUpdated;
		this.processState = processState;
		this.lastProcessed = lastProcessed;
		this.notification = notification;
		this.createdAt = createdAt;
		this.status = status;
		this.ccTicketId = ccTicketId;
	}
	public JobReport() {
		
	}
	
	

}
