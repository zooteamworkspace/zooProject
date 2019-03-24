package com.zoo.zooApplication.service.impl;

<<<<<<< HEAD:zooApplication/src/main/java/com/zoo/zooApplication/service/impl/BookingServiceImpl.java
import com.zoo.zooApplication.converter.FieldBookingDOToResponseConverter;
import com.zoo.zooApplication.dao.model.FieldBookingDO;
import com.zoo.zooApplication.dao.repository.FieldBookingRepository;
import com.zoo.zooApplication.request.CreateBookingRequest;
import com.zoo.zooApplication.response.FieldBooking;
import com.zoo.zooApplication.service.BookingService;
=======
import com.zoo.bookingService.converter.FieldBookingDOToResponseConverter;
import com.zoo.bookingService.dao.model.FieldBookingDO;
import com.zoo.bookingService.dao.repository.FieldBookingRepository;
import com.zoo.bookingService.response.FieldBooking;
import com.zoo.bookingService.service.BookingService;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
>>>>>>> find booking by field ID with pagination:bookingService/src/main/java/com/zoo/bookingService/service/impl/BookingServiceImpl.java
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {

    private FieldBookingRepository fieldBookingRepository;

    private FieldBookingDOToResponseConverter fieldBookingDOToResponseConverter;

    @Inject
    public BookingServiceImpl(FieldBookingRepository fieldBookingRepository, FieldBookingDOToResponseConverter fieldBookingDOToResponseConverter) {
        this.fieldBookingRepository = fieldBookingRepository;
        this.fieldBookingDOToResponseConverter = fieldBookingDOToResponseConverter;
    }

    @Override
    public FieldBooking findBookingById(long bookingId) {
        Optional<FieldBookingDO> fieldBookingDO = fieldBookingRepository.findById(bookingId);
        FieldBooking fieldBooking = null;
        if (fieldBookingDO.isPresent()) {
            fieldBooking = fieldBookingDOToResponseConverter.convert(fieldBookingDO.get());
        }
        return fieldBooking;
    }

    @Override
<<<<<<< HEAD:zooApplication/src/main/java/com/zoo/zooApplication/service/impl/BookingServiceImpl.java
    public FieldBooking createBooking(CreateBookingRequest bookingRequest) {
        return FieldBooking.builder().id(123).build();
=======
    public List<FieldBooking> findAllBookingByFieldId(long fieldId, Pageable pageable){
        FieldBookingDO fieldBookingDO = new FieldBookingDO();
        fieldBookingDO.setFieldId(fieldId);
        Example<FieldBookingDO> exampleBookingDO = Example.of(fieldBookingDO);
        Page<FieldBookingDO> listFieldBookingDO = fieldBookingRepository.findAll(exampleBookingDO,pageable);
        List<FieldBooking> listFieldBooking = new ArrayList<>();
        for (FieldBookingDO fieldbookingDO:listFieldBookingDO){
            FieldBooking fieldBooking = fieldBookingDOToResponseConverter.convert(fieldbookingDO);
            listFieldBooking.add(fieldBooking);
        }
        return listFieldBooking;
>>>>>>> find booking by field ID with pagination:bookingService/src/main/java/com/zoo/bookingService/service/impl/BookingServiceImpl.java
    }
}
