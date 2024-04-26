package enumaration;

public enum MessageEnum {

	INVALID_EMPTY_FIRM_NAME("Firm name cannot be empty"),
	DUPLICATE_ENTRY_FIRM_NAME("Duplicate Firm name: "),
	INVALID_ALPHANUMERICAL_FIRM_NAME("Firm name must be Alphanumeric or &");

	private final String message;

	MessageEnum(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}