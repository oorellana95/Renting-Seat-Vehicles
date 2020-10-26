package com.mybackend.seat.application.services;


import com.mybackend.seat.application.models.ClientsModel;
import com.mybackend.seat.application.models.LoginsModel;

//--- Service Interface -------------------------------------------
public interface ClientLoginService {

    void createClientAndLogin(LoginsModel login);

    ClientsModel findClientByUsername(String username);

}
