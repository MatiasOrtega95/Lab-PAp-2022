/**
 * ControladorClasePublish.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package publicadores;

public interface ControladorClasePublish extends java.rmi.Remote {
    public java.lang.String[] listarActividadesDeportivas(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String[] listarClases(java.lang.String arg0) throws java.rmi.RemoteException;
    public void addClase(java.lang.String arg0, java.lang.String arg1, publicadores.DtFechaHora arg2, java.lang.String arg3, java.lang.String arg4, publicadores.DtFecha arg5, java.lang.String arg6) throws java.rmi.RemoteException;
    public java.lang.String[] listarProfesores(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String[] listarInstituciones() throws java.rmi.RemoteException;
    public publicadores.DtClase[] rankingClases() throws java.rmi.RemoteException;
}
