package com.b2b.service;

import com.b2b.dto.User;

public interface LoginService {
	public User getUserType(User user);
	public long getPharId(User user);
	public long getManuId(User user);
	public long getAdminId(User user);
}
