package publicadores;

public class ControladorActDepPublishProxy implements publicadores.ControladorActDepPublish {
  private String _endpoint = null;
  private publicadores.ControladorActDepPublish controladorActDepPublish = null;
  
  public ControladorActDepPublishProxy() {
    _initControladorActDepPublishProxy();
  }
  
  public ControladorActDepPublishProxy(String endpoint) {
    _endpoint = endpoint;
    _initControladorActDepPublishProxy();
  }
  
  private void _initControladorActDepPublishProxy() {
    try {
      controladorActDepPublish = (new publicadores.ControladorActDepPublishServiceLocator()).getControladorActDepPublishPort();
      if (controladorActDepPublish != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)controladorActDepPublish)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)controladorActDepPublish)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (controladorActDepPublish != null)
      ((javax.xml.rpc.Stub)controladorActDepPublish)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public publicadores.ControladorActDepPublish getControladorActDepPublish() {
    if (controladorActDepPublish == null)
      _initControladorActDepPublishProxy();
    return controladorActDepPublish;
  }
  
  public boolean existeInstitucionD(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorActDepPublish == null)
      _initControladorActDepPublishProxy();
    return controladorActDepPublish.existeInstitucionD(arg0);
  }
  
  public publicadores.DtActividadDeportiva consultaActividadDeportiva(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorActDepPublish == null)
      _initControladorActDepPublishProxy();
    return controladorActDepPublish.consultaActividadDeportiva(arg0);
  }
  
  public publicadores.DtActividadDeportiva registoDictadoDeClase(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorActDepPublish == null)
      _initControladorActDepPublishProxy();
    return controladorActDepPublish.registoDictadoDeClase(arg0);
  }
  
  public void eliminarRegistroClase(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException{
    if (controladorActDepPublish == null)
      _initControladorActDepPublishProxy();
    controladorActDepPublish.eliminarRegistroClase(arg0, arg1);
  }
  
  public void altaActividadDeportiva(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, int arg3, float arg4, publicadores.DtFecha arg5, java.lang.String arg6) throws java.rmi.RemoteException{
    if (controladorActDepPublish == null)
      _initControladorActDepPublishProxy();
    controladorActDepPublish.altaActividadDeportiva(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
  }
  
  public java.lang.String[] listarActividadesDeportivas(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorActDepPublish == null)
      _initControladorActDepPublishProxy();
    return controladorActDepPublish.listarActividadesDeportivas(arg0);
  }
  
  public java.lang.String[] listarClases(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorActDepPublish == null)
      _initControladorActDepPublishProxy();
    return controladorActDepPublish.listarClases(arg0);
  }
  
  public publicadores.DtClase getDtClase(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorActDepPublish == null)
      _initControladorActDepPublishProxy();
    return controladorActDepPublish.getDtClase(arg0);
  }
  
  public java.lang.String[] listarInstituciones() throws java.rmi.RemoteException{
    if (controladorActDepPublish == null)
      _initControladorActDepPublishProxy();
    return controladorActDepPublish.listarInstituciones();
  }
  
  public void altaRegistroDictadoDeClase(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException{
    if (controladorActDepPublish == null)
      _initControladorActDepPublishProxy();
    controladorActDepPublish.altaRegistroDictadoDeClase(arg0, arg1);
  }
  
  public java.lang.String[] getSocios() throws java.rmi.RemoteException{
    if (controladorActDepPublish == null)
      _initControladorActDepPublishProxy();
    return controladorActDepPublish.getSocios();
  }
  
  public void modificarActividadDeportiva(publicadores.DtActividadDeportiva arg0) throws java.rmi.RemoteException{
    if (controladorActDepPublish == null)
      _initControladorActDepPublishProxy();
    controladorActDepPublish.modificarActividadDeportiva(arg0);
  }
  
  public java.lang.String[] getActividadesDeportivas() throws java.rmi.RemoteException{
    if (controladorActDepPublish == null)
      _initControladorActDepPublishProxy();
    return controladorActDepPublish.getActividadesDeportivas();
  }
  
  public publicadores.DtActividadDeportiva getDtActividadDeportiva(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorActDepPublish == null)
      _initControladorActDepPublishProxy();
    return controladorActDepPublish.getDtActividadDeportiva(arg0);
  }
  
  
}