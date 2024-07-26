package com.Whatsapp.controller;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.Whatsapp.entity.WhatsappUser;
import com.Whatsapp.services.WhatsappServices;
import com.Whatsapp.services.WhatsappServicesInterface;
import com.Whatsapp.utility.SortByAddress;

public class WhatsappController implements WhatsappControllerInterface {

	@Override
	public void createProfileController() {
		Scanner sc = new Scanner(System.in);

		System.out.println("enter name");
		String name = sc.next();

		System.out.println("enter Password");
		String password = sc.next();
		
		System.out.println("enter Email");
		String email = sc.next();
		
		System.out.println("enter address");
		String address = sc.next();

		//DTO
		WhatsappUser wu = new WhatsappUser();
		wu.setName(name);
		wu.setPassword(password);
		wu.setEmail(email);
		wu.setAddress(address);
		//above object we have to transfer layer,how
		
		WhatsappServicesInterface ws = new WhatsappServices();
		
		int i =ws.createProfileService(wu); 
		if(i>0) {
				System.out.println("profile created");
		}
		else {
				System.out.println("could not create profile");
		}
	}

	@Override
	public void viewProfileController() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("enter mail to see profile");
		String email = sc.next();		
		
		WhatsappUser wu = new WhatsappUser();
		wu.setEmail(email);
		
		WhatsappServicesInterface ws = new WhatsappServices();
		WhatsappUser w1 =ws.viewProfileServices(wu);
		
		if(w1!=null) {
			System.out.println(w1.getName() +" your profile:-  ");
//			System.out.println("            name is "+w1.getName());
			System.out.println("--password is "+w1.getPassword());
			System.out.println("--email is "+w1.getEmail());
			System.out.println("--city is "+w1.getAddress());
			
		}
		
	}

	@Override
	public void createAllProfileController() {
		WhatsappServicesInterface ws = new WhatsappServices();
		List<WhatsappUser> li = ws.viewAllProfileServices();
		
		System.out.println("number  of record found -  "+li.size());
		
		for(WhatsappUser wu : li) {
			System.out.println(wu.getName()+"|"+wu.getEmail()+"|"+wu.getAddress());
		}
		
		Collections.sort(li,new SortByAddress());
//		Collections.reverse(li);
		
		System.out.println("-------------------------------------------");
		
		for(WhatsappUser wu : li) {
			System.out.println(wu.getName()+"|"+wu.getEmail()+"|"+wu.getAddress());
		}
	}

}
















