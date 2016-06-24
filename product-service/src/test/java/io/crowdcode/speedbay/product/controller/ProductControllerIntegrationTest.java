package io.crowdcode.speedbay.product.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.crowdcode.speedbay.product.ProductSpringApplication;
import io.crowdcode.speedbay.product.fixture.ProductFixture;
import io.crowdcode.speedbay.product.model.Product;
import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.crowdcode.speedbay.common.AnsiColor.green;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
//import static io.crowdcode.speedbay

/**
 * @author Ingo Düppe (Crowdcode)
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(ProductSpringApplication.class)
@WebIntegrationTest(randomPort = true)
public class ProductControllerIntegrationTest {


    private static final Logger log = LoggerFactory.getLogger(ProductControllerIntegrationTest.class);

    @Autowired
    private ObjectMapper objectMapper;

    @Value("${local.server.port}")
    private int port;

    @Value("${server.context-path}")
    private String contextPath;

    private String serverUrl;

    @Before
    public void setUp() throws Exception {
        serverUrl = "http://localhost:"+port+contextPath+"/api/products";
        log.info(green("Server is available under {}"), serverUrl);

    }

    public RestTemplate createRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        List<HttpMessageConverter<?>> converters = new ArrayList<>();
        MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
        jsonConverter.setObjectMapper(objectMapper);
        converters.add(jsonConverter);
        restTemplate.setMessageConverters(converters);
        return restTemplate;
    }

    @Test
    public void testGetRequest() throws Exception {

        RestTemplate restTemplate = createRestTemplate();

        ResponseEntity<Void> response = restTemplate.postForEntity(serverUrl,
                ProductFixture.defaultProduct(ProductFixture.uuid()), Void.class);


        MatcherAssert.assertThat(response.getStatusCode(), is(equalTo(HttpStatus.CREATED)));
        String location = response.getHeaders().getFirst("location");

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON_UTF8));
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        HttpEntity<Void> entity = new HttpEntity<>(headers);

        ResponseEntity<Product> responseProduct = restTemplate.exchange(location
                , HttpMethod.GET, entity, Product.class);

        log.info(String.valueOf(responseProduct.getBody()));

    }


}