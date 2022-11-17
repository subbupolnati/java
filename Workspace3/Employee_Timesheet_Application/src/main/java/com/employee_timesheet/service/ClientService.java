package com.employee_timesheet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee_timesheet.exception.NotFoundException;
import com.employee_timesheet.model.Client;
import com.employee_timesheet.repository.ClientRepository;

@Service
public class ClientService {

	@Autowired
	ClientRepository clientRepository;
	//In this method insert new client details and save data into database
	public Client insertClient(Client client) {
		return clientRepository.save(client);
	}
	//In This method getting all client list in database 
	public List<Client> getAllClientList(){
		return clientRepository.findAll();
	}
	//In this method get client details based on clentId
	public Client getClientById(int clientId) {
		//this statement get client based on id if client is not available optional is null
		Client client=clientRepository.findById(clientId).get();
		//if client instance not null execute if block other wise it returns client null;
		if(client!=null)
			return client;
		else
			throw new NotFoundException("client id not found"+clientId);
	}
	//In this method update client details based on clentId
	public Client updateClient(Client client,int clientId) {
		//this statement get client based on id if client is not available optional is null
		Optional<Client> optional=clientRepository.findById(clientId);
		//if optional instance not null execute if block other wise it returns client null;
		if(optional.isPresent()) {
			client.setClientId(clientId);
			return clientRepository.save(client);
		}
		else
			throw new NotFoundException("client id not found"+clientId);
	}
	//In this method delete client based on id
	public void deleteClient(int clientId) {
		clientRepository.deleteById(clientId);
	}
}
