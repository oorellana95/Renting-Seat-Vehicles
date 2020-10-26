package com.mybackend.seat.application.services;

import com.mybackend.seat.application.domain.entities.ClientsEntity;
import com.mybackend.seat.application.domain.entities.LoginsEntity;
import com.mybackend.seat.application.factories.ClientsFactory;
import com.mybackend.seat.application.factories.LoginsFactory;
import com.mybackend.seat.application.models.ClientsModel;
import com.mybackend.seat.application.models.LoginsModel;
import com.mybackend.seat.application.domain.repositories.ClientRepository;
import com.mybackend.seat.application.domain.repositories.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

//--- Service ----------------------------------------------------------
@Service
public class ClientLoginServiceImplementation implements ClientLoginService {

    //--- Repositories & Factories needed ------------------------------
    ClientRepository clientRepository;
    LoginRepository loginRepository;
    LoginsFactory loginsFactory;
    ClientsFactory clientsFactory;

    //--- Constructor --------------------------------------------------
    @Autowired
    public ClientLoginServiceImplementation(ClientRepository clientRepository, LoginRepository loginRepository, LoginsFactory loginsFactory, ClientsFactory clientsFactory) {
        this.clientRepository = clientRepository;
        this.loginRepository = loginRepository;
        this.loginsFactory = loginsFactory;
        this.clientsFactory = clientsFactory;
    }

    //--- Functions ----------------------------------------------------
    @Override
    @Transactional
    public void createClientAndLogin(LoginsModel loginModel) {
        LoginsEntity login = loginsFactory.createEntity(loginModel);
        ClientsEntity client = clientRepository.saveAndFlush(login.getClient());
        login.setClient(client);
        loginRepository.save(login);
    }

    @Override
    @Transactional
    public ClientsModel findClientByUsername(String username) {
        LoginsEntity login = loginRepository.findLoginByUsername(username);
        return clientsFactory.createModel(login.getClient());
    }

}
