package com.taras.hotelsitebev2.services;

import com.taras.hotelsitebev2.converters.PaymentMethodToPaymentMethodDto;
import com.taras.hotelsitebev2.converters.RBPaymentMethodDtoToPaymentMethod;
import com.taras.hotelsitebev2.dtos.DtoInterface;
import com.taras.hotelsitebev2.dtos.paymentmethod.RequestBodyPaymentMethodDto;
import com.taras.hotelsitebev2.exceptions.NotFoundException;
import com.taras.hotelsitebev2.model.PaymentMethod;
import com.taras.hotelsitebev2.repos.PaymentMethodRepo;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PaymentMethodService implements ServiceInterface {

    private final PaymentMethodRepo paymentMethodRepo;
    private final PaymentMethodToPaymentMethodDto paymentMethodToPaymentMethodDto;
    private final RBPaymentMethodDtoToPaymentMethod rbPaymentMethodDtoToPaymentMethod;

    public PaymentMethodService(PaymentMethodRepo paymentMethodRepo, PaymentMethodToPaymentMethodDto paymentMethodToPaymentMethodDto,
                                RBPaymentMethodDtoToPaymentMethod rbPaymentMethodDtoToPaymentMethod) {
        this.paymentMethodRepo = paymentMethodRepo;
        this.paymentMethodToPaymentMethodDto = paymentMethodToPaymentMethodDto;
        this.rbPaymentMethodDtoToPaymentMethod = rbPaymentMethodDtoToPaymentMethod;
    }

    @Override
    public Map<String, List<DtoInterface>> getList() {

        List<DtoInterface> paymentMethodItems;
        Map <String, List<DtoInterface>> response = new HashMap<>();

        paymentMethodItems = StreamSupport.stream(paymentMethodRepo.findAll()
                        .spliterator(),false)
                .map(paymentMethodToPaymentMethodDto::convert)
                .collect(Collectors.toList());
        response.put("paymentMethods", paymentMethodItems);
        return response;
    }

    @Override
    public Map<String, DtoInterface> getById(Integer id) {

        PaymentMethod paymentMethod = paymentMethodRepo.findById(id).orElseThrow(() -> new NotFoundException("Typo de pago no encontrado - " + id));
        Map<String, DtoInterface> response = new HashMap<>();
        response.put("paymentMethod", paymentMethodToPaymentMethodDto.convert(paymentMethod));
        return response;
    }

    @Override
    public void save(DtoInterface dto) {
        RequestBodyPaymentMethodDto requestBodyPaymentMethodDto = (RequestBodyPaymentMethodDto) dto;
        paymentMethodRepo.save(rbPaymentMethodDtoToPaymentMethod.convert(requestBodyPaymentMethodDto));

    }

    @Override
    public void delete(Integer id) {

        paymentMethodRepo.deleteById(id);
    }

    @Override
    public void update(Integer id, DtoInterface dto) {
        RequestBodyPaymentMethodDto requestBodyPaymentMethodDto = (RequestBodyPaymentMethodDto) dto;
        PaymentMethod updatedPM = rbPaymentMethodDtoToPaymentMethod.convert(requestBodyPaymentMethodDto);
        PaymentMethod updatingPM = paymentMethodRepo.findById(id).orElseThrow(() -> new NotFoundException("Typo de pago no encontrado - " + id));

        updatingPM.setPaymentType(updatedPM.getPaymentType());

        paymentMethodRepo.save(updatingPM);

    }
}
