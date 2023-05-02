package interfaces;

import java.util.ArrayList;

import datatypes.DtClase;
import datatypes.DtFecha;
import datatypes.DtFechaHora;
import excepciones.ClaseRepetidaEx;
import excepciones.NoExistenUsuariosEx;

public interface IControladorClase {
	public void addClase(String actDep, String nombreClase, DtFechaHora fechaHoraInicio, String nomProf, String URL, DtFecha fechaAlt, String picture) throws ClaseRepetidaEx, NoExistenUsuariosEx;
	public ArrayList<String> listarInstituciones();
	public ArrayList<String> listarActividadesDeportivas(String institucion);
	public ArrayList<String> listarProfesores(String institucion);
	public ArrayList<String> listarClases(String clase);
	public ArrayList<DtClase> rankingClases();
}