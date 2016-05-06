//
// Ce fichier a �t� g�n�r� par l'impl�mentation de r�f�rence JavaTM Architecture for XML Binding (JAXB), v2.2.8-b130911.1802 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apport�e � ce fichier sera perdue lors de la recompilation du sch�ma source. 
// G�n�r� le : 2016.03.29 � 12:51:49 AM CEST 
//


package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import Schema.Command;


/**
 * <p>Classe Java pour response complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="response">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="urlSource" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="urlDestination" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="messageID" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "response")
@XmlSeeAlso({
    ResponseAuthentifier.class,
    ResponseCreerPartie.class,
    ResponseListePartie.class,
    ResponseConsulterStats.class,
    ResponseArreterLancerDes.class,
    ResponseCreerCompte.class,
    ResponseRejoindrePartie.class
})
public class Response
    extends Command
{

    @XmlAttribute(name = "urlSource")
    protected String urlSource;
    @XmlAttribute(name = "urlDestination")
    protected String urlDestination;
    @XmlAttribute(name = "messageID")
    protected String messageID;

    /**
     * Obtient la valeur de la propri�t� urlSource.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUrlSource() {
        return urlSource;
    }

    /**
     * D�finit la valeur de la propri�t� urlSource.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUrlSource(String value) {
        this.urlSource = value;
    }

    /**
     * Obtient la valeur de la propri�t� urlDestination.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUrlDestination() {
        return urlDestination;
    }

    /**
     * D�finit la valeur de la propri�t� urlDestination.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUrlDestination(String value) {
        this.urlDestination = value;
    }

    /**
     * Obtient la valeur de la propri�t� messageID.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessageID() {
        return messageID;
    }

    /**
     * D�finit la valeur de la propri�t� messageID.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessageID(String value) {
        this.messageID = value;
    }

}
