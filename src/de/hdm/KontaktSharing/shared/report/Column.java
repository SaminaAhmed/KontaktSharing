package de.hdm.KontaktSharing.shared.report;

import java.io.Serializable;

import de.hdm.KontaktSharing.shared.report.Row;
import de.hdm.KontaktSharing.shared.report.SimpleParagraph;

/**
 * Spalte eines <code>Row</code>-Objekts. <code>Column</code>-Objekte
 * implementieren das <code>Serializable</code>-Interface und können daher als
 * Kopie z.B. vom Server an den Client übertragen werden.
 * 
 * @see Row
 * @author Thies, Ahmed
 */

public class Column implements Serializable{
	

	  /**
	   * 
	   */
	  private static final long serialVersionUID = 1L;

	  /**
	   * Der Wert eines Spaltenobjekts entspricht dem Zelleneintrag einer Tabelle.
	   * In dieser Realisierung handelt es sich um einen einfachen textuellen Wert.
	   */
	  private String value = "";

	  /**
	   * 
	   * 
	   * @see #Column(String)
	   * @see SimpleParagraph#SimpleParagraph()
	   */
	  public Column() {
	  }

	  /**
	   * Konstruktor, der die Angabe eines Werts (Spalteneintrag) erzwingt.
	   * @param s der Wert, der durch das Column-Objekt dargestellt werden soll.
	   * @see #Column()
	   */
	  public Column(String s) {
	    this.value = s;
	  }

	  /**
	   * Auslesen des Spaltenwerts. 
	   * @return der Eintrag als String
	   */
	  public String getValue() {
	    return value;
	  }

	  /**
	   * Überschreiben des aktuellen Spaltenwerts.
	   * @param value neuer Spaltenwert
	   */
	  public void setValue(String value) {
	    this.value = value;
	  }

	  /**
	   * Umwandeln des <code>Column</code>-Objekts in einen String.
	   * 
	   * @see java.lang.Object
	   */
	  @Override
	public String toString() {
	    return this.value;
	  }

}
