package cz.boris.json;

import java.math.BigDecimal;

public class Deposit extends Product {

	private BigDecimal interestRate;
	private String description;

	public BigDecimal getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(BigDecimal interestRate) {
		this.interestRate = interestRate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Deposit [interestRate=" + interestRate + ", description="
				+ description + "]";
	}

}
