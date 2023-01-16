
package com.mx.mex.Webservices.Soap.com.praxis.fact.broker.ws.com.praxis.fact.broker.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para integracEgresos complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="integracEgresos">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="conceptoS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "integracEgresos", propOrder = {
    "conceptoS"
})
public class IntegracEgresos {

    protected String conceptoS;

    /**
     * Obtiene el valor de la propiedad conceptoS.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConceptoS() {
        return conceptoS;
    }

    /**
     * Define el valor de la propiedad conceptoS.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConceptoS(String value) {
        this.conceptoS = value;
    }

}
