package guru.springframework.spring6reactivemongo.services;


import guru.springframework.spring6reactivemongo.model.CustomerDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerService {

    Flux<CustomerDTO> listCustomers();

    Mono<CustomerDTO> getCustomerById(String customerId);

    Mono<CustomerDTO> saveCustomer(CustomerDTO customerDTO);

    Mono<CustomerDTO> updateCustomer(String id, CustomerDTO customerDTO);

    Mono<Void> deleteCustomer(String customerId);

}
