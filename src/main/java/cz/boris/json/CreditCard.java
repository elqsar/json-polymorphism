package cz.boris.json;

import java.math.BigDecimal;

public class CreditCard extends Product {

	private String issuer;
	private boolean active;
	private BigDecimal amount;

	public String getIssuer() {
		return issuer;
	}

	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "CreditCard [issuer=" + issuer + ", active=" + active
				+ ", amount=" + amount + "]";
	}

}
