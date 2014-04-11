package base;

public enum BigO {
	CONSTANT("Constant", "O(1)"),
	DOUBLE_LOGARITHMIC("Double Logarithmic", "O(log log n)"),
	LOGARITHMIC("Logarithmic", "O(log n)"),
	FRACTIONAL_POWER("Fractional Power", "O(n^c), 0<c<1"),
	LINEAR("Linear", "O(n)"),
	N_LOG_STAR_N("n log-star n", "O(n log* n"),
	LINEARITHMIC("Linearithmic", "O(n log n) = O(log n!)"),
	QUADRADIC("Quadradic", "O(n^2)"),
	POLYNOMIAL("Polynomial", "O(n^c), c>1"),
	L_NOTATION("L-notation", "L_n[a,c], 0<a<1 = e^{(c+o(1)) (ln n)^a (ln ln n)^{1-a}}"),
	EXPONENTIAL("Exponential", "O(c^n), c>1"),
	FACTORIAL("Factorial", "O(n!)"),
	UNKNOWN("Unknown", "N/A");

	private String name;
	private String notation;

	private BigO(String name, String notation) {
		this.name = name;
		this.notation = notation;
	}

	public String getName() {
		return name;
	}

	public String getNotation() {
		return notation;
	}
	
	@Override
	public String toString() {
		return name + " [" + notation + "]";
	}

}
