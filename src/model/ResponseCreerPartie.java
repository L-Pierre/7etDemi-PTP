//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.8-b130911.1802 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2016.03.29 à 12:51:49 AM CEST 
//


package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour anonymous complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.example.org/presentation2metier}response">
 *       &lt;sequence>
 *         &lt;element name="partie" type="{http://www.example.org/presentation2metier}partie"/>
 *       &lt;/sequence>
 *       &lt;attribute name="ok" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "partie"
})
@XmlRootElement(name = "response-creer-partie")
public class ResponseCreerPartie
    extends Response
{

    @XmlElement(required = true)
    protected Partie partie;
    @XmlAttribute(name = "ok")
    protected Boolean ok;

    /**
     * Obtient la valeur de la propriété partie.
     * 
     * @return
     *     possible object is
     *     {@link Partie }
     *     
     */
    public Partie getPartie() {
        return partie;
    }

    /**
     * Définit la valeur de la propriété partie.
     * 
     * @param value
     *     allowed object is
     *     {@link Partie }
     *     
     */
    public void setPartie(Partie value) {
        this.partie = value;
    }

    /**
     * Obtient la valeur de la propriété ok.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isOk() {
        return ok;
    }

    /**
     * Définit la valeur de la propriété ok.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setOk(Boolean value) {
        this.ok = value;
    }

}
