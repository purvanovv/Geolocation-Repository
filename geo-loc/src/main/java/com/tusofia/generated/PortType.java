//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.11.09 at 05:10:51 PM EET 
//


package com.tusofia.generated;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PortType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PortType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="fastest"/>
 *     &lt;enumeration value="shortest"/>
 *     &lt;enumeration value="pedestrian"/>
 *     &lt;enumeration value="multimodal"/>
 *     &lt;enumeration value="bicycle"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PortType")
@XmlEnum
public enum PortType {

    @XmlEnumValue("fastest")
    FASTEST("fastest"),
    @XmlEnumValue("shortest")
    SHORTEST("shortest"),
    @XmlEnumValue("pedestrian")
    PEDESTRIAN("pedestrian"),
    @XmlEnumValue("multimodal")
    MULTIMODAL("multimodal"),
    @XmlEnumValue("bicycle")
    BICYCLE("bicycle");
    private final String value;

    PortType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PortType fromValue(String v) {
        for (PortType c: PortType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
