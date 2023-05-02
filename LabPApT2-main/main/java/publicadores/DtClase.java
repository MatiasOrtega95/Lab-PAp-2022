/**
 * DtClase.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package publicadores;

public class DtClase  implements java.io.Serializable {
    private java.lang.String nombre;

    private publicadores.DtFechaHora fechaInicio;

    private java.lang.String profe;

    private java.lang.String url;

    private publicadores.DtFecha fechaReg;

    private java.lang.String actDep;

    private int cantRegistros;

    private java.lang.String picture;

    public DtClase() {
    }

    public DtClase(
           java.lang.String nombre,
           publicadores.DtFechaHora fechaInicio,
           java.lang.String profe,
           java.lang.String url,
           publicadores.DtFecha fechaReg,
           java.lang.String actDep,
           int cantRegistros,
           java.lang.String picture) {
           this.nombre = nombre;
           this.fechaInicio = fechaInicio;
           this.profe = profe;
           this.url = url;
           this.fechaReg = fechaReg;
           this.actDep = actDep;
           this.cantRegistros = cantRegistros;
           this.picture = picture;
    }


    /**
     * Gets the nombre value for this DtClase.
     * 
     * @return nombre
     */
    public java.lang.String getNombre() {
        return nombre;
    }


    /**
     * Sets the nombre value for this DtClase.
     * 
     * @param nombre
     */
    public void setNombre(java.lang.String nombre) {
        this.nombre = nombre;
    }


    /**
     * Gets the fechaInicio value for this DtClase.
     * 
     * @return fechaInicio
     */
    public publicadores.DtFechaHora getFechaInicio() {
        return fechaInicio;
    }


    /**
     * Sets the fechaInicio value for this DtClase.
     * 
     * @param fechaInicio
     */
    public void setFechaInicio(publicadores.DtFechaHora fechaInicio) {
        this.fechaInicio = fechaInicio;
    }


    /**
     * Gets the profe value for this DtClase.
     * 
     * @return profe
     */
    public java.lang.String getProfe() {
        return profe;
    }


    /**
     * Sets the profe value for this DtClase.
     * 
     * @param profe
     */
    public void setProfe(java.lang.String profe) {
        this.profe = profe;
    }


    /**
     * Gets the url value for this DtClase.
     * 
     * @return url
     */
    public java.lang.String getUrl() {
        return url;
    }


    /**
     * Sets the url value for this DtClase.
     * 
     * @param url
     */
    public void setUrl(java.lang.String url) {
        this.url = url;
    }


    /**
     * Gets the fechaReg value for this DtClase.
     * 
     * @return fechaReg
     */
    public publicadores.DtFecha getFechaReg() {
        return fechaReg;
    }


    /**
     * Sets the fechaReg value for this DtClase.
     * 
     * @param fechaReg
     */
    public void setFechaReg(publicadores.DtFecha fechaReg) {
        this.fechaReg = fechaReg;
    }


    /**
     * Gets the actDep value for this DtClase.
     * 
     * @return actDep
     */
    public java.lang.String getActDep() {
        return actDep;
    }


    /**
     * Sets the actDep value for this DtClase.
     * 
     * @param actDep
     */
    public void setActDep(java.lang.String actDep) {
        this.actDep = actDep;
    }


    /**
     * Gets the cantRegistros value for this DtClase.
     * 
     * @return cantRegistros
     */
    public int getCantRegistros() {
        return cantRegistros;
    }


    /**
     * Sets the cantRegistros value for this DtClase.
     * 
     * @param cantRegistros
     */
    public void setCantRegistros(int cantRegistros) {
        this.cantRegistros = cantRegistros;
    }


    /**
     * Gets the picture value for this DtClase.
     * 
     * @return picture
     */
    public java.lang.String getPicture() {
        return picture;
    }


    /**
     * Sets the picture value for this DtClase.
     * 
     * @param picture
     */
    public void setPicture(java.lang.String picture) {
        this.picture = picture;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DtClase)) return false;
        DtClase other = (DtClase) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.nombre==null && other.getNombre()==null) || 
             (this.nombre!=null &&
              this.nombre.equals(other.getNombre()))) &&
            ((this.fechaInicio==null && other.getFechaInicio()==null) || 
             (this.fechaInicio!=null &&
              this.fechaInicio.equals(other.getFechaInicio()))) &&
            ((this.profe==null && other.getProfe()==null) || 
             (this.profe!=null &&
              this.profe.equals(other.getProfe()))) &&
            ((this.url==null && other.getUrl()==null) || 
             (this.url!=null &&
              this.url.equals(other.getUrl()))) &&
            ((this.fechaReg==null && other.getFechaReg()==null) || 
             (this.fechaReg!=null &&
              this.fechaReg.equals(other.getFechaReg()))) &&
            ((this.actDep==null && other.getActDep()==null) || 
             (this.actDep!=null &&
              this.actDep.equals(other.getActDep()))) &&
            this.cantRegistros == other.getCantRegistros() &&
            ((this.picture==null && other.getPicture()==null) || 
             (this.picture!=null &&
              this.picture.equals(other.getPicture())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getNombre() != null) {
            _hashCode += getNombre().hashCode();
        }
        if (getFechaInicio() != null) {
            _hashCode += getFechaInicio().hashCode();
        }
        if (getProfe() != null) {
            _hashCode += getProfe().hashCode();
        }
        if (getUrl() != null) {
            _hashCode += getUrl().hashCode();
        }
        if (getFechaReg() != null) {
            _hashCode += getFechaReg().hashCode();
        }
        if (getActDep() != null) {
            _hashCode += getActDep().hashCode();
        }
        _hashCode += getCantRegistros();
        if (getPicture() != null) {
            _hashCode += getPicture().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DtClase.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://publicadores/", "dtClase"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nombre");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nombre"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaInicio");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fechaInicio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://publicadores/", "dtFechaHora"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("profe");
        elemField.setXmlName(new javax.xml.namespace.QName("", "profe"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("url");
        elemField.setXmlName(new javax.xml.namespace.QName("", "url"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaReg");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fechaReg"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://publicadores/", "dtFecha"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("actDep");
        elemField.setXmlName(new javax.xml.namespace.QName("", "actDep"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cantRegistros");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cantRegistros"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("picture");
        elemField.setXmlName(new javax.xml.namespace.QName("", "picture"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
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
