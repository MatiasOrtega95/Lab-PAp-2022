/**
 * ControladorInstPublishServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package publicadores;

public class ControladorInstPublishServiceLocator extends org.apache.axis.client.Service implements publicadores.ControladorInstPublishService {

    public ControladorInstPublishServiceLocator() {
    }


    public ControladorInstPublishServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ControladorInstPublishServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ControladorInstPublishPort
    private java.lang.String ControladorInstPublishPort_address = "http://127.0.0.1:1890/controladorInst";

    public java.lang.String getControladorInstPublishPortAddress() {
        return ControladorInstPublishPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ControladorInstPublishPortWSDDServiceName = "ControladorInstPublishPort";

    public java.lang.String getControladorInstPublishPortWSDDServiceName() {
        return ControladorInstPublishPortWSDDServiceName;
    }

    public void setControladorInstPublishPortWSDDServiceName(java.lang.String name) {
        ControladorInstPublishPortWSDDServiceName = name;
    }

    public publicadores.ControladorInstPublish getControladorInstPublishPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ControladorInstPublishPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getControladorInstPublishPort(endpoint);
    }

    public publicadores.ControladorInstPublish getControladorInstPublishPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            publicadores.ControladorInstPublishPortBindingStub _stub = new publicadores.ControladorInstPublishPortBindingStub(portAddress, this);
            _stub.setPortName(getControladorInstPublishPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setControladorInstPublishPortEndpointAddress(java.lang.String address) {
        ControladorInstPublishPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (publicadores.ControladorInstPublish.class.isAssignableFrom(serviceEndpointInterface)) {
                publicadores.ControladorInstPublishPortBindingStub _stub = new publicadores.ControladorInstPublishPortBindingStub(new java.net.URL(ControladorInstPublishPort_address), this);
                _stub.setPortName(getControladorInstPublishPortWSDDServiceName());
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
        if ("ControladorInstPublishPort".equals(inputPortName)) {
            return getControladorInstPublishPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://publicadores/", "ControladorInstPublishService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://publicadores/", "ControladorInstPublishPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ControladorInstPublishPort".equals(portName)) {
            setControladorInstPublishPortEndpointAddress(address);
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
