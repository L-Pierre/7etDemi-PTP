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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour anonymous complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.example.org/presentation2metier}response">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="nb_partie" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="nb_victoire" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "response-consulter-stats")
public class ResponseConsulterStats
    extends Response
{

    @XmlAttribute(name = "nb_partie")
    protected Integer nbPartie;
    @XmlAttribute(name = "nb_victoire")
    protected Integer nbVictoire;

    /**
     * Obtient la valeur de la propri�t� nbPartie.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNbPartie() {
        return nbPartie;
    }

    /**
     * D�finit la valeur de la propri�t� nbPartie.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNbPartie(Integer value) {
        this.nbPartie = value;
    }

    /**
     * Obtient la valeur de la propri�t� nbVictoire.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNbVictoire() {
        return nbVictoire;
    }

    /**
     * D�finit la valeur de la propri�t� nbVictoire.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNbVictoire(Integer value) {
        this.nbVictoire = value;
    }

}
