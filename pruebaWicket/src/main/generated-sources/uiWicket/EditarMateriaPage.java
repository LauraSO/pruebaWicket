package uiWicket;

import dominioModelo.Materia;
import org.apache.wicket.MarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.commons.model.Home;
import org.uqbar.wicket.xtend.WicketExtensionFactoryMethods;
import org.uqbar.wicket.xtend.XButton;
import uiWicket.MateriasPage;

@SuppressWarnings("all")
public class EditarMateriaPage extends WebPage {
  @Extension
  private WicketExtensionFactoryMethods _wicketExtensionFactoryMethods = new WicketExtensionFactoryMethods();
  
  private Materia materia;
  
  private boolean alta;
  
  private MateriasPage mainPage;
  
  public EditarMateriaPage(final Materia materiaAEditar, final MateriasPage page) {
    this.mainPage = this.mainPage;
    boolean _isNew = materiaAEditar.isNew();
    this.alta = _isNew;
    this.materia = materiaAEditar;
    String _xifexpression = null;
    if (this.alta) {
      _xifexpression = "Nueva Materia";
    } else {
      _xifexpression = "Editar Materia";
    }
    Label _label = new Label("titulo", _xifexpression);
    this._wicketExtensionFactoryMethods.addChild(this, _label);
    CompoundPropertyModel<Materia> _asCompoundModel = this._wicketExtensionFactoryMethods.<Materia>asCompoundModel(this.materia);
    final Form<Materia> materiasForm = new Form<Materia>("nuevaMateriaForm", _asCompoundModel);
    this.agregarCamposEdicion(materiasForm);
    this.agregarAcciones(materiasForm);
    this._wicketExtensionFactoryMethods.addChild(this, materiasForm);
  }
  
  public void agregarAcciones(final Form<Materia> parent) {
    XButton _xButton = new XButton("aceptar");
    final Procedure1<XButton> _function = new Procedure1<XButton>() {
      public void apply(final XButton it) {
        final Procedure0 _function = new Procedure0() {
          public void apply() {
            EditarMateriaPage.this.volver();
            Home<Materia> _home = EditarMateriaPage.this._wicketExtensionFactoryMethods.<Materia>home(Materia.class);
            _home.create(EditarMateriaPage.this.materia);
          }
        };
        it.setOnClick(_function);
      }
    };
    XButton _doubleArrow = ObjectExtensions.<XButton>operator_doubleArrow(_xButton, _function);
    this._wicketExtensionFactoryMethods.addChild(parent, _doubleArrow);
    XButton _xButton_1 = new XButton("cancelar");
    final Procedure1<XButton> _function_1 = new Procedure1<XButton>() {
      public void apply(final XButton it) {
        final Procedure0 _function = new Procedure0() {
          public void apply() {
            EditarMateriaPage.this.volver();
          }
        };
        it.setOnClick(_function);
      }
    };
    XButton _doubleArrow_1 = ObjectExtensions.<XButton>operator_doubleArrow(_xButton_1, _function_1);
    this._wicketExtensionFactoryMethods.addChild(parent, _doubleArrow_1);
  }
  
  public void volver() {
    this.mainPage.obtenerMaterias();
    this.setResponsePage(this.mainPage);
  }
  
  public MarkupContainer agregarCamposEdicion(final Form<Materia> parent) {
    MarkupContainer _xblockexpression = null;
    {
      TextField<String> _textField = new TextField<String>("nombre");
      this._wicketExtensionFactoryMethods.addChild(parent, _textField);
      FeedbackPanel _feedbackPanel = new FeedbackPanel("feedbackPanel");
      _xblockexpression = this._wicketExtensionFactoryMethods.addChild(parent, _feedbackPanel);
    }
    return _xblockexpression;
  }
}
