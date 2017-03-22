import java.math.BigDecimal;

public class Problem10_21 {

	// FINISHED
	// (Divisible by 5 or 6)
	public static void main(String[] args) {
		
		BigDecimal number = new BigDecimal(Long.MAX_VALUE).add(BigDecimal.ONE);
		int x = 0;
		
		while (x < 10) {
			if (number.remainder(new BigDecimal(5)).equals(BigDecimal.ZERO) ||
				number.remainder(new BigDecimal(6)).equals(BigDecimal.ZERO)) {
				
				System.out.println(number);
				x++;
			}	
			number = number.add(BigDecimal.ONE);
		}

	}

}
