package co.edu.escuelaing.cvds.lab7.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.UUID;


@Entity
@Table(name = "session")
public class Session {
    @Id
    @Column(name = "token", nullable=false, unique=true)
    private UUID token;

    public Session() {
    	
    }
	public Session(UUID token, Instant timestamp, User user) {
		this.token = token;
		this.timestamp = timestamp;
		this.user = user;
	}

	public UUID getToken() {
		return token;
	}

	public void setToken(UUID token) {
		this.token = token;
	}

	public Instant getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Instant timestamp) {
		this.timestamp = timestamp;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "timestamp", nullable = false)
    private Instant timestamp;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}