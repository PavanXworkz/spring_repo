package com.xworkz.rtodepartment.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.xworkz.rtodepartment.dto.DLDTO;
import com.xworkz.rtodepartment.service.DlService;

@Controller
@RequestMapping("/")
public class DlConroller {
	@Autowired
	DlService service;

	@PostMapping("dl")
	public String save(@ModelAttribute DLDTO dldto, Model model) {
		boolean dldto2 = service.validateAndSave(dldto);
		model.addAttribute("dl", dldto2);
		model.addAttribute("appl", dldto.getApplicationNumber());

		System.out.println(dldto);
		model.addAttribute("app", "sucessful");
		return "document";

	}

	@GetMapping("approve")
	public String updateById(@RequestParam int id, Model model) {
		boolean update = service.updateById(id);
		if (update == true) {
			model.addAttribute("d", id);
			model.addAttribute("up", "updated sucessfully");
			return "officerProfile";
		} else {
			model.addAttribute("nd", "update un sucessful");
		}
		return "officerProfile";

	}

	@GetMapping("getapplication")
	public String uplodeFile(@RequestParam String applicationNumber, Model model) {
		DLDTO dto = service.updateApplication(applicationNumber);
		model.addAttribute("appl", dto.getApplicationNumber());
		model.addAttribute("dto", dto);
		return null;
	}

	@PostMapping("/upload")
	public String uploadFile(@RequestParam MultipartFile file, @RequestParam String applicationNumber, Model model) {
		DLDTO dldto = service.updateApplication(applicationNumber);
		System.err.println(applicationNumber);
		if (file.isEmpty()) {
			model.addAttribute("message", "Please select a file to upload");
			return "officerProfile";
		}
		try {

			String fileContentType = file.getContentType();
			String filename = file.getOriginalFilename();
			dldto.setFile(filename);
			System.out.println("File Name is   : " + filename + "   content type is    " + fileContentType);
			byte[] bytes = file.getBytes();
			Path path = Paths.get("C://upload//" + file.getOriginalFilename());

			Files.write(path, bytes);
			service.updateById(dldto);
			model.addAttribute("message", "You successfully uploaded '" + file.getOriginalFilename() + "'");

		} catch (IOException e) {
			e.printStackTrace();
		}

		return "document";
	}

	@GetMapping("/download")
	public void downloadFile(HttpServletResponse response, @RequestParam String fileName) throws FileNotFoundException {
		// fetch data filename
		/*
		 * Path path = Paths.get("C:\\Downloded//44.jpg"); path.toFile();
		 */
		response.setContentType("image/jpeg");
		File file = new File("C://upload//" + fileName);

		try {
			InputStream buffer = new BufferedInputStream(new FileInputStream(file));
			ServletOutputStream out = response.getOutputStream();
			FileCopyUtils.copy(buffer, out);
			// model.addAttribute("image", out);
			response.flushBuffer();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@GetMapping("/display")
	public String dldisplay(@RequestParam String applicationNumber, HttpServletResponse response, Model model) {
		DLDTO dlDto = service.updateApplication(applicationNumber);
		model.addAttribute("UserImage", dlDto.getFile());
		model.addAttribute("dto", dlDto);
		return "Dldisplay";

	}

}
