package guru.springframework.spring6reactivemongo.mappers;


import guru.springframework.spring6reactivemongo.domain.Customer;
import guru.springframework.spring6reactivemongo.model.CustomerDTO;
import org.mapstruct.Mapper;

/**
 * Created by jt, Spring Framework Guru.
 */
@Mapper
public interface CustomerMapper {

    CustomerDTO customerToCustomerDto(Customer customer);

    Customer customerDtoToCustomer(CustomerDTO customerDTO);
}
