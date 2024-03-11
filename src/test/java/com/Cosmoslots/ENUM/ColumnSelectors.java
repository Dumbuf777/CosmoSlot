package com.Cosmoslots.ENUM;

public enum ColumnSelectors {
	    CURRENT_TOKENS("//th[contains(text(),'Current Tokens')]//following::tbody//td[contains(@class,'currentTokens-sweepTokens')]"),
	    REDEEMABLE_TOKEN("//th[contains(text(),'Redeemable Tokens')]//following::tbody//td[contains(@class,'withdrawableTokens-sweepTokens')]"),
	    SWEEP_TOKEN("//th[contains(text(),'Sweep Token')]//following::tbody//td[contains(@class,'sweepTokens')]"),
	    GAME_TOKEN("//th[contains(text(),'Game Token')]//following::tbody//td[contains(@class,'gameTokens')]"),
	    AMOUNT("//th[contains(text(),'Amount(USD)')]//following::tbody//td[contains(@class,'amount')]"),
	    AMOUNT_RECEIVED("//th[contains(text(),'Amount Received')]//following::tbody//td[contains(@class,'amount')]"),
	    DEPOSIT("//th[contains(text(),'Deposit')]//following::tbody//td[contains(@class,'deposit')]"),
	    WITHDRAW("//th[contains(text(),'Withdraw')]//following::tbody//td[contains(@class,'withdraw')]"),
	    BET_AMOUNT("//th[contains(text(),'Bet Amount')]//following::tbody//td[contains(@class,'totalBet')]"),
	    WINNING_AMOUNT("//th[contains(text(),'Winning Amount')]//following::tbody//td[contains(@class,'totalWin')]"),
	    PACKAGE_AMOUNT("//th[contains(text(),'Package Amount')]//following::tbody//td[contains(@class,'originalAmount')]"),
	    PKG_DISCOUNT_AMOUNT("//th[contains(text(),'Package Discounted Amount')]//following::tbody//td[contains(@class,'packagediscountedPercentage')]"),
	    DISCOUNTED_AMOUNT("//th[contains(text(),'Discounted Amount($)')]//following::tbody//td[contains(@class,'discountAmount')]"),
	    EXTRA_ST("//th[contains(text(),'Extra Sweep Tokens')]//following::tbody//td[contains(@class,'extraSweepToken')]"),
	    CURRENT_PIGGY("//th[contains(text(),'Current Piggy')]//following::tbody//td[contains(@class,'piggyTokens')]"),
	    JACKPOT_INITIAL_VALUE("//th[contains(text(),'Jackpot Initial Value')]//following::tbody//td[contains(@class,'jackpotInitialValue')]"),
	     ST("//th[contains(text(),'Sweep Tokens')]//following::tbody//td[contains(@class,'sweepToken')]"),
		 GT("//th[contains(text(),'Game Tokens')]//following::tbody//td[contains(@class,'gameToken')]")	,
		 Wallet_Amount("//th[contains(.,'Amount(USD)')]//following::tbody//td[contains(@class,'amount')]"),
		 Status_Pending("(//span[contains(.,'Pending')])[1]"),
		 Status_Success("(//span[contains(.,'Success')])[1]"),
		 Status_Declined("(//span[contains(.,'Declined')])[1]"),
		 PaperTransactionStatus("(//td[text()=' PayPer']//following::td[contains(.,' Success')])[1]");    
	    private final String xpath;

	    private ColumnSelectors(String xpath) {
	        this.xpath = xpath;
	    }

	    public String getColumnValues() {
	        return xpath;
	    }
	

}
