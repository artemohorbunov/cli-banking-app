import java.time.LocalDateTime;

public final class Transaction {
	private final LocalDateTime timestamp;
	private final char type; // 'D' (deposit) or 'W' (withdraw)
	private final double amount;
	private final double balanceAfter;

	Transaction(char type, double amount, double balanceAfter) {
		this.timestamp = LocalDateTime.now();
		this.type = validateType(type);
		this.amount = amount;
		this.balanceAfter = balanceAfter;
	}

	private static char validateType(char t) {
		if (t != 'D' && t != 'W')
			throw new IllegalArgumentException("Invalid type");
		return t;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public char getType() {
		return type;
	}

	public double getAmount() {
		return amount;
	}

	public double getBalanceAfter() {
		return balanceAfter;
	}

	@Override
	public String toString() {
		return String.format("%s  %-4s  %10.2f  %10.2f", timestamp, type == 'D' ? "DEPO" : "WITH", amount,
				balanceAfter);
	}

}
