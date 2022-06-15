package com.dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.management.RuntimeErrorException;

import org.springframework.stereotype.Repository;

import com.bean.FileBean;
import com.serives.FileStorageServices;

@Repository
public class FIleStorageServiceImpl implements FileStorageServices {

	private final Path root = Paths.get("uploads");

	@Override
	public void init() {

		try {
			Files.createDirectory(root);
			System.out.println("folder created..");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void save(FileBean fileBean) {

		try {
			Files.copy(fileBean.getFile().getInputStream(),
					this.root.resolve(fileBean.getFile().getOriginalFilename()));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("coluld not store file" + e.getMessage());
		}

	}

}
