package com.niit.DAO;

import java.util.List;

import com.niit.Model.Friend;
import com.niit.Model.User;

public interface FriendDao {

	List<User> getSuggestedUsers(String email);

	void addFriendRequest(Friend friend);

	List<Friend> getPendingRequests(String email);

	void acceptFriendRequest(Friend friend);

	void deleteFriendRequest(Friend friend);

	List<User> listOfFriends(String email);

}
