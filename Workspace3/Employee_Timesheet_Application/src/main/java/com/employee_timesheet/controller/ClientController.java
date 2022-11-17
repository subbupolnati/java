package com.employee_timesheet.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.employee_timesheet.model.Client;

import com.employee_timesheet.service.ClientService;

@RestController
@RequestMapping("/v1/timesheet")
public class ClientController {

	@Autowired
	private ClientService clientService;
	//In This url and Method insert new Client. 
	@PostMapping("/client")
	public ResponseEntity<Client> insertClient(@RequestBody Client client) {
		Client c=clientService.insertClient(client);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{clientId}").buildAndExpand(c.getClientId()).toUri();
		return ResponseEntity.created(location).build();
	}
	//In This Url/method getting all Client List
	@GetMapping("/clients")
	public List<Client> fetchAllClients(){
		return clientService.getAllClientList();
	}
	//In This Url/method fetching particular client based on clientid
	@GetMapping("/client/{clientId}")
	public Client fetchClientById(@PathVariable("clientId")int clientId){
		return clientService.getClientById(clientId);
	}
	//In This Url/method update particular client based on clientid
	@PutMapping("/client/{clientId}")
	public Client modifyClientById(@PathVariable("clientId")int clientId,@RequestBody Client client) {
		return clientService.updateClient(client, clientId);
	}
	
	//In This Url/method delete particular client based on clientid
	@DeleteMapping("/client/{clientId}")
	public String deleteClientById(@PathVariable("clientId")int clientId) {
		clientService.deleteClient(clientId);
		return "successfully deleted"+clientId;
	}
	
}
