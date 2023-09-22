 package com.aaq.col.clases.xml.link2b;

public class JMLinkMotoTransaccion {
	private String merchant;

	private String reference;

	private String tp_operation;

	private JMLinkMotoTarjeta creditcard;

	private String amount;

	private String currency;

	private String usrtransacction;

	private String version;

	/**
	 * Default Object Constructor Date: Apr 18, 2007 1:04:27 AM Enclosing type:
	 * JMLinkMotoTransaccion
	 */
	public JMLinkMotoTransaccion() {
		super();
	}

	// **************************************************************//
	// Getters y setters
	// **************************************************************//

	/**
	 * Date: Apr 18, 2007 1:03:51 AM Method: getAmount Type:
	 * JMLinkMotoTransaccion
	 * 
	 * @return The field amount
	 */
	public String getAmount() {
		return this.amount;
	}

	/**
	 * Date: Apr 18, 2007 1:03:51 AM Method: setAmount Type:
	 * JMLinkMotoTransaccion
	 * 
	 * @param amount
	 *            the amount to set
	 */
	public void setAmount(final String amount) {
		this.amount = amount;
	}

	/**
	 * Date: Apr 18, 2007 1:03:51 AM Method: getCreditcard Type:
	 * JMLinkMotoTransaccion
	 * 
	 * @return The field creditcard
	 */
	public JMLinkMotoTarjeta getCreditcard() {
		return this.creditcard;
	}

	/**
	 * Date: Apr 18, 2007 1:03:51 AM Method: setCreditcard Type:
	 * JMLinkMotoTransaccion
	 * 
	 * @param creditcard
	 *            the creditcard to set
	 */
	public void setCreditcard(final JMLinkMotoTarjeta creditcard) {
		this.creditcard = creditcard;
	}

	/**
	 * Date: Apr 18, 2007 1:03:51 AM Method: getCurrency Type:
	 * JMLinkMotoTransaccion
	 * 
	 * @return The field currency
	 */
	public String getCurrency() {
		return this.currency;
	}

	/**
	 * Date: Apr 18, 2007 1:03:51 AM Method: setCurrency Type:
	 * JMLinkMotoTransaccion
	 * 
	 * @param currency
	 *            the currency to set
	 */
	public void setCurrency(final String currency) {
		this.currency = currency;
	}

	/**
	 * Date: Apr 18, 2007 1:03:51 AM Method: getMerchant Type:
	 * JMLinkMotoTransaccion
	 * 
	 * @return The field merchant
	 */
	public String getMerchant() {
		return this.merchant;
	}

	/**
	 * Date: Apr 18, 2007 1:03:51 AM Method: setMerchant Type:
	 * JMLinkMotoTransaccion
	 * 
	 * @param merchant
	 *            the merchant to set
	 */
	public void setMerchant(final String merchant) {
		this.merchant = merchant;
	}

	/**
	 * Date: Apr 18, 2007 1:03:51 AM Method: getReference Type:
	 * JMLinkMotoTransaccion
	 * 
	 * @return The field reference
	 */
	public String getReference() {
		return this.reference;
	}

	/**
	 * Date: Apr 18, 2007 1:03:51 AM Method: setReference Type:
	 * JMLinkMotoTransaccion
	 * 
	 * @param reference
	 *            the reference to set
	 */
	public void setReference(final String reference) {
		this.reference = reference;
	}

	/**
	 * Date: Apr 18, 2007 1:03:51 AM Method: getTp_operation Type:
	 * JMLinkMotoTransaccion
	 * 
	 * @return The field tp_operation
	 */
	public String getTp_operation() {
		return this.tp_operation;
	}

	/**
	 * Date: Apr 18, 2007 1:03:51 AM Method: setTp_operation Type:
	 * JMLinkMotoTransaccion
	 * 
	 * @param tp_operation
	 *            the tp_operation to set
	 */
	public void setTp_operation(final String tp_operation) {
		this.tp_operation = tp_operation;
	}

	/**
	 * Jose Miguel Sep 11, 2012 6:47:09 PM
	 * 
	 * @return the usrtransacction
	 */
	public String getUsrtransacction() {
		return this.usrtransacction;
	}

	/**
	 * Jose Miguel Sep 11, 2012 6:47:09 PM
	 * 
	 * @param usrtransacction
	 *            the usrtransacction to set
	 */
	public void setUsrtransacction(final String usrtransacction) {
		this.usrtransacction = usrtransacction;
	}

	/**
	 * Jose Miguel Sep 11, 2012 6:47:09 PM
	 * 
	 * @return the version
	 */
	public String getVersion() {
		return this.version;
	}

	/**
	 * Jose Miguel Sep 11, 2012 6:47:09 PM
	 * 
	 * @param version
	 *            the version to set
	 */
	public void setVersion(final String version) {
		this.version = version;
	}

}
