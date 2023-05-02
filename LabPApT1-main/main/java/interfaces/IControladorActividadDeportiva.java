package interfaces;



import excepciones.ActividadDepRepetidaEx;
import excepciones.NoExisteActividadDepEx;
import excepciones.NoExistenUsuariosEx;
import excepciones.RegistroRepetidoEx;

import java.lang.Boolean;
import java.util.ArrayList;

import datatypes.DtActividadDeportiva;
import datatypes.DtClase;
import datatypes.DtFecha;

public interface IControladorActividadDeportiva {
	public Boolean existeInstitucionD(String nombreInst);
	
	public void AltaActividadDeportiva(String nombre, String nombreInst, String descripcion, int duracion, float costo, DtFecha fecha, String picture) throws ActividadDepRepetidaEx;

	public ArrayList<String> listarInstituciones();

	public ArrayList<String> listarActividadesDeportivas(String institucion);
	
	public DtActividadDeportiva ConsultaActividadDeportiva(String actDep) throws NoExisteActividadDepEx;
	
	public DtActividadDeportiva RegistroDictadoDeClase(String regClas) throws NoExisteActividadDepEx;
	
	public ArrayList<String> listarClases(String clase);

	public DtClase getDtClase(String clase);

	public ArrayList<String> getSocios() throws NoExistenUsuariosEx;

	public void altaRegistroDictadoDeClase(String socio, String clase) throws RegistroRepetidoEx;

	public ArrayList<String> getActividadesDeportivas();

	public DtActividadDeportiva getDtActividadDeportiva(String actDep);

	public void modificarActividadDeportiva(DtActividadDeportiva dtA);

	public ArrayList<DtActividadDeportiva> rankingActividadesDeportivas();

	public void eliminarRegistro(String socio, String clase) throws RegistroRepetidoEx;
}
                                   