package com.taras.hotelsitebev2.services;

import com.taras.hotelsitebev2.converters.CustomerDtoToCustomer;
import com.taras.hotelsitebev2.converters.CustomerToCustomerDto;
import com.taras.hotelsitebev2.converters.CustomerToCustomerWithBookingsDto;
import com.taras.hotelsitebev2.dtos.DtoInterface;
import com.taras.hotelsitebev2.dtos.customer.CustomerDto;
import com.taras.hotelsitebev2.exceptions.NotFoundException;
import com.taras.hotelsitebev2.model.Customer;
import com.taras.hotelsitebev2.repos.CustomerRepo;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CustomerService implements ServiceInterface{

    private final CustomerRepo customerRepo;
    private final CustomerToCustomerDto customerToCustomerDto;
    private final CustomerToCustomerWithBookingsDto customerToCustomerWithBookingsDto;
    private final CustomerDtoToCustomer customerDtoToCustomer;

    public CustomerService(CustomerRepo customerRepo, CustomerToCustomerDto customerToCustomerDto,
                           CustomerToCustomerWithBookingsDto customerToCustomerWithBookingsDto,
                           CustomerDtoToCustomer customerDtoToCustomer) {
        this.customerRepo = customerRepo;
        this.customerToCustomerDto = customerToCustomerDto;
        this.customerToCustomerWithBookingsDto = customerToCustomerWithBookingsDto;
        this.customerDtoToCustomer = customerDtoToCustomer;
    }

    @Override
    public Map<String, List<DtoInterface>> getList() {

        List<DtoInterface> customerItems;
        Map <String, List<DtoInterface>> response = new HashMap<>();

        customerItems = StreamSupport.stream(customerRepo.findAll()
                        .spliterator(),false)
                .map(customerToCustomerDto::convert)
                .collect(Collectors.toList());

        response.put("customers", customerItems);

        return response;
    }

    @Override
    public Map<String, DtoInterface> getById(Integer id) {
        Customer customer = customerRepo.findById(Integer.toString(id)).orElse(null);
        if (customer == null) {
            throw new NotFoundException("Cliente no registrado - " + id);
        }
        Map<String, DtoInterface> response = new HashMap<>();
        response.put("customer", customerToCustomerWithBookingsDto.convert(customer));
        return response;
    }

    @Override
    public void save(DtoInterface dto) {
        //here we will reuse the CustomerDto, because we need the id from the FE
        CustomerDto customerDto = (CustomerDto) dto;
        customerRepo.save(customerDtoToCustomer.convert(customerDto));

    }

    @Override
    public void delete(Integer id) {
        customerRepo.deleteById(Integer.toString(id));
    }

    @Override
    public void update(Integer id, DtoInterface dto) {
        CustomerDto customerDto = (CustomerDto) dto;
        Customer updatedCustomer = customerDtoToCustomer.convert(customerDto);
        Customer updatingCustomer = customerRepo.findById(Integer.toString(id)).orElse(null);
        if (updatingCustomer == null){
            throw new NotFoundException("Item no se encuentra - " + id);
        }
        updatingCustomer.setIdCustomer(updatedCustomer.getIdCustomer());
        updatingCustomer.setFirstName(updatedCustomer.getFirstName());
        updatingCustomer.setLastName(updatedCustomer.getLastName());
        updatingCustomer.setEmail(updatedCustomer.getEmail());
        updatingCustomer.setPhone(updatedCustomer.getPhone());
        updatingCustomer.setOriginCity(updatedCustomer.getOriginCity());
        customerRepo.save(updatingCustomer);
    }

    public Customer getCustomerById (String id) {
        return customerRepo.findById(id).orElseThrow(()-> new NotFoundException("Usuario no encontrado - " + id));
    }
}
