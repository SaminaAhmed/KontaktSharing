package de.hdm.KontaktSharing.shared.bo;

/**
 * Realisierung einer exemplarischen Eigenschaftklasse.
 * 
 */

public class Eigenschaft extends BusinessObject {

	private static final long serialVersionUID = 1L;

	/**
	 * Die Bezeichnung der Eigenschaft.
	 */
	private String bezeichnung;

	/**
	 * Typ der Eigenschaft
	 */
	private Typ typ;
	
	/**
	 * 
	 */
	private boolean mehrfach;

	/**
	 * Auslesen der Bezeichnung aus Eigenschaft
	 */
	public String getBezeichnung() {
		return this.bezeichnung;
	}


	/**
	 * Auslesen vom Typ der Eigenschaft
	 */
	public Typ getTyp() {
		return this.typ;
	}
	/**
	 * No Argument Constructor
	 */
	public Eigenschaft() {
	    super();
	  }

	/**
	 * Setzen der Bezeichnung.
	 */
	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}
	
	/**
	 * Setzen des Typs.
	 */
	public void setTyp(Typ typ) {
		this.typ = typ;
	}
	
	public void setTyp(String typ) {
		typ = typ.toLowerCase();
		if(typ.equals("string")) {
			this.typ = Typ.STRING;
		} else if(typ.equals("int")) {
			this.typ = Typ.INT;
		} else if(typ.equals("date")) {
			this.typ = Typ.DATE;
		}
	}


	public boolean isMehrfach() {
		return mehrfach;
	}


	public void setMehrfach(boolean mehrfach) {
		this.mehrfach = mehrfach;
	}

}
