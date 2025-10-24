package com.careNcure.backend.config;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileStorageService {
	@Value("${file.upload-dir-doctor}")
	private String doctorUploadDir;

	@Value("${file.upload-dir-hospital}")
	private String hospitalUploadDir;

	public String saveDoctorImage(MultipartFile file,String docId) throws IOException {
		return saveFile(file, doctorUploadDir, docId);
	}

	public String saveHospitalImage(MultipartFile file,String docId) throws IOException {
		return saveFile(file, hospitalUploadDir, docId);
	}

	private String saveFile(MultipartFile file, String dir, String fileName) throws IOException {
		 Path uploadPath = Paths.get(dir);
		    if (!Files.exists(uploadPath)) {
		        Files.createDirectories(uploadPath);
		    }

		    // Extract extension from original filename
		    String originalFilename = file.getOriginalFilename();
		    String extension = "";
		    if (originalFilename != null && originalFilename.contains(".")) {
		        extension = originalFilename.substring(originalFilename.lastIndexOf("."));
		    }

		    // Append extension to your custom fileName
		    String finalFileName = fileName + extension;

		    Path filePath = uploadPath.resolve(finalFileName);
		    Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

		    return finalFileName;
	}
}
