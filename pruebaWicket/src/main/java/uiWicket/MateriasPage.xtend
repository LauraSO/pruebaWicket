package uiWicket

import dominioModelo.ApplicationModelMateria
import dominioModelo.Materia
import org.apache.wicket.markup.html.WebPage
import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.markup.html.form.Form
import org.apache.wicket.model.CompoundPropertyModel
import org.uqbar.wicket.xtend.WicketExtensionFactoryMethods
import org.uqbar.wicket.xtend.XButton
import org.uqbar.wicket.xtend.XListView

class MateriasPage extends WebPage{
	
	extension WicketExtensionFactoryMethods = new WicketExtensionFactoryMethods
	var ApplicationModelMateria materia
	
	new() {
		this.materia = new ApplicationModelMateria
		val Form<ApplicationModelMateria> materiasForm = new Form<ApplicationModelMateria>("materiasForm", new CompoundPropertyModel<ApplicationModelMateria>(this.materia))
		this.agregarAcciones(materiasForm)
		this.agregarGrillaResultados(materiasForm)
		this.addChild(materiasForm)
	}
	
def agregarAcciones(Form<ApplicationModelMateria> parent) {
		parent.addChild(new XButton("nueva").onClick = [| editar(new Materia) ])
	}
	
	def editar(Materia materia) {
		responsePage = new EditarMateriaPage(materia, this) 
	}	
	
	def obtenerMaterias() {
		this.materia.obtenerMaterias()
	}	

	def agregarGrillaResultados(Form<ApplicationModelMateria> parent) {
		val listView = new XListView("materias")
		listView.populateItem = [ item |
			item.model = item.modelObject.asCompoundModel
			item.addChild(new Label("nombre"))
			
			item.addChild(new XButton("editar").onClick = [| editar(item.modelObject) ])
		]
		parent.addChild(listView)
	}
	
	
	
}