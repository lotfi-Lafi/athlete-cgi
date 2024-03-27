package com.sport.running.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import com.sport.athlete.entity.AthleteEntity;
// import javax.persistence.JoinColumn;

@Entity
@Table(
        name = "running"
)
public class RunningEntity {
	
	@Id
    @GeneratedValue
	private Long id;
	private int track;
	private Date date = new Date();
	
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "running_athlete", 
		joinColumns = { @JoinColumn(name = "running_id") }, 
		inverseJoinColumns = { @JoinColumn(name = "athlete_id") }
	)
	private Set<AthleteEntity> athlete = new HashSet<>();
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getTrack() {
		return track;
	}
	public void setTrack(int track) {
		this.track = track;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public RunningEntity() {
    }
	
	public RunningEntity(Long id, int track, Date date) {
		super();
		this.id = id;
		this.track = track;
		this.date = date;
	}
	

}