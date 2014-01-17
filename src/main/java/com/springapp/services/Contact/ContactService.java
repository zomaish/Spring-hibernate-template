package com.springapp.services.Contact;

import java.util.List;

import com.springapp.dao.contact.pojo.Contact;


public interface ContactService {

    public void addContact(Contact contact);
    public List<Contact> listContact();
    public void removeContact(Integer id);
}