package com.niit.DAO;

import com.niit.Model.ProfilePicture;

public interface ProfilePictureDao {
	void uploadProfilePicture(ProfilePicture profilePicture);
	ProfilePicture  getProfilePicture(String email);

}
