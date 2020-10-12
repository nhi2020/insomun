package egovframework.let.shop.scheduler.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.let.shop.scheduler.service.SchedulerService;

@Service("scheduler")
public class SchedulerImpl implements SchedulerService {
	
	@Resource(name = "schedulerDao")
	private SchedulerDAO schedulerDAO;
	
	@Override
	public int delChk() throws Exception {
		int del = schedulerDAO.delSch();
		return del;
	}

}
