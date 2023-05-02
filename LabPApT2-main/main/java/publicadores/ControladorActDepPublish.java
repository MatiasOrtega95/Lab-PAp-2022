/**
 * ControladorActDepPublish.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package publicadores;

public interface ControladorActDepPublish extends java.rmi.Remote {
    public boolean existeInstitucionD(java.lang.String arg0) throws java.rmi.RemoteException;
    public publicadores.DtActividadDeportiva consultaActividadDeportiva(java.lang.String arg0) throws java.rmi.RemoteException;
    public publicadores.DtActividadDeportiva registoDictadoDeClase(java.lang.String arg0) throws java.rmi.RemoteException;
    public void eliminarRegistroClase(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException;
    public void altaActividadDeportiva(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, int arg3, float arg4, publicadores.DtFecha arg5, java.lang.String arg6) throws java.rmi.RemoteException;
    public java.lang.String[] listarActividadesDeportivas(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String[] listarClases(java.lang.String arg0) throws java.rmi.RemoteException;
    public publicadores.DtClase getDtClase(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String[] listarInstituciones() throws java.rmi.RemoteException;
    public void altaRegistroDictadoDeClase(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException;
    public java.lang.String[] getSocios() throws java.rmi.RemoteException;
    public void modificarActividadDeportiva(publicadores.DtActividadDeportiva arg0) throws java.rmi.RemoteException;
    public java.lang.String[] getActividadesDeportivas() throws java.rmi.RemoteException;
    public publicadores.DtActividadDeportiva getDtActividadDeportiva(java.lang.String arg0) throws java.rmi.RemoteException;
}
