package com.springapp.dao.contact;

import com.springapp.dao.contact.pojo.Contact;

import java.util.List;



public interface ContactDAO {

    public void addContact(Contact contact);
    public List<Contact> listContact();
    public void removeContact(Integer id);
}