package de.hdm.KontaktSharing.shared.report;

import java.util.Vector;

import de.hdm.KontaktSharing.shared.report.*;



/**
 * Ein ReportWriter, der Reports mittels HTML formatiert. Das Ergebnis, was im
 * Zielformat vorliegt, wird in der Variable reportText abgelegt und kann nach
 * Aufruf der entsprechenden Prozessierungsmethode mit getReportText ausgelesen
 * werden
 * 
 * @author Samina
 *
 */

public class HTMLReportWriter extends ReportWriter {

	/**
	 * Diese Variable wird mit dem Ergebnis einer Umwandlung (vgl.
	 * <code>process...</code>-Methoden) belegt. Format: HTML-Text
	 */
	private String reportText = "";

	/**
	 * Zurücksetzen der Variable <code>reportText</code>.
	 */
	public void resetReportText() {
		this.reportText = "";
	}

	/**
	 * Umwandeln eines <code>Paragraph</code>-Objekts in HTML.
	 * 
	 * @param object
	 *            der Paragraph
	 * @return HTML-Text
	 */
	public String paragraph2HTML(Object object) {
		if (object instanceof CompositeParagraph) {
			return this.paragraph2HTML((CompositeParagraph) object);
		} else {
			return this.paragraph2HTML((SimpleParagraph) object);
		}
	}

	/**
	 * Umwandeln eines <code>CompositeParagraph</code>-Objekts in HTML.
	 * 
	 * @param p
	 *            der CompositeParagraph
	 * @return HTML-Text
	 */
	public String paragraph2HTML(CompositeParagraph p) {
		StringBuffer result = new StringBuffer();

		for (int i = 0; i < p.getNumParagraphs(); i++) {
			result.append("<p>" + p.getParagraphAt(i) + "</p>");
		}

		return result.toString();
	}

	/**
	 * Umwandeln eines <code>SimpleParagraph</code>-Objekts in HTML.
	 * 
	 * @param p
	 *            der SimpleParagraph
	 * @return HTML-Text
	 */
	public String paragraph2HTML(SimpleParagraph p) {
		return "<p>" + p.toString() + "</p>";
	}

	/**
	 * HTML-Header-Text produzieren.
	 * 
	 * @return HTML-Text
	 */
	public String getHeader() {
		StringBuffer result = new StringBuffer();

		result.append("<html><head><title></title></head><body>");
		return result.toString();
	}

	/**
	 * HTML-Trailer-Text produzieren.
	 * 
	 * @return HTML-Text
	 */
	public String getTrailer() {
		return "</body></html>";
	}


	/**
	 * Prozessieren des übergebenen Reports und Ablage im Zielformat. Ein Auslesen
	 * des Ergebnisses kann später mittels <code>getReportText()</code> erfolgen.
	 * 
	 * @param r
	 *            der zu prozessierende Report
	 */
	@Override
	public void process(AllKontaktByNutzerReport r) {
		// Zunächst löschen wir das Ergebnis vorhergehender Prozessierungen.
		this.resetReportText();

		/*
		 * In diesen Buffer schreiben wir während der Prozessierung sukzessive unsere
		 * Ergebnisse.
		 */
		StringBuffer result = new StringBuffer();

		/*
		 * Nun werden Schritt für Schritt die einzelnen Bestandteile des Reports
		 * ausgelesen und in HTML-Form übersetzt.
		 */
		result.append("<H1>" + r.getTitle() + "</H1>");
		result.append("<table><tr>");

		if (r.getHeaderData() != null) {
			result.append("<td>" + paragraph2HTML(r.getHeaderData()) + "</td>");
		}

		result.append("<td>" + paragraph2HTML(r.getImprint()) + "</td>");
		result.append("</tr><tr><td></td><td>" + r.getCreated().toString() + "</td></tr></table>");

		/*
		 * Da AllAccountsOfAllCustomersReport ein CompositeReport ist, enthält r eine
		 * Menge von Teil-Reports des Typs AllAccountsOfCustomerReport. Für jeden dieser
		 * Teil-Reports rufen wir processAllAccountsOfCustomerReport auf. Das Ergebnis
		 * des jew. Aufrufs fügen wir dem Buffer hinzu.
		 */
//		for (int i = 0; i < r.getNumSubReports(); i++) {
//			/*
//			 * AllAccountsOfCustomerReport wird als Typ der SubReports vorausgesetzt. Sollte
//			 * dies in einer erweiterten Form des Projekts nicht mehr gelten, so müsste hier
//			 * eine detailliertere Implementierung erfolgen.
//			 */
//			AllAccountsOfCustomerReport subReport = (AllAccountsOfCustomerReport) r.getSubReportAt(i);
//
//			this.process(subReport);
//
//			result.append(this.reportText + "\n");
//
//			/*
//			 * Nach jeder Übersetzung eines Teilreports und anschließendem Auslesen sollte
//			 * die Ergebnisvariable zurückgesetzt werden.
//			 */
//			this.resetReportText();
//		}

		/*
		 * Zum Schluss wird unser Arbeits-Buffer in einen String umgewandelt und der
		 * reportText-Variable zugewiesen. Dadurch wird es möglich, anschließend das
		 * Ergebnis mittels getReportText() auszulesen.
		 */
		this.reportText = result.toString();
	}

	/**
	 * Auslesen des Ergebnisses der zuletzt aufgerufenen Prozessierungsmethode.
	 * 
	 * @return ein String im HTML-Format
	 */
	public String getReportText() {
		return this.getHeader() + this.reportText + this.getTrailer();
	}

}
