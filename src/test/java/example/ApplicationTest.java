package example;

import example.proto.StatesProto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = WebApp.class)
//@SpringBootTest
@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebApp.class)
@WebAppConfiguration
//@RunWith(SpringRunner.class)
//@SpringBootTest(
//        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
//        classes = Application.class)
//@AutoConfigureMockMvc
//@TestPropertySource(
//        locations = "classpath:application-integrationtest.properties")
public class ApplicationTest {
    @Autowired
    private RestTemplate restTemplate;

    private static final String STATES_URL = "http://localhost:8080/states";

    @Test
    public void whenUsingRestTemplate_thenSucceed() {
        ResponseEntity<StatesProto.States> states = restTemplate.getForEntity(STATES_URL, StatesProto.States.class);

//        assertResponse(course.toString());
//        System.out.println(states.getBody().getModel());
        System.out.println("states>>>>");
        System.out.println(states);
        System.out.println("____");
        System.out.println(states.getHeaders());
//        System.out.println(states.ge);
        System.out.println("____+");
        System.out.println(states.getBody());
//        System.out.println(states.getBody().getStatus());
//        System.out.println(states.getBody().getStatusMessage());
        System.out.println("<<<<states");
//        System.err.println("aaa");
        assertThat(states).isNotNull();
    }
}
