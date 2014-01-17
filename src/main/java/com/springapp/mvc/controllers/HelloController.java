package com.springapp.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springapp.dao.contact.pojo.Contact;
import com.springapp.services.Contact.ContactService;

import org.springframework.web.bind.annotation.ResponseBody;

import com.springapp.dao.contact.pojo.Contact;

import java.util.List;
//import com.springapp.model.Shop;

@Controller
@RequestMapping("/")
public class HelloController {
    //Logger log = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private ContactService contactService;

	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		model.addAttribute("message", "Hello world!");
        //System.out.println("Hello World");
        //log.info("I am here");
		return "hello";
	}


//    @RequestMapping(value = "/json/{name}", method = RequestMethod.GET)
//    public @ResponseBody
//    Shop getShopInJSON(@PathVariable String name) {
//
//        Shop shop = new Shop();
//        shop.setName(name);
//        shop.setStaffName(new String[]{"mkyong1", "mkyong2"});
//
//        return shop;
//    }


    @RequestMapping(value = "contacts", method = RequestMethod.GET)
    public @ResponseBody
    List<Contact> getContacts() {
        List<Contact> contactLst = contactService.listContact();

        return contactLst;
    }


    @RequestMapping(value = "dao/test", method = RequestMethod.GET)
    public String printInsert(ModelMap model) {
        Contact contact = new Contact("Zaid", "Emeish", "zomaish@gmail.com", "123431");

        contactService.addContact(contact);
        model.addAttribute("message", "Saved");
        return "hello";
    }

}