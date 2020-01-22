package access;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import addressbook.BuddyInfo;

public interface BuddyInfoRepository extends CrudRepository<BuddyInfo, Long> {
    List<BuddyInfo> findByName(String Name);

    BuddyInfo findById(long id);
}
