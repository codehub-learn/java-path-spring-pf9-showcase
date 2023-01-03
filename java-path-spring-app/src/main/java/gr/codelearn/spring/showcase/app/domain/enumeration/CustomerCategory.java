package gr.codelearn.spring.showcase.app.domain.enumeration;

public enum CustomerCategory {
	INDIVIDUAL(0.1f),
	BUSINESS(0.2f),
	GOVERNMENT(0.5f);

	private final float discount;

	CustomerCategory(float discount) {
		this.discount = discount;
	}

	public float getDiscount() {
		return this.discount;
	}
}
