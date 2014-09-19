package dominioModelo;

import dominioModelo.Materia;
import java.util.List;
import org.apache.commons.collections15.Predicate;
import org.uqbar.commons.model.CollectionBasedHome;

@SuppressWarnings("all")
public class HomeMaterias extends CollectionBasedHome<Materia> {
  public HomeMaterias() {
    this.init();
  }
  
  public void init() {
    this.create("Algoritmos", "2004", Boolean.valueOf(false), "Sarlanga", "1er cuatrimestre - Nivel 1");
    this.create("Fisica II", "2011", Boolean.valueOf(true), "CosmeFulanito", "1er cuatrimestre - Nivel 1");
  }
  
  public void create(final String nombreMateria, final String anioCursada, final Boolean finalAprobado, final String profesor, final String momentoCursada) {
    Materia materia = new Materia();
    materia.setNombre(nombreMateria);
    materia.setAnioCursada(anioCursada);
    materia.setFinalAprobado(finalAprobado);
    materia.setProfesor(profesor);
    materia.setMomentoCursada(momentoCursada);
    this.create(materia);
    List<Materia> _materias = this.getMaterias();
    _materias.add(materia);
  }
  
  protected Predicate<Materia> getCriterio(final Materia example) {
    return null;
  }
  
  public Materia createExample() {
    return new Materia();
  }
  
  public Class<Materia> getEntityType() {
    return Materia.class;
  }
  
  public List<Materia> getMaterias() {
    return this.allInstances();
  }
}
