package com.niit.DAO;

import com.niit.Model.ProfilePic;

public interface ProfilePicDAO {
	void uploadProfilePicture(ProfilePic profilePic);
	ProfilePic  getProfilePicture(String email);
	}
