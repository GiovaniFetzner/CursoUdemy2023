package Set;

import java.time.LocalDateTime;
import java.util.Objects;

public class User {
	
	String user;
	LocalDateTime localDateTime;
	
	public User(String user, LocalDateTime localDateTime) {
		this.user = user;
		this.localDateTime = localDateTime;
	}
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}
	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}

	@Override
	public int hashCode() {
		return Objects.hash(user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(user, other.user);
	}

	@Override
	public String toString() {
		return user + " " + localDateTime;
	}
	
	
	
}
