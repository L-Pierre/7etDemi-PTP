//
// Ce fichier a �t� g�n�r� par l'impl�mentation de r�f�rence JavaTM Architecture for XML Binding (JAXB), v2.2.8-b130911.1802 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apport�e � ce fichier sera perdue lors de la recompilation du sch�ma source. 
// G�n�r� le : 2016.03.29 � 12:20:20 AM CEST 
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
 *     &lt;extension base="{http://www.example.org/presentation2metier}request">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="id_user" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="id_partie" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "lancer-des")
public class LancerDes
    extends Request
{

    @XmlAttribute(name = "id_user")
    protected Integer idUser;
    @XmlAttribute(name = "id_partie")
    protected Integer idPartie;

    /**
     * Obtient la valeur de la propri�t� idUser.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdUser() {
        return idUser;
    }

    /**
     * D�finit la valeur de la propri�t� idUser.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdUser(Integer value) {
        this.idUser = value;
    }

    /**
     * Obtient la valeur de la propri�t� idPartie.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdPartie() {
        return idPartie;
    }

    /**
     * D�finit la valeur de la propri�t� idPartie.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdPartie(Integer value) {
        this.idPartie = value;
    }

}
