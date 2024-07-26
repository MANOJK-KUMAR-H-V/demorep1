package com.Whatsapp.services;

import java.util.List;

import com.Whatsapp.dao.WhasappDAO;
import com.Whatsapp.dao.WhatsappDAOInterface;
import com.Whatsapp.entity.WhatsappUser;

public class WhatsappServices implements WhatsappServicesInterface {

	@Override
	public int createProfileService(WhatsappUser wu) {
		
		WhatsappDAOInterface  wDAO = new WhasappDAO();
		
		int i =wDAO.createProfileDAO(wu);
		
		
		
		return i ;
	}

	@Override
	public WhatsappUser viewProfileServices(WhatsappUser wu) {
		
		WhatsappDAOInterface wd = new WhasappDAO();
		WhatsappUser w1 =wd.viewProfileDAO(wu);
		
		
		return w1;
	}

	@Override
	public List<WhatsappUser> viewAllProfileServices() {
		WhatsappDAOInterface wd = new WhasappDAO();
		List<WhatsappUser> list  =wd.viewAllProfileDAO();
		return list;
	}

}
