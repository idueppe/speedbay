package io.crowdcode.speedbay.product.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.crowdcode.speedbay.product.ProductSpringApplication;
import io.crowdcode.speedbay.product.model.Product;
import io.crowdcode.speedbay.product.service.ProductService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Ingo Düppe (Crowdcode)
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(ProductSpringApplication.class)
@WebAppConfiguration
//@DirtiesContext
@Configuration
public class ProductControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    @InjectMocks
    private ProductController productController;

    @Mock
    @Autowired
    private ProductService productService;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
        System.out.println(productController);
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateProduct() throws Exception {
        Long fixedUUID = 1L;
        Product product = defaultProduct(fixedUUID);
        String jsonProduct = asJsonString(product);

        when(productService.registerProduct(Mockito.any(), Mockito.any())).thenReturn(fixedUUID);

        mockMvc.perform(
                post("/products")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .accept(MediaType.APPLICATION_JSON_UTF8)
                        .content(jsonProduct))
                .andDo(print())
                .andExpect(status().isCreated())
              .andExpect(header().string("location", containsString("/"+fixedUUID)));

        verify(productService, times(1)).registerProduct("Name", "description");

    }

    @Test
    public void testJsonString() throws Exception {
        assertThat(asJsonString(defaultProduct(1l)), containsString("1"));
    }

    private Product defaultProduct(Long id) {
        return new Product()
                .withId(id)
                .withName("Name")
                .withDescription("description");
    }

    private String asJsonString(Object value) throws JsonProcessingException {
        String json = objectMapper.writeValueAsString(value);
        System.out.println(json);
        return json;
    }



}