/**
 * ControladorClasePublishServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package publicadores;

public class ControladorClasePublishServiceLocator extends org.apache.axis.client.Service implements publicadores.ControladorClasePublishService {

    public ControladorClasePublishServiceLocator() {
    }


    public ControladorClasePublishServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ControladorClasePublishServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ControladorClasePublishPort
    private java.lang.String ControladorClasePublishPort_address = "http://127.0.0.2:1890/controladorClase";

    public java.lang.String getControladorClasePublishPortAddress() {
        return ControladorClasePublishPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ControladorClasePublishPortWSDDServiceName = "ControladorClasePublishPort";

    public java.lang.String getControladorClasePublishPortWSDDServiceName() {
        return ControladorClasePublishPortWSDDServiceName;
    }

    public void setControladorClasePublishPortWSDDServiceName(java.lang.String name) {
        ControladorClasePublishPortWSDDServiceName = name;
    }

    public publicadores.ControladorClasePublish getControladorClasePublishPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ControladorClasePublishPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getControladorClasePublishPort(endpoint);
    }

    public publicadores.ControladorClasePublish getControladorClasePublishPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            publicadores.ControladorClasePublishPortBindingStub _stub = new publicadores.ControladorClasePublishPortBindingStub(portAddress, this);
            _stub.setPortName(getControladorClasePublishPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setControladorClasePublishPortEndpointAddress(java.lang.String address) {
        ControladorClasePublishPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (publicadores.ControladorClasePublish.class.isAssignableFrom(serviceEndpointInterface)) {
                publicadores.ControladorClasePublishPortBindingStub _stub = new publicadores.ControladorClasePublishPortBindingStub(new java.net.URL(ControladorClasePublishPort_address), this);
                _stub.setPortName(getControladorClasePublishPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("ControladorClasePublishPort".equals(inputPortName)) {
            return getControladorClasePublishPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://publicadores/", "ControladorClasePublishService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://publicadores/", "ControladorClasePublishPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ControladorClasePublishPort".equals(portName)) {
            setControladorClasePublishPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
