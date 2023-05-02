/**
 * ControladorUsuarioPublish.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package publicadores;

public interface ControladorUsuarioPublish extends java.rmi.Remote {
    public publicadores.DtUsuario existeUsuario(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException;
    public java.lang.String[] mostrarUsuarios() throws java.rmi.RemoteException;
    public publicadores.DtUsuario consultaUsuario(java.lang.String arg0) throws java.rmi.RemoteException;
    public publicadores.DtInstitucionDeportiva getDtinstitucionDeportiva(java.lang.String arg0) throws java.rmi.RemoteException;
    public void altaUsuario(publicadores.DtUsuario arg0) throws java.rmi.RemoteException;
    public java.lang.String[] listarInstituciones() throws java.rmi.RemoteException;
    public void modificarUsuario(publicadores.DtUsuario arg0) throws java.rmi.RemoteException;
}
