package de.hdm.KontaktSharing.shared.bo;

import java.sql.SQLException;
import java.util.Date;

import java.sql.ResultSet;

/**
 * Realisierung eines exemplarischen Kunden.
 * 
 */

public class Kontakt extends BusinessObject implements TeilbaresObjekt {

	private static final long serialVersionUID = 1L;

	/**
	 * Das Erzeugungsdatum des Kontaktes
	 */
	private Date erzeugungsdatum;

	/**
	 * Das Modufikationsdatum des Kontaktes
	 */
	private Date modifikationsdatum;

	/**
	 * No Argument Constructor
	 */

	public Kontakt() {
		super();
	}

	/**
	 * Auslesen vom Erzeugungsdatum
	 */

	public Date getErzeugungsdatum() {
		return this.erzeugungsdatum;
	}

	/**
	 * Auslesen vom Modifikationsdatum
	 */

	public Date getModifikationsdatum() {
		return this.modifikationsdatum;
	}

	/**
	 * Setzen des Namens.
	 */
	/**
	 * Setzen des Erzeugungsdatum
	 */
	public void setErzeugungsdatum(Date erzeugungsdatum) {
		this.erzeugungsdatum = erzeugungsdatum;
	}

	/**
	 * Setzen des Modifikationsdatum
	 */
	public void setModifikationsdatum(Date modifikationsdatum) {
		this.modifikationsdatum = modifikationsdatum;
	}

}
