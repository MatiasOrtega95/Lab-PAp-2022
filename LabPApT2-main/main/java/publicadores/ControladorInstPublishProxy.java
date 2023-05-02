package publicadores;

public class ControladorInstPublishProxy implements publicadores.ControladorInstPublish {
  private String _endpoint = null;
  private publicadores.ControladorInstPublish controladorInstPublish = null;
  
  public ControladorInstPublishProxy() {
    _initControladorInstPublishProxy();
  }
  
  public ControladorInstPublishProxy(String endpoint) {
    _endpoint = endpoint;
    _initControladorInstPublishProxy();
  }
  
  private void _initControladorInstPublishProxy() {
    try {
      controladorInstPublish = (new publicadores.ControladorInstPublishServiceLocator()).getControladorInstPublishPort();
      if (controladorInstPublish != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)controladorInstPublish)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)controladorInstPublish)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (controladorInstPublish != null)
      ((javax.xml.rpc.Stub)controladorInstPublish)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public publicadores.ControladorInstPublish getControladorInstPublish() {
    if (controladorInstPublish == null)
      _initControladorInstPublishProxy();
    return controladorInstPublish;
  }
  
  public void addInstitucionDep(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2) throws java.rmi.RemoteException{
    if (controladorInstPublish == null)
      _initControladorInstPublishProxy();
    controladorInstPublish.addInstitucionDep(arg0, arg1, arg2);
  }
  
  public java.lang.String[] listarInstituciones() throws java.rmi.RemoteException{
    if (controladorInstPublish == null)
      _initControladorInstPublishProxy();
    return controladorInstPublish.listarInstituciones();
  }
  
  public void updateInstDep(publicadores.DtInstitucionDeportiva arg0) throws java.rmi.RemoteException{
    if (controladorInstPublish == null)
      _initControladorInstPublishProxy();
    controladorInstPublish.updateInstDep(arg0);
  }
  
  
}