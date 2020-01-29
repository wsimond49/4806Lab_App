package access;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import access.addressbook.BuddyInfo;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "buddy", path = "buddy")
public interface BuddyInfoRepository extends CrudRepository<BuddyInfo, Long> {
    List<BuddyInfo> findByName(String Name);

    BuddyInfo findById(long id);
}
