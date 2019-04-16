package test.mobile.activities;

import org.testng.annotations.DataProvider;

public class MainModel {
	
	private final String baseId = "com.android.calculator2:id/";
	private final String digit0 = "digit_0";
	private final String digit1 = "digit_1";
	private final String digit2 = "digit_2";
	private final String digit3 = "digit_3";
	private final String digit4 = "digit_4";
	private final String digit5 = "digit_5";
	private final String digit6 = "digit_6";
	private final String digit7 = "digit_7";
	private final String digit8 = "digit_8";
	private final String digit9 = "digit_9";
	private final String op_add = "op_add";
	private final String equals = "eq";
	private final String result = "result";
	public String getBaseId() {
		return baseId;
	}
	public String getDigit0() {
		return baseId+digit0;
	}
	public String getDigit1() {
		return baseId+digit1;
	}
	public String getDigit2() {
		return baseId+digit2;
	}
	public String getDigit3() {
		return baseId+digit3;
	}
	public String getDigit4() {
		return baseId+digit4;
	}
	public String getDigit5() {
		return baseId+digit5;
	}
	public String getDigit6() {
		return baseId+digit6;
	}
	public String getDigit7() {
		return baseId+digit7;
	}
	public String getDigit8() {
		return baseId+digit8;
	}
	public String getDigit9() {
		return baseId+digit9;
	}
	public String getOp_add() {
		return baseId+op_add;
	}
	public String getResult() {
		return baseId+result;
	}
	/*
	 * Simplified conversion from number to keyboard operands input - only one digit
	 */
	public String getDigit(String digit) {
		switch(digit) {
			case "0": return getDigit0();
			case "1": return getDigit1();
			case "2": return getDigit2();
			case "3": return getDigit3();
			case "4": return getDigit4();
			case "5": return getDigit5();
			case "6": return getDigit6();
			case "7": return getDigit7();
			case "8": return getDigit8();
			case "9": return getDigit9();
			default: return "0";
		}

	}
	public String getEquals() {
		return baseId+equals;
	}
	
	@DataProvider(name="operands")
	public Object[][] getOperands(){
		String[][] operands = {{"1","1","2"},{"1","2","3"},{"9","9","18"}};		
		return operands;
		
	}

}
