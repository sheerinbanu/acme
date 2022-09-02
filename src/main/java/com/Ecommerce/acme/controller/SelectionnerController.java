package com.Ecommerce.acme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.Ecommerce.acme.service.SelectionnerService;

@Controller
public class SelectionnerController {

	@Autowired
	private SelectionnerService ss;
}
