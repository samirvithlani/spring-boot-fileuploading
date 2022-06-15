package com.serives;

import org.springframework.stereotype.Service;

import com.bean.FileBean;


public interface FileStorageServices {

	public void init();

	public void save(FileBean fileBean);
	

}
