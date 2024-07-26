package com.Whatsapp.utility;

import java.util.Comparator;

import com.Whatsapp.entity.WhatsappUser;

public class SortByAddress implements Comparator<WhatsappUser> {

	

	@Override
	public int compare(WhatsappUser o1, WhatsappUser o2) {
		
		return o1.getAddress().compareTo(o2.getAddress());
		
		 
	}

}
