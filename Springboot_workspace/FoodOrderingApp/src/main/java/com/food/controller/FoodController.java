package com.food.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.food.model.Food;
import com.food.model.User;
import com.food.service.CustomUserDetailService;
import com.food.service.FoodService;
import com.food.util.FileUploadUtil;
@Controller
public class FoodController {

	@Autowired
	private FoodService fs;
	@Autowired
	private CustomUserDetailService us;
	
	@Autowired
	private BCryptPasswordEncoder bPasswordEncoder;
	
	public FoodService getFs() {
		return fs;
	}
	public void setFs(FoodService fs) {
		this.fs = fs;
	}
	
	public CustomUserDetailService getUs() {
		return us;
	}
	public void setUs(CustomUserDetailService us) {
		this.us = us;
	}
	@RequestMapping("/")
	public String index() {
		return"index";
	}
	/*@RequestMapping("/loginpage")
	public String adminlogin(Model m) {
		User user=new User();
		m.addAttribute("user", user);
		return"login";
	}*/
	/*@RequestMapping("/userregister")
	public String userregister(@ModelAttribute("user") User user,Model m) {
		//User u=us.validate(user.getUsername(),user.getPassword(),user.getUsertype());
		UserDetails u=us.loadUserByUsername(user.getUsername());
		if(u==null) {
			m.addAttribute("msg","Invalid Details");
			return "login";
		}
		else {
			if(user.getUsertype().equals("admin")) {
				return"homepage";
			}
			else {
				return "Userhome";
			}
		}
			
	}*/
	@RequestMapping("/logout")
	public String logout() {
		return "index";
	}
	@RequestMapping("/createNewUser")	
	public String newUSer(Model m) {
		User user=new User();
		m.addAttribute("user", user);
		return "userRegister";
	}
	@RequestMapping("/usersave")
	public String insertUser(@ModelAttribute("user") User user, Model m) {
		user.setPassword(this.bPasswordEncoder.encode(user.getPassword()));
		User u=us.insertUser(user);
		return "index";
	}
	@RequestMapping("/food/home")
	public String home(Model m) {
		List<Food> f=fs.getFood();
		m.addAttribute("food", f);
		return "home";
	}
	@RequestMapping("/food/addnew")
	public String addNewFood(Model model) {
        Food f= new Food();
        model.addAttribute("food",f);
        return "register";
    }
	@RequestMapping("/save")
	public String insertFood(@ModelAttribute("food") Food food,@RequestParam("image") MultipartFile multipartFile) throws IOException {
		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		food.setImage(fileName);
        Food f= fs.insert(food);
 
        String uploadDir = "food-photos/" + f.getFid();
 
        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
		
		return "redirect:home";
	}
	@RequestMapping("food/update/{id}")
	public String updateFood(@PathVariable(value = "id")int id, Model m) {
		Food f=fs.update(id);
        m.addAttribute("food", f);
        return "update";
    }
	
	@RequestMapping("food/delete/{id}")
	public String deleteFood(@PathVariable(value="id")int id)
	{
		fs.delete(id);
		return "redirect:home";
	}
	@RequestMapping("/search")
	public String searchFood(@RequestParam("fname") String fname,Model m) {
		Food food=new Food();
		food.setFname(fname);
		List<Food> f=fs.search(food.getFname());
		m.addAttribute("food",f);
		return "home";
	}
	@RequestMapping("/food")
	public String foodpage(Model m) {
		List<Food> f=fs.getFood();
		m.addAttribute("food", f);
		return "food";
	}
	@RequestMapping("/success")
	public String success() {
		return "success";
	}
}
