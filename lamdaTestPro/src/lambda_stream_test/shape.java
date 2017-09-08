package lambda_stream_test;

public class shape {
	static String RED = "red";
	static String ORANGE = "orange";
	static String GREEN = "green";
	static String YELLOW = "yellow";

	private String color;
	private Integer weight;

	public Integer getWeight() {
		return weight;
	}

	public shape setWeight(Integer weight) {
		this.weight = weight;
		return this;
	}

	public String getColor() {
		return color;
	}

	public shape setColor(String color) {
		this.color = color;
		return this;
	}

}
