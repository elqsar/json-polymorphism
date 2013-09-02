package cz.boris.json;

import static org.fest.assertions.Assertions.assertThat;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.junit.Test;

public class JacksonInheritanceTest extends AbstractJsonTest {

	@Test
	public void serializationTest() throws JsonGenerationException,
			JsonMappingException, IOException {
		
		ObjectMapper om = new ObjectMapper();
		// serialize
		om.writerWithType(new TypeReference<List<Product>>() {
		}).writeValue(new File("products.json"), products);
		// deserialize
		List<Product> result = om.reader(new TypeReference<List<Product>>() {
		}).readValue(new File("products.json"));
		// result
		assertThat(result).isNotEmpty();
		assertThat(result).hasSize(2);
		assertThat(result.get(0)).isInstanceOf(CreditCard.class);
		assertThat(result.get(1)).isInstanceOf(Deposit.class);
	}
}
