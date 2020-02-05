package access;

import access.web.AddressBookController;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SmokeTest {

    @Autowired
    private AddressBookController controller;

    @Test
    public void contexLoads() throws Exception {
        Assertions.assertThat(controller).isNotNull();
    }
}