package access;

import access.addressbook.AddressBook;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "address", path = "address")
public interface AddressBookRepository extends CrudRepository<AddressBook, Long> {
    AddressBook findById(long id);
}
