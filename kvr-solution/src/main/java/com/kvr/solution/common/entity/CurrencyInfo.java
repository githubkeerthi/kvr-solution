package com.kvr.solution.common.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CurrencyInfo {

	/*Base Currency Symbol*/
	//private String currencySymbol;
	/* Formal Name: INR (India Rupees) */
	//private String fromalName;
	/* Suffix Symbol to Amount: No/Yes */
	private String currencySuffixSymbol;
	/* Add spaces between the amount and symbol: Yes/No */
	private String spaceBtwnAmtAndSymbol;
	/* Show amount in Millions: Yes/No */
	//private boolean amountInMillions;
	/* Number of decimal Places: 2 */
	private int numberOfDecimals;
	/* Word representing amount after decimal: Paisa */
	//private String amountAfterDecimal;
	/* No of decimal places for amount in words: 2 */
	private int amountWordsAfterDecimal;
}
