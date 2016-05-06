//
// Ce fichier a �t� g�n�r� par l'impl�mentation de r�f�rence JavaTM Architecture for XML Binding (JAXB), v2.2.8-b130911.1802 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apport�e � ce fichier sera perdue lors de la recompilation du sch�ma source. 
// G�n�r� le : 2016.03.29 � 12:51:49 AM CEST 
//


package model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import Schema.Command;


/**
 * <p>Classe Java pour partie complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="partie">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="scoreTable" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *         &lt;element name="round" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *         &lt;element name="admin" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="max_player" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="open" type="{http://www.w3.org/2001/XMLSchema}boolean" default="true" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "partie", propOrder = {
    "scoreTable",
    "round",
    "admin"
})
public class Partie
    extends Command
{

    @XmlElement(required = true)
    protected List<String> scoreTable;
    @XmlElement(required = true)
    protected List<String> round;
    @XmlElement(required = true)
    protected String admin;
    @XmlAttribute(name = "id")
    protected Integer id;
    @XmlAttribute(name = "name")
    protected String name;
    @XmlAttribute(name = "max_player")
    protected Integer maxPlayer;
    @XmlAttribute(name = "open")
    protected Boolean open;

    /**
     * Gets the value of the scoreTable property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the scoreTable property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getScoreTable().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getScoreTable() {
        if (scoreTable == null) {
            scoreTable = new ArrayList<String>();
        }
        return this.scoreTable;
    }

    /**
     * Gets the value of the round property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the round property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRound().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getRound() {
        if (round == null) {
            round = new ArrayList<String>();
        }
        return this.round;
    }

    /**
     * Obtient la valeur de la propri�t� admin.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdmin() {
        return admin;
    }

    /**
     * D�finit la valeur de la propri�t� admin.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdmin(String value) {
        this.admin = value;
    }

    /**
     * Obtient la valeur de la propri�t� id.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getId() {
        return id;
    }

    /**
     * D�finit la valeur de la propri�t� id.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setId(Integer value) {
        this.id = value;
    }

    /**
     * Obtient la valeur de la propri�t� name.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * D�finit la valeur de la propri�t� name.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Obtient la valeur de la propri�t� maxPlayer.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaxPlayer() {
        return maxPlayer;
    }

    /**
     * D�finit la valeur de la propri�t� maxPlayer.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaxPlayer(Integer value) {
        this.maxPlayer = value;
    }

    /**
     * Obtient la valeur de la propri�t� open.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isOpen() {
        if (open == null) {
            return true;
        } else {
            return open;
        }
    }

    /**
     * D�finit la valeur de la propri�t� open.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setOpen(Boolean value) {
        this.open = value;
    }

}
