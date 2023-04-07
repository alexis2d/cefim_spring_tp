package fr.duquenet.alexis.cefimspring;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.duquenet.alexis.cefimspring.classes.Product;
import fr.duquenet.alexis.cefimspring.classes.ProductDto;
import fr.duquenet.alexis.cefimspring.classes.ProductDtoWithCategory;
import fr.duquenet.alexis.cefimspring.feature.database.DatabaseService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CefimspringApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private DatabaseService databaseService;
	@Autowired
	private EntityManager entityManager;
	private Logger logger = LoggerFactory.getLogger(CefimspringApplicationTests.class);

	/*@Test
	void contextLoads() {
	}

	@Test
	void helloWorld() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/hello/world").contentType(MediaType.TEXT_PLAIN_VALUE);
		mockMvc.perform(requestBuilder)
				.andExpect(
						status().isOk()
				).andExpect(
						content().contentTypeCompatibleWith(MediaType.TEXT_PLAIN_VALUE)
				).andExpect(
						content().string("Hello World")
				);
	}
	
	@Test
    void getProductNameListTest() {
        String expected = "Sloe Gin - Mcguinness";
        List<String> results = databaseService.getProductNameList();
        assertTrue(results.contains(expected));
    }

    @Test
    void getProductListTest() {
        String expected = "Sloe Gin - Mcguinness";
        List<ProductDto> results = databaseService.getProductList();
        assertEquals(results.get(0).getName(), expected);
    }

	@Test
	void testProductFromEntity(){
		ProductDto p1 = new ProductDto(1, "Sloe Gin - Mcguinness", "test desc", BigDecimal.valueOf(97.15));
		ProductDto p2 = new ProductDto(2, "Sun - Dried Tomatoes", null, BigDecimal.valueOf(90.36));

		List<Product> listProductFromEntity = databaseService.getListProductFromEntity();
		assertTrue(testEquality(listProductFromEntity.get(0), p1) && testEquality(listProductFromEntity.get(1), p2));
	}

	@Test
	void testGetDriedTomatoes(){
		ProductDto p1 = new ProductDto(2, "Sun - Dried Tomatoes", null, BigDecimal.valueOf(90.36));
		ProductDto oneProduct = databaseService.getOneProduct(p1.getId());
		assert oneProduct.equals(p1);
	}

	@Test
	void testGetDriedTomatoesFromEntity(){
		ProductDto p1 = new ProductDto(2, "Sun - Dried Tomatoes", null, BigDecimal.valueOf(90.36));
		Product oneProduct = databaseService.getOneProductEntity(p1.getId());
		assert testEquality(oneProduct, p1);
	}*/

	boolean testEquality(Product productEntity, ProductDto productDto){
		return Objects.equals(productEntity.getName(), productDto.getName()) && Objects.equals(productEntity.getDescription(), productDto.getDescription())
				&& Objects.equals(BigDecimal.valueOf(productEntity.getPrice()), productDto.getPrice());
	}

	/*@Test
	void testGetTomatoesByName(){
		ProductDto p1 = new ProductDto(1, "Sloe Gin - Mcguinness Tomatoes", "test desc", BigDecimal.valueOf(97.15));
		ProductDto p2 = new ProductDto(2, "Sun - Dried Tomatoes", null, BigDecimal.valueOf(90.36));

		List<ProductDto> listProducts = databaseService.getProductByName("Tomatoes");

		assert listProducts.stream().allMatch(produit -> produit.equals(p1) || produit.equals(p2));
	}

	@Test
	void testGetTomatoesByCategory(){
		ProductDto p1 = new ProductDto(1, "Sloe Gin - Mcguinness Tomatoes", "test desc", BigDecimal.valueOf(97.15));
		ProductDto p2 = new ProductDto(2, "Sun - Dried Tomatoes", null, BigDecimal.valueOf(90.36));

		List<ProductDto> listProducts = databaseService.getProductByCategory("Drink or food");

		assert listProducts.stream().allMatch(product -> product.equals(p1) || product.equals(p2));
	}

	@Test
	void testTomatoesEntitiesByName(){
		ProductDto p1 = new ProductDto(1, "Sloe Gin - Mcguinness Tomatoes", "test desc", BigDecimal.valueOf(97.15));
		ProductDto p2 = new ProductDto(2, "Sun - Dried Tomatoes", null, BigDecimal.valueOf(90.36));

		List<Product> listProducts = databaseService.getProductEntityByName("Tomatoes");

		assert listProducts.stream().allMatch(product -> testEquality(product, p1) || testEquality(product, p2));
	}

	@Test
	void testDrinkOrFoodEntitiesByCategoryName(){
		ProductDto p1 = new ProductDto(1, "Sloe Gin - Mcguinness Tomatoes", "test desc", BigDecimal.valueOf(97.15));
		ProductDto p2 = new ProductDto(2, "Sun - Dried Tomatoes", null, BigDecimal.valueOf(90.36));

		List<Product> listProducts = databaseService.getProductEntityByCategoryName("Drink or food");

		assert listProducts.stream().allMatch(product -> testEquality(product, p1) || testEquality(product, p2));
	}*/

	/*@Test
	void testInsertProduit() throws Exception {
		ProductDtoWithCategory p1 = new ProductDtoWithCategory(0, 1, "burger", "double cheese", BigDecimal.valueOf(10.5));

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/product").content("{\"id_category\": 1,\n" +
				"\"name\": \"burger\",\n" +
				"\"description\" : \"double cheese\",\n" +
				"\"price\": 10.5}").contentType(MediaType.APPLICATION_JSON);

		ResultMatcher resultStatus = MockMvcResultMatchers.status().isOk();

		ResultMatcher resultNameProduct = MockMvcResultMatchers.content().json(new ObjectMapper().writeValueAsString(p1));


		JsonNode contentResponse = new ObjectMapper().readTree(mockMvc.perform(requestBuilder)
				.andExpect(resultStatus)
				.andReturn().getResponse().getContentAsString());


		Assertions.assertEquals("burger", contentResponse.get("name").asText());

	}

	@Test
	void testDeleteProduct() throws Exception{
		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/product/id/29");
		ResultMatcher resultStatus = MockMvcResultMatchers.status().isOk();

		mockMvc.perform(requestBuilder)
				.andExpect(resultStatus);
	}

	@Test
	void testDeleteProductByName() throws Exception{
		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/product/byName?name=burger");
		ResultMatcher resultStatus = MockMvcResultMatchers.status().isOk();

		mockMvc.perform(requestBuilder)
				.andExpect(resultStatus);
	}*/

	/*@Test
	void testUpdateProduct() throws Exception{

		Assertions.assertNull(databaseService.getOneProductById(2).getDescription());

		Map<String, String> listFields = new HashMap<>(){{
			put("description", "console");
			put("name", "Playstation 5");
		}};

		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.put("/api/product/2")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(listFields));
		ResultMatcher resultStatus = MockMvcResultMatchers.status().isOk();

		JsonNode resultat = objectMapper.readTree(mockMvc.perform(requestBuilder)
				.andExpect(resultStatus)
				.andReturn().getResponse().getContentAsString());

		Assertions.assertEquals(resultat.get("description").asText(), listFields.get("description"));
		Assertions.assertEquals(resultat.get("name").asText(), listFields.get("name"));
	}

	@Test
	void testUpdateProductWithWrongId() throws Exception{
		Map<String, String> listFields = new HashMap<>(){{
			put("description", "console");
			put("name", "Playstation 5");
		}};

		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.put("/api/product/10")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(listFields));
		ResultMatcher resultStatus = MockMvcResultMatchers.status().isNotFound();

		mockMvc.perform(requestBuilder)
				.andExpect(resultStatus);
	}

	@Test
	void testUpdateProductWithExistingName() throws Exception{
		Map<String, String> listFields = new HashMap<>(){{
			put("description", "console");
			put("name", "iphone");
		}};

		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.put("/api/product/2")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(listFields));
		ResultMatcher resultStatus = MockMvcResultMatchers.status().isConflict();

		mockMvc.perform(requestBuilder)
				.andExpect(resultStatus);
	}*/



}
