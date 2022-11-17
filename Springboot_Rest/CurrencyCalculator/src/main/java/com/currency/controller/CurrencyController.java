package com.currency.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.currency.model.Converter;
import com.currency.service.CurrencyService;

@Controller
public class CurrencyController {
	double total=0.0;
	Date date=new Date();
	@Autowired
	CurrencyService cs;
	@RequestMapping("/")
	public String calculator(Model m) {
		Converter converter=new Converter();
		m.addAttribute("converter", converter);
		return "convert";
	}
	@RequestMapping("/converting")
	public String converting(@ModelAttribute("converter") Converter converter,Model m) {
		if(converter.getFrom().equalsIgnoreCase("rupee")) {
			
			if(converter.getTo().equalsIgnoreCase("us")) {
					total=converter.getAmount()*0.0128793;
					m.addAttribute("msg", converter.getAmount()+ " INR ="+ total +" USD");
			}
			else if(converter.getTo().equalsIgnoreCase("euro")) {
					total=converter.getAmount()*0.01223202;
					m.addAttribute("msg", converter.getAmount()+ " INR ="+ total +" Euro");
			}
			else if(converter.getTo().equalsIgnoreCase("kwd")) {
				total=converter.getAmount()*0.0039469811;
				m.addAttribute("msg", converter.getAmount()+ " INR ="+ total +" KWD");
			}
			else if(converter.getTo().equalsIgnoreCase("uae")) {
				total=converter.getAmount()*0.047294647;
				m.addAttribute("msg", converter.getAmount()+ " INR ="+ total +" AED");	
			}
			m.addAttribute("date","Present Date And Time ::"+date);
			return "convert";
		}
		else if(converter.getFrom().equalsIgnoreCase("us")) {
			
			if(converter.getTo().equalsIgnoreCase("rupee")) {
					String s=cs.searchCurrencyRates("us");
					double d=Double.parseDouble(s);
					total=converter.getAmount()*d;
					m.addAttribute("msg", converter.getAmount()+ " USD ="+ total +" INR");		
			}
			else if(converter.getTo().equalsIgnoreCase("euro")) {
					String s=cs.searchCurrencyRates("us");
					double d=Double.parseDouble(s);
					total=converter.getAmount()*d;
					m.addAttribute("msg", converter.getAmount()+ " USD ="+ total +" Euro");
			}
			else if(converter.getTo().equalsIgnoreCase("kwd")) {
				String s=cs.searchCurrencyRates("us");
				double d=Double.parseDouble(s);
				total=converter.getAmount()*d;
				m.addAttribute("msg", converter.getAmount()+ " USD ="+ total +" KWD");
			}
			else if(converter.getTo().equalsIgnoreCase("uae")) {
				String s=cs.searchCurrencyRates("us");
				double d=Double.parseDouble(s);
				total=converter.getAmount()*d;
				m.addAttribute("msg", converter.getAmount()+ " USD ="+ total +" AED");
				}
			m.addAttribute("date","Present Date And Time ::"+date);
			return "convert";
		}
		else if(converter.getFrom().equalsIgnoreCase("euro")) {
			
			if(converter.getTo().equalsIgnoreCase("rupee")) {
				String s=cs.searchCurrencyRates("euro");
				double d=Double.parseDouble(s);
				total=converter.getAmount()*d;
					m.addAttribute("msg", converter.getAmount()+ " Euro ="+ total +" INR");		
			}
			else if(converter.getTo().equalsIgnoreCase("us")) {
					total=converter.getAmount()* 1.05193;
					m.addAttribute("msg", converter.getAmount()+ " Euro ="+ total +" USD");	
					}
			else if(converter.getTo().equalsIgnoreCase("kwd")) {
				total=converter.getAmount()*0.32249897;
				m.addAttribute("msg", converter.getAmount()+ " Euro ="+ total +" KWD");	
				}
			else if(converter.getTo().equalsIgnoreCase("uae")) {
				total=converter.getAmount()*3.8634136;
				m.addAttribute("msg", converter.getAmount()+ " Euro ="+ total +" AED");	
				}
			m.addAttribute("date","Present Date And Time ::"+date);
			return "convert";
		}
		else if(converter.getFrom().equalsIgnoreCase("kwd")) {
			
			if(converter.getTo().equalsIgnoreCase("rupee")) {
					total=converter.getAmount()*252.0144;
					m.addAttribute("msg", converter.getAmount()+ " KWD ="+ total +" INR");	
					}
			else if(converter.getTo().equalsIgnoreCase("euro")) {
					total=converter.getAmount()*3.10082;
					m.addAttribute("msg", converter.getAmount()+ " KWD ="+ total +" Euro");	
					}
			else if(converter.getTo().equalsIgnoreCase("us")) {
				total=converter.getAmount()*3.26254;
				m.addAttribute("msg", converter.getAmount()+ " KWD ="+ total +" USD");	
				}
			else if(converter.getTo().equalsIgnoreCase("uae")) {
				total=converter.getAmount()*11.981256;
				m.addAttribute("msg", converter.getAmount()+ " KWD ="+ total +" AED");	
			}
			m.addAttribute("date","Present Date And Time ::"+date);
			return "convert";
		}
		else if(converter.getFrom().equalsIgnoreCase("uae")) {
			
			if(converter.getTo().equalsIgnoreCase("rupee")) {
					total=converter.getAmount()*21.1472;
					m.addAttribute("msg", converter.getAmount()+ " AED ="+ total +" INR");	
					}
			else if(converter.getTo().equalsIgnoreCase("euro")) {
					total=converter.getAmount()* 0.258838;
					m.addAttribute("msg", converter.getAmount()+ " AED ="+ total +" Euro");
					}
			else if(converter.getTo().equalsIgnoreCase("kwd")) {
				total=converter.getAmount()*0.0834637;
				m.addAttribute("msg", converter.getAmount()+ " AED ="+ total +" KWD");
				}
			else if(converter.getTo().equalsIgnoreCase("us")) {
				total=converter.getAmount()* 0.272294;
				m.addAttribute("msg", converter.getAmount()+ " AED ="+ total +" USD");
				}
			m.addAttribute("date","Present Date And Time ::"+date);
			return "convert";
		}
		return "convert";
	}
}
