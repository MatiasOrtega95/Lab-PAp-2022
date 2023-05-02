/**
 * DtFechaHora.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package publicadores;

public class DtFechaHora  extends publicadores.DtFecha  implements java.io.Serializable {
    private int MAXHORA;

    private int MINHORA;

    private int MINMIN;

    private int MAXMIN;

    private int MINSEG;

    private int MAXSEG;

    private int hora;

    private int min;

    private int seg;

    public DtFechaHora() {
    }

    public DtFechaHora(
           int MAXANIO,
           int MINANIO,
           int MINMES,
           int MAXMES,
           int MINDIA,
           int MAXDIA,
           int anio,
           int mes,
           int dia,
           int MAXHORA,
           int MINHORA,
           int MINMIN,
           int MAXMIN,
           int MINSEG,
           int MAXSEG,
           int hora,
           int min,
           int seg) {
        super(
            MAXANIO,
            MINANIO,
            MINMES,
            MAXMES,
            MINDIA,
            MAXDIA,
            anio,
            mes,
            dia);
        this.MAXHORA = MAXHORA;
        this.MINHORA = MINHORA;
        this.MINMIN = MINMIN;
        this.MAXMIN = MAXMIN;
        this.MINSEG = MINSEG;
        this.MAXSEG = MAXSEG;
        this.hora = hora;
        this.min = min;
        this.seg = seg;
    }


    /**
     * Gets the MAXHORA value for this DtFechaHora.
     * 
     * @return MAXHORA
     */
    public int getMAXHORA() {
        return MAXHORA;
    }


    /**
     * Sets the MAXHORA value for this DtFechaHora.
     * 
     * @param MAXHORA
     */
    public void setMAXHORA(int MAXHORA) {
        this.MAXHORA = MAXHORA;
    }


    /**
     * Gets the MINHORA value for this DtFechaHora.
     * 
     * @return MINHORA
     */
    public int getMINHORA() {
        return MINHORA;
    }


    /**
     * Sets the MINHORA value for this DtFechaHora.
     * 
     * @param MINHORA
     */
    public void setMINHORA(int MINHORA) {
        this.MINHORA = MINHORA;
    }


    /**
     * Gets the MINMIN value for this DtFechaHora.
     * 
     * @return MINMIN
     */
    public int getMINMIN() {
        return MINMIN;
    }


    /**
     * Sets the MINMIN value for this DtFechaHora.
     * 
     * @param MINMIN
     */
    public void setMINMIN(int MINMIN) {
        this.MINMIN = MINMIN;
    }


    /**
     * Gets the MAXMIN value for this DtFechaHora.
     * 
     * @return MAXMIN
     */
    public int getMAXMIN() {
        return MAXMIN;
    }


    /**
     * Sets the MAXMIN value for this DtFechaHora.
     * 
     * @param MAXMIN
     */
    public void setMAXMIN(int MAXMIN) {
        this.MAXMIN = MAXMIN;
    }


    /**
     * Gets the MINSEG value for this DtFechaHora.
     * 
     * @return MINSEG
     */
    public int getMINSEG() {
        return MINSEG;
    }


    /**
     * Sets the MINSEG value for this DtFechaHora.
     * 
     * @param MINSEG
     */
    public void setMINSEG(int MINSEG) {
        this.MINSEG = MINSEG;
    }


    /**
     * Gets the MAXSEG value for this DtFechaHora.
     * 
     * @return MAXSEG
     */
    public int getMAXSEG() {
        return MAXSEG;
    }


    /**
     * Sets the MAXSEG value for this DtFechaHora.
     * 
     * @param MAXSEG
     */
    public void setMAXSEG(int MAXSEG) {
        this.MAXSEG = MAXSEG;
    }


    /**
     * Gets the hora value for this DtFechaHora.
     * 
     * @return hora
     */
    public int getHora() {
        return hora;
    }


    /**
     * Sets the hora value for this DtFechaHora.
     * 
     * @param hora
     */
    public void setHora(int hora) {
        this.hora = hora;
    }


    /**
     * Gets the min value for this DtFechaHora.
     * 
     * @return min
     */
    public int getMin() {
        return min;
    }


    /**
     * Sets the min value for this DtFechaHora.
     * 
     * @param min
     */
    public void setMin(int min) {
        this.min = min;
    }


    /**
     * Gets the seg value for this DtFechaHora.
     * 
     * @return seg
     */
    public int getSeg() {
        return seg;
    }


    /**
     * Sets the seg value for this DtFechaHora.
     * 
     * @param seg
     */
    public void setSeg(int seg) {
        this.seg = seg;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DtFechaHora)) return false;
        DtFechaHora other = (DtFechaHora) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            this.MAXHORA == other.getMAXHORA() &&
            this.MINHORA == other.getMINHORA() &&
            this.MINMIN == other.getMINMIN() &&
            this.MAXMIN == other.getMAXMIN() &&
            this.MINSEG == other.getMINSEG() &&
            this.MAXSEG == other.getMAXSEG() &&
            this.hora == other.getHora() &&
            this.min == other.getMin() &&
            this.seg == other.getSeg();
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        _hashCode += getMAXHORA();
        _hashCode += getMINHORA();
        _hashCode += getMINMIN();
        _hashCode += getMAXMIN();
        _hashCode += getMINSEG();
        _hashCode += getMAXSEG();
        _hashCode += getHora();
        _hashCode += getMin();
        _hashCode += getSeg();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DtFechaHora.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://publicadores/", "dtFechaHora"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("MAXHORA");
        elemField.setXmlName(new javax.xml.namespace.QName("", "MAXHORA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("MINHORA");
        elemField.setXmlName(new javax.xml.namespace.QName("", "MINHORA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("MINMIN");
        elemField.setXmlName(new javax.xml.namespace.QName("", "MINMIN"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("MAXMIN");
        elemField.setXmlName(new javax.xml.namespace.QName("", "MAXMIN"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("MINSEG");
        elemField.setXmlName(new javax.xml.namespace.QName("", "MINSEG"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("MAXSEG");
        elemField.setXmlName(new javax.xml.namespace.QName("", "MAXSEG"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("hora");
        elemField.setXmlName(new javax.xml.namespace.QName("", "hora"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("min");
        elemField.setXmlName(new javax.xml.namespace.QName("", "min"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("seg");
        elemField.setXmlName(new javax.xml.namespace.QName("", "seg"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
