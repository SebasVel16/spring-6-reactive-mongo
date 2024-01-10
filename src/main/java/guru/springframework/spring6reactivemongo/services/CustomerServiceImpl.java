package guru.springframework.spring6reactivemongo.services;

import guru.springframework.spring6reactivemongo.mappers.CustomerMapper;
import guru.springframework.spring6reactivemongo.model.CustomerDTO;
import guru.springframework.spring6reactivemongo.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    public Flux<CustomerDTO> listCustomers() {
        return customerRepository.findAll().map(customerMapper::customerToCustomerDto);
    }

    @Override
    public Mono<CustomerDTO> getCustomerById(String customerId) {
        return customerRepository.findById(customerId).map(customerMapper::customerToCustomerDto);
    }

    @Override
    public Mono<CustomerDTO> saveCustomer(CustomerDTO customerDTO) {
        return customerRepository.save(customerMapper.customerDtoToCustomer(customerDTO)).map(customerMapper::customerToCustomerDto);
    }

    @Override
    public Mono<CustomerDTO> updateCustomer(String id, CustomerDTO customerDTO) {
        return customerRepository.findById(id)
                .map(foundCustomer -> {
                    foundCustomer.setCustomerName(customerDTO.getCustomerName());
                    return foundCustomer;
                }).flatMap(customerRepository::save)
                .map(customerMapper::customerToCustomerDto);
    }

    @Override
    public Mono<Void> deleteCustomer(String customerId) {
        return customerRepository.deleteById(customerId);
    }
}
