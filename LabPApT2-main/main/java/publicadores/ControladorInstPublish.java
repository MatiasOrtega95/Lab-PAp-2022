/**
 * ControladorInstPublish.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package publicadores;

public interface ControladorInstPublish extends java.rmi.Remote {
    public void addInstitucionDep(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2) throws java.rmi.RemoteException;
    public java.lang.String[] listarInstituciones() throws java.rmi.RemoteException;
    public void updateInstDep(publicadores.DtInstitucionDeportiva arg0) throws java.rmi.RemoteException;
}
