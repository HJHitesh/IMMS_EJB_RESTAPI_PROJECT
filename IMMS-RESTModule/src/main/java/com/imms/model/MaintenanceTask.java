package com.imms.model;

import java.util.Date;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class MaintenanceTask {
    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    private Machine machine;

    @ManyToOne
    private Technician assignedTechnician;

    @Enumerated(EnumType.STRING)
    private TaskType taskType;

    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    @Temporal(TemporalType.TIMESTAMP)
    private Date scheduledDateTime;

    @Temporal(TemporalType.TIMESTAMP)
    private Date completionDateTime;

    @Column(length = 1000)
    private String remarks;

    public enum TaskType { ROUTINE, EMERGENCY, INSPECTION }
    public enum TaskStatus { SCHEDULED, IN_PROGRESS, COMPLETED, FAILED, CANCELLED }
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Machine getMachine() {
		return machine;
	}
	public void setMachine(Machine machine) {
		this.machine = machine;
	}
	public Technician getAssignedTechnician() {
		return assignedTechnician;
	}
	public void setAssignedTechnician(Technician assignedTechnician) {
		this.assignedTechnician = assignedTechnician;
	}
	public TaskType getTaskType() {
		return taskType;
	}
	public void setTaskType(TaskType taskType) {
		this.taskType = taskType;
	}
	public TaskStatus getStatus() {
		return status;
	}
	public void setStatus(TaskStatus status) {
		this.status = status;
	}
	public Date getScheduledDateTime() {
		return scheduledDateTime;
	}
	public void setScheduledDateTime(Date scheduledDateTime) {
		this.scheduledDateTime = scheduledDateTime;
	}
	public Date getCompletionDateTime() {
		return completionDateTime;
	}
	public void setCompletionDateTime(Date completionDateTime) {
		this.completionDateTime = completionDateTime;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

    
}
