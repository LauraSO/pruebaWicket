package dominioModelo;

import com.google.common.base.Objects;
import org.uqbar.commons.model.Entity;
import org.uqbar.commons.model.UserException;

@SuppressWarnings("all")
public class Materia extends Entity {
  private String _nombre;
  
  public String getNombre() {
    return this._nombre;
  }
  
  public void setNombre(final String nombre) {
    this._nombre = nombre;
  }
  
  private String _anioCursada;
  
  public String getAnioCursada() {
    return this._anioCursada;
  }
  
  public void setAnioCursada(final String anioCursada) {
    this._anioCursada = anioCursada;
  }
  
  private Boolean _finalAprobado;
  
  public Boolean getFinalAprobado() {
    return this._finalAprobado;
  }
  
  public void setFinalAprobado(final Boolean finalAprobado) {
    this._finalAprobado = finalAprobado;
  }
  
  private String _profesor;
  
  public String getProfesor() {
    return this._profesor;
  }
  
  public void setProfesor(final String profesor) {
    this._profesor = profesor;
  }
  
  private String _momentoCursada;
  
  public String getMomentoCursada() {
    return this._momentoCursada;
  }
  
  public void setMomentoCursada(final String momentoCursada) {
    this._momentoCursada = momentoCursada;
  }
  
  public void validar() {
    String _nombre = this.getNombre();
    boolean _equals = Objects.equal(_nombre, null);
    if (_equals) {
      throw new UserException("Debe ingresar nombre de la materia");
    }
  }
}
