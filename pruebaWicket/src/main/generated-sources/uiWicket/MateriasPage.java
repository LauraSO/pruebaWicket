package uiWicket;

import dominioModelo.ApplicationModelMateria;
import dominioModelo.Materia;
import java.util.List;
import org.apache.wicket.MarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.model.CompoundPropertyModel;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.wicket.xtend.WicketExtensionFactoryMethods;
import org.uqbar.wicket.xtend.XButton;
import org.uqbar.wicket.xtend.XListView;
import uiWicket.EditarMateriaPage;

@SuppressWarnings("all")
public class MateriasPage extends WebPage {
  @Extension
  private WicketExtensionFactoryMethods _wicketExtensionFactoryMethods = new WicketExtensionFactoryMethods();
  
  private ApplicationModelMateria materia;
  
  public MateriasPage() {
    ApplicationModelMateria _applicationModelMateria = new ApplicationModelMateria();
    this.materia = _applicationModelMateria;
    CompoundPropertyModel<ApplicationModelMateria> _compoundPropertyModel = new CompoundPropertyModel<ApplicationModelMateria>(this.materia);
    final Form<ApplicationModelMateria> materiasForm = new Form<ApplicationModelMateria>("materiasForm", _compoundPropertyModel);
    this.agregarAcciones(materiasForm);
    this.agregarGrillaResultados(materiasForm);
    this._wicketExtensionFactoryMethods.addChild(this, materiasForm);
  }
  
  public MarkupContainer agregarAcciones(final Form<ApplicationModelMateria> parent) {
    XButton _xButton = new XButton("nueva");
    final Procedure0 _function = new Procedure0() {
      public void apply() {
        Materia _materia = new Materia();
        MateriasPage.this.editar(_materia);
      }
    };
    XButton _setOnClick = _xButton.setOnClick(_function);
    return this._wicketExtensionFactoryMethods.addChild(parent, _setOnClick);
  }
  
  public void editar(final Materia materia) {
    EditarMateriaPage _editarMateriaPage = new EditarMateriaPage(materia, this);
    this.setResponsePage(_editarMateriaPage);
  }
  
  public List<Materia> obtenerMaterias() {
    return this.materia.obtenerMaterias();
  }
  
  public MarkupContainer agregarGrillaResultados(final Form<ApplicationModelMateria> parent) {
    MarkupContainer _xblockexpression = null;
    {
      final XListView<Materia> listView = new XListView<Materia>("materias");
      final Procedure1<ListItem<Materia>> _function = new Procedure1<ListItem<Materia>>() {
        public void apply(final ListItem<Materia> item) {
          Materia _modelObject = item.getModelObject();
          CompoundPropertyModel<Materia> _asCompoundModel = MateriasPage.this._wicketExtensionFactoryMethods.<Materia>asCompoundModel(_modelObject);
          item.setModel(_asCompoundModel);
          Label _label = new Label("nombre");
          MateriasPage.this._wicketExtensionFactoryMethods.addChild(item, _label);
          XButton _xButton = new XButton("editar");
          final Procedure0 _function = new Procedure0() {
            public void apply() {
              Materia _modelObject = item.getModelObject();
              MateriasPage.this.editar(_modelObject);
            }
          };
          XButton _setOnClick = _xButton.setOnClick(_function);
          MateriasPage.this._wicketExtensionFactoryMethods.addChild(item, _setOnClick);
        }
      };
      listView.setPopulateItem(_function);
      _xblockexpression = this._wicketExtensionFactoryMethods.addChild(parent, listView);
    }
    return _xblockexpression;
  }
}
