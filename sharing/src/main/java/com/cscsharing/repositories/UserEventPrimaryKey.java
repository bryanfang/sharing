package com.cscsharing.repositories;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UserEventPrimaryKey implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// User ID as one of primary keys
	private String userId;

	// event ID as another one of primary keys
	private String eventId;

	public UserEventPrimaryKey() {

	}

	public UserEventPrimaryKey(String userId, String eventId) {
		this.userId = userId;
		this.eventId = eventId;
	}

	@Column(length = 10, nullable = false)
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(length = 50, nullable = false)
	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result + ((eventId == null) ? 0 : eventId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		UserEventPrimaryKey uepk = (UserEventPrimaryKey) obj;
		if (userId == null) {
			if (uepk.userId != null)
				return false;
		} else if (!userId.equals(uepk.userId))
			return false;
		if (eventId == null) {
			if (uepk.eventId != null)
				return false;
		} else if (!eventId.equals(uepk.eventId))
			return false;
		return true;
	}
}
