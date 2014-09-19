package uiWicket;

import dominioModelo.HomeMaterias;
import dominioModelo.Materia;
import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;
import org.uqbar.commons.utils.ApplicationContext;
import uiWicket.MateriasPage;

@SuppressWarnings("all")
public class WicketApplication extends WebApplication {
  protected void init() {
    super.init();
    ApplicationContext _instance = ApplicationContext.getInstance();
    HomeMaterias _homeMaterias = new HomeMaterias();
    _instance.<HomeMaterias>configureSingleton(Materia.class, _homeMaterias);
  }
  
  public Class<? extends Page> getHomePage() {
    return MateriasPage.class;
  }
}
