package dominioModelo;

import com.google.common.collect.Lists;
import dominioModelo.HomeMaterias;
import dominioModelo.Materia;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.uqbar.commons.utils.ApplicationContext;

@SuppressWarnings("all")
public class ApplicationModelMateria implements Serializable {
  private Materia _materiaSeleccionada;
  
  public Materia getMateriaSeleccionada() {
    return this._materiaSeleccionada;
  }
  
  public void setMateriaSeleccionada(final Materia materiaSeleccionada) {
    this._materiaSeleccionada = materiaSeleccionada;
  }
  
  private List<Materia> _materias;
  
  public List<Materia> getMaterias() {
    return this._materias;
  }
  
  public void setMaterias(final List<Materia> materias) {
    this._materias = materias;
  }
  
  private List<String> _ubicaciones;
  
  public List<String> getUbicaciones() {
    return this._ubicaciones;
  }
  
  public void setUbicaciones(final List<String> ubicaciones) {
    this._ubicaciones = ubicaciones;
  }
  
  public HomeMaterias getHomeMaterias() {
    ApplicationContext _instance = ApplicationContext.getInstance();
    return _instance.<HomeMaterias>getSingleton(Materia.class);
  }
  
  public void conseguirMaterias() {
    ArrayList<Materia> _arrayList = new ArrayList<Materia>();
    this.setMaterias(_arrayList);
    HomeMaterias _homeMaterias = this.getHomeMaterias();
    List<Materia> _materias = _homeMaterias.getMaterias();
    this.setMaterias(_materias);
  }
  
  public void crearMateria(final Materia materia) {
    HomeMaterias _homeMaterias = this.getHomeMaterias();
    _homeMaterias.create(materia);
    this.conseguirMaterias();
  }
  
  public void conseguirUbicaciones() {
    ArrayList<String> _arrayList = new ArrayList<String>();
    this.setUbicaciones(_arrayList);
    this.setUbicaciones(Collections.<String>unmodifiableList(Lists.<String>newArrayList("1er cuatrimestre - Nivel 1", "1er cuatrimestre - Nivel 2", "1er cuatrimestre - Nivel 3")));
  }
  
  public List<Materia> obtenerMaterias() {
    return this.getMaterias();
  }
}
