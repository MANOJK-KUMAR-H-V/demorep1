package com.Whatsapp.services;

import java.util.List;

import com.Whatsapp.entity.WhatsappUser;

public interface WhatsappServicesInterface {

	int createProfileService(WhatsappUser wu);

	WhatsappUser viewProfileServices(WhatsappUser wu);

	List<WhatsappUser> viewAllProfileServices();

}
