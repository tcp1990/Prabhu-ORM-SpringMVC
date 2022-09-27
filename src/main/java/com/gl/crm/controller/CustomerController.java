package com.gl.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gl.crm.model.Customer;
import com.gl.crm.dao.CustomerDao;

@Controller
@RequestMapping("customers")
public class CustomerController {

	@Autowired
	CustomerDao customerDoa;

	@GetMapping("list")
	public String showStudents(Model model) {
		List<Customer> customers = customerDoa.findAll();
		model.addAttribute("customers", customers);
		return "customer-list";
	}

	@GetMapping("showCustomerForm")
	public String showCustomerForm(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "customer-form";
	}

	@PostMapping("save")
	public String saveCustomer(Model model, @ModelAttribute("customer") Customer customer) {
		customerDoa.saveCustomer(customer);
		return "redirect:/customers/list";
	}

	@GetMapping("update")
	public String updateCustomer(Model model, @RequestParam("id") int id) {
		Customer customer = customerDoa.findById(id);
		System.out.println(customer);
		model.addAttribute("customer", customer);
		return "customer-form";
	}

	@GetMapping("delete")
	public String deleteCustomer(Model model, @RequestParam("id") int id) {
		customerDoa.deleteCustomer(id);
		return "redirect:/customers/list";
	}
}
