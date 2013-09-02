package cz.boris.json;

import static org.fest.assertions.Assertions.assertThat;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import cz.boris.gson.typeadapter.RuntimeTypeAdapterFactory;

public class GsonInheritanceTest extends AbstractJsonTest {
	
	@Test
	public void serializationTest() {
		
		// Not a part of GSON, should be added manually
		RuntimeTypeAdapterFactory<Product> adapter = RuntimeTypeAdapterFactory
				.of(Product.class).registerSubtype(CreditCard.class)
				.registerSubtype(Deposit.class);
		Gson gson = new GsonBuilder().registerTypeAdapterFactory(adapter)
				.create();
		Type typetoken = new TypeToken<ArrayList<Product>>() {
		}.getType();
		// serialize
		String data = gson.toJson(products, typetoken);
		// deserialize
		List<Product> result = gson.fromJson(data, typetoken);
		// result
		assertThat(result).isNotEmpty();
		assertThat(result).hasSize(2);
		assertThat(result.get(0)).isInstanceOf(CreditCard.class);
		assertThat(result.get(1)).isInstanceOf(Deposit.class);
	}

}
