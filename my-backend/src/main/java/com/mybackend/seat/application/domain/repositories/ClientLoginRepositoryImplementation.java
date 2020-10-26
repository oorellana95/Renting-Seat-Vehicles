package com.mybackend.seat.application.domain.repositories;

import com.mybackend.seat.application.domain.entities.ClientsEntity;
import com.mybackend.seat.application.domain.entities.LoginsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

//--- Repository -------------------------------------------------------
@Repository
public class ClientLoginRepositoryImplementation implements ClientLoginRepository {

    //--- Used Repositories --------------------------------------------
    ClientRepository clientRepository;
    LoginRepository loginRepository;

    //--- Constructor --------------------------------------------------
    @Autowired
    public ClientLoginRepositoryImplementation(ClientRepository clientRepository, LoginRepository loginRepository) {
        this.clientRepository = clientRepository;
        this.loginRepository = loginRepository;
    }

    @Override
    @Transactional
    public void createClientAndLogin(LoginsEntity login) {
            ClientsEntity client = clientRepository.saveAndFlush(login.getClient());
            login.setClient(client);
            loginRepository.save(login);
    }
}