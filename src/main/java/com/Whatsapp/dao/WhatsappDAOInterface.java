package com.Whatsapp.dao;

import java.util.List;

import com.Whatsapp.entity.WhatsappUser;

public interface WhatsappDAOInterface {

	int createProfileDAO(WhatsappUser wu);

	WhatsappUser viewProfileDAO(WhatsappUser wu);

	List<WhatsappUser> viewAllProfileDAO();

}
