package com.Ecommerce.acme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.Ecommerce.acme.service.UtilisateurService;

@Controller
public class UtilisateurController {

	@Autowired
	private UtilisateurService us;
}
