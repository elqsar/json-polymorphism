package cz.boris.json;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;

public abstract class AbstractJsonTest {

	protected List<Product> products;

	@Before
	public void setUp() {
		products = new ArrayList<Product>();

		CreditCard cc = new CreditCard();
		cc.setId(1);
		cc.setActive(true);
		cc.setAmount(BigDecimal.TEN);
		cc.setIssuer("Master Card");
		cc.setName("My Card");

		Deposit d = new Deposit();
		d.setId(2);
		d.setName("My Deposit");
		d.setDescription("Some nice deposit");
		d.setInterestRate(BigDecimal.ZERO);

		products.add(cc);
		products.add(d);
	}

	@After
	public void tearDown() {
		products = null;
	}

}
