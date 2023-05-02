package publicadores;

public class ControladorClasePublishProxy implements publicadores.ControladorClasePublish {
  private String _endpoint = null;
  private publicadores.ControladorClasePublish controladorClasePublish = null;
  
  public ControladorClasePublishProxy() {
    _initControladorClasePublishProxy();
  }
  
  public ControladorClasePublishProxy(String endpoint) {
    _endpoint = endpoint;
    _initControladorClasePublishProxy();
  }
  
  private void _initControladorClasePublishProxy() {
    try {
      controladorClasePublish = (new publicadores.ControladorClasePublishServiceLocator()).getControladorClasePublishPort();
      if (controladorClasePublish != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)controladorClasePublish)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)controladorClasePublish)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (controladorClasePublish != null)
      ((javax.xml.rpc.Stub)controladorClasePublish)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public publicadores.ControladorClasePublish getControladorClasePublish() {
    if (controladorClasePublish == null)
      _initControladorClasePublishProxy();
    return controladorClasePublish;
  }
  
  public java.lang.String[] listarActividadesDeportivas(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorClasePublish == null)
      _initControladorClasePublishProxy();
    return controladorClasePublish.listarActividadesDeportivas(arg0);
  }
  
  public java.lang.String[] listarClases(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorClasePublish == null)
      _initControladorClasePublishProxy();
    return controladorClasePublish.listarClases(arg0);
  }
  
  public void addClase(java.lang.String arg0, java.lang.String arg1, publicadores.DtFechaHora arg2, java.lang.String arg3, java.lang.String arg4, publicadores.DtFecha arg5, java.lang.String arg6) throws java.rmi.RemoteException{
    if (controladorClasePublish == null)
      _initControladorClasePublishProxy();
    controladorClasePublish.addClase(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
  }
  
  public java.lang.String[] listarProfesores(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorClasePublish == null)
      _initControladorClasePublishProxy();
    return controladorClasePublish.listarProfesores(arg0);
  }
  
  public java.lang.String[] listarInstituciones() throws java.rmi.RemoteException{
    if (controladorClasePublish == null)
      _initControladorClasePublishProxy();
    return controladorClasePublish.listarInstituciones();
  }
  
  public publicadores.DtClase[] rankingClases() throws java.rmi.RemoteException{
    if (controladorClasePublish == null)
      _initControladorClasePublishProxy();
    return controladorClasePublish.rankingClases();
  }
  
  
}