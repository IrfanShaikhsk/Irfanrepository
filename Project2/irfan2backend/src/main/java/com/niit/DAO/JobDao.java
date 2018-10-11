package com.niit.DAO;

import java.util.List;

import com.niit.Model.Job;

public interface JobDao {
	void saveJob(Job job);
	List<Job>   getAllJobs();
	
}
