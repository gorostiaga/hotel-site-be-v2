package com.taras.hotelsitebev2.services;

import com.taras.hotelsitebev2.exceptions.NotFoundException;
import com.taras.hotelsitebev2.model.Booking;
import com.taras.hotelsitebev2.model.QrPayment;
import com.taras.hotelsitebev2.model.QrStatus;
import com.taras.hotelsitebev2.repos.QrPaymentRepo;
import org.springframework.stereotype.Service;

import java.util.Date;

//this service does not implement ServiceInterface
//because it is not  called by a CRUD controller,
//thus,it does not need to implement all the method from ServiceInterface
//however it will have a controller that is used by the bank to notify payments
@Service
public class QrPaymentService {

    private final QrPaymentRepo qrPaymentRepo;
    private final BookingService bookingService;

    public QrPaymentService(QrPaymentRepo qrPaymentRepo, BookingService bookingService) {
        this.qrPaymentRepo = qrPaymentRepo;
        this.bookingService = bookingService;
    }

    public void save (Double bankId, Integer bookingId) {
        Booking booking = bookingService.getBookingById(bookingId);
        QrPayment qrPayment = new QrPayment();
        qrPayment.setIdBank(bankId);
        qrPayment.setCreationDate(new Date());
        qrPayment.setQrStatus(QrStatus.GENERATED);
        qrPayment.setBooking(booking);
        qrPaymentRepo.save(qrPayment);
    }

    public void update (QrPayment qrPayment, QrStatus qrStatus) {
        QrPayment updatedQrPayment = qrPayment;
        updatedQrPayment.setModificationDate(new Date());
        updatedQrPayment.setQrStatus(qrStatus);
        qrPaymentRepo.save(updatedQrPayment);
    }

    public QrPayment getByIdBank (Double idBank){
        return qrPaymentRepo.getQrPaymentByIdBank(idBank).orElseThrow(() -> new NotFoundException("Qr no encontrado " + idBank.toString()));
    }
}
