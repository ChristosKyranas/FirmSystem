package enumaration;

public enum MessageEnum {

	INVALID_EMPTY_FIRM_NAME("Firm name cannot be empty");

	private final String message;

	MessageEnum(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}