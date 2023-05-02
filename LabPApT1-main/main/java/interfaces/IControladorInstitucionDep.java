package interfaces;

import java.util.ArrayList;

import datatypes.DtInstitucionDeportiva;
import excepciones.InstitucionDepRepetidaEx;

public interface IControladorInstitucionDep {
	public void addInstitucionDep(String nombre, String descripcion, String URL) throws InstitucionDepRepetidaEx;

	public ArrayList<String> listarInstituciones();

	public void updateInstDep(DtInstitucionDeportiva dtInstDep);

}
