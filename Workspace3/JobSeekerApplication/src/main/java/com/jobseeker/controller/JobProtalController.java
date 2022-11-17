package com.jobseeker.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.jobseeker.model.ApplyJobs;
import com.jobseeker.model.JobSeeker;
import com.jobseeker.model.Recuriter;
import com.jobseeker.service.ApplyJobService;
import com.jobseeker.service.JobSeekerService;
import com.jobseeker.service.RecuriterService;

@Controller
public class JobProtalController {

	@Autowired
	JobSeekerService js;
	@Autowired
	RecuriterService rs;
	@Autowired
	ApplyJobService ajs;
	String exe;
	@RequestMapping("/")
	public String loginpage() {
		return "login";
	}
	@RequestMapping("/signin")
	public String login(@RequestParam("username")String username,@RequestParam("password")String password,@RequestParam("role")String role,Model m) {
		if(role.equalsIgnoreCase("Recuriter")) {
			Recuriter r=rs.validate(username, password);
			if(r==null) {
				m.addAttribute("msg","please check Details / Register ");
				return "login";
			}else {
				m.addAttribute("id",r.getRecuriterid());
				List<ApplyJobs> JobsList=ajs.getAllApplyJobs();
				for(ApplyJobs a:JobsList) {
					System.out.println(a);
				}
				m.addAttribute("JobsList",ajs.getAllApplyJobs());
				return "Recuriterhome";
			}
		}
		else {
			JobSeeker j=js.validate(username, password);
			if(j==null) {
				m.addAttribute("msg","please check Details / Register ");
				return "login";
			}
			else {
				m.addAttribute("id",j.getId());
				m.addAttribute("recuriterList",rs.getAllRecuriters());
				return "jobSeekerhome";
			}
		}
	}
	@RequestMapping("/newJobseeker")
	public String newJobSeeker(Model m) {
		m.addAttribute("jobseeker",new JobSeeker());
		return "JobSeekerRegister";
	}
	@PostMapping(value="/savejobseeker" ,consumes = MediaType.MULTIPART_FORM_DATA_VALUE,produces =MediaType.MULTIPART_FORM_DATA_VALUE)
	public String saveJobSeeker(@ModelAttribute("jobseeker")JobSeeker jobSeeker,@RequestParam("resume") MultipartFile file,Model m) throws IOException {
		jobSeeker.setResume(file.getBytes());
		js.addJobSeeker(jobSeeker);
		String content=file.getContentType();
		if(content.equalsIgnoreCase("application/pdf"))
			exe=".pdf";
		if(content.equalsIgnoreCase("application/vnd.openxmlformats-officedocument.wordprocessingml.document"))
			exe=".docx";
		file.transferTo(new File("C:\\Workspace3\\JobSeekerApplication\\src\\main\\resources\\static\\files"+jobSeeker.getUsername()+exe));
		m.addAttribute("msg","add successfully");
		return "JobSeekerRegister";
	}
	@RequestMapping("/newRecuriter")
	public String newRecuriter(Model m) {
		m.addAttribute("recuriter",new Recuriter());
		return "RecuriterRegister";
	}
	@PostMapping("/saveRecuriter")
	public String addRecuriter(@ModelAttribute("recuriter") Recuriter recuriter,Model m) {
		rs.addRecuriter(recuriter);
		m.addAttribute("msg","adding successfully");
		return "RecuriterRegister";
	}
	@PostMapping("/searchjob")
	public String searchingJob(@RequestParam("job")String job,Model m) {
		List<Recuriter> recuriterList=rs.findByJob(job);
		if(recuriterList.isEmpty()) {
			m.addAttribute("message","No Jobs Found");
			return "jobSeekerhome";
		}
		m.addAttribute("recuriterList",recuriterList);
		return "jobSeekerhome";
	}
	@RequestMapping("/updateProfile/{id}")
	public String updateProfile(@PathVariable("id") int id,Model m) {
		JobSeeker jobSeeker=js.updateJobSeeker(id);
		m.addAttribute("jobseeker", jobSeeker);
		return "JobSeekerRegister";
	}
	@RequestMapping("/applyJob/{uid}/{recuriterid}")
	public String applyJobs(@PathVariable("uid")int uid,@PathVariable("recuriterid")int rid,Model m) {
		ApplyJobs a=new ApplyJobs();
		JobSeeker jobseeker=js.findByJobSeeker(uid);
		Recuriter recuriter=rs.getRecuriterById(rid);
		a.setJobseekerid(jobseeker);
		a.setRecuriterid(recuriter);
		ajs.addJobs(a);
		m.addAttribute("message","Job SuccessFully applied");
		return "jobSeekerhome";
	}
	@RequestMapping("/updateRecuriterProfile/{id}")
	public String updateRecuriterProfile(@PathVariable("id") int id,Model m) {
		Recuriter r=rs.updateRecuriter(id);
		m.addAttribute("recuriter",r);
		return "RecuriterRegister";
	}
	@RequestMapping("/file/{username}")
	@ResponseBody
	public void show(@PathVariable("username") String fileName, HttpServletResponse response) {

	      if (fileName.indexOf(".doc")>-1) response.setContentType("application/msword");
	      if (fileName.indexOf(".docx")>-1) response.setContentType("application/msword");
	      if (fileName.indexOf(".xls")>-1) response.setContentType("application/vnd.ms-excel");
	      if (fileName.indexOf(".csv")>-1) response.setContentType("application/vnd.ms-excel");
	      if (fileName.indexOf(".ppt")>-1) response.setContentType("application/ppt");
	      if (fileName.indexOf(".pdf")>-1) response.setContentType("application/pdf");
	      if (fileName.indexOf(".zip")>-1) response.setContentType("application/zip");
	      response.setHeader("Content-Disposition", "attachment; filename=" +fileName);
	      response.setHeader("Content-Transfer-Encoding", "binary");
	      try {
	    	  BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
	    	  FileInputStream fis = new FileInputStream("C:\\Workspace3\\JobSeekerApplication\\src\\main\\resources\\static\\files"+fileName);
	    	  int len;
	    	  byte[] buf = new byte[1024];
	    	  while((len = fis.read(buf)) > 0) {
	    		  bos.write(buf,0,len);
	    	  }
	    	  bos.close();
	    	  response.flushBuffer();
	      }
	      catch(IOException e) {
	    	  e.printStackTrace();
	    	  
	      }
	}
}
