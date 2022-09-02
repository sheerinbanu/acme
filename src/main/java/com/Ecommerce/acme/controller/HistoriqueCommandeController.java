package com.Ecommerce.acme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.Ecommerce.acme.service.HistoriqueCommandeService;

@Controller
public class HistoriqueCommandeController {
	
	@Autowired
	private HistoriqueCommandeService hcs;
}
