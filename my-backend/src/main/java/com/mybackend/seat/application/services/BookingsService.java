package com.mybackend.seat.application.services;

import com.mybackend.seat.application.models.BookingsModel;
import java.util.List;

//--- Service Interface -------------------------------------------
public interface BookingsService {

    BookingsModel findById(long id);

    List<BookingsModel> findAll();

    void save(BookingsModel model);

    void deleteById(long id);

    void delete(BookingsModel model);

}
