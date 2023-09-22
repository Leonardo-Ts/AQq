package com.aaq.col.clases.xml.link2b;

public class JMLinkMotoContenedor {
	private JMLinkInformacionEmpresa business;

	private JMLinkMotoTransaccion transacction;

	/**
	 * Default Object Constructor Date: Apr 18, 2007 1:00:02 AM Enclosing type:
	 * JMLinkMotoContenedor
	 */
	public JMLinkMotoContenedor() {
		super();
		this.setBusiness(new JMLinkInformacionEmpresa());
		this.setTransacction(new JMLinkMotoTransaccion());
	}

	// **************************************************************//
	// Getters y setters
	// **************************************************************//

	/**
	 * Date: Apr 18, 2007 12:59:57 AM Method: getBusiness Type:
	 * JMLinkMotoContenedor
	 * 
	 * @return The field business
	 */
	public JMLinkInformacionEmpresa getBusiness() {
		return this.business;
	}

	/**
	 * Date: Apr 18, 2007 12:59:57 AM Method: setBusiness Type:
	 * JMLinkMotoContenedor
	 * 
	 * @param business
	 *            the business to set
	 */
	public void setBusiness(JMLinkInformacionEmpresa business) {
		this.business = business;
	}

	/**
	 * Date: Apr 18, 2007 12:59:57 AM Method: getTransacction Type:
	 * JMLinkMotoContenedor
	 * 
	 * @return The field transacction
	 */
	public JMLinkMotoTransaccion getTransacction() {
		return this.transacction;
	}

	/**
	 * Date: Apr 18, 2007 12:59:57 AM Method: setTransacction Type:
	 * JMLinkMotoContenedor
	 * 
	 * @param transacction
	 *            the transacction to set
	 */
	public void setTransacction(JMLinkMotoTransaccion transacction) {
		this.transacction = transacction;
	}

}
