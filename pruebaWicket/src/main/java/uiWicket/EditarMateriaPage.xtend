package uiWicket

import dominioModelo.Materia
import org.apache.wicket.markup.html.WebPage
import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.markup.html.form.Form
import org.apache.wicket.markup.html.form.TextField
import org.apache.wicket.markup.html.panel.FeedbackPanel
import org.uqbar.commons.model.UserException
import org.uqbar.wicket.xtend.WicketExtensionFactoryMethods
import org.uqbar.wicket.xtend.XButton
import org.apache.wicket.model.CompoundPropertyModel

class EditarMateriaPage extends WebPage {
	
	extension WicketExtensionFactoryMethods = new WicketExtensionFactoryMethods
	Materia materia
	boolean alta
	MateriasPage mainPage
	
	
	new(Materia materiaAEditar, MateriasPage page) {
		
		this.mainPage = mainPage
		
		this.alta = materiaAEditar.isNew()
		this.materia = materiaAEditar
		this.addChild(new Label("titulo", if (this.alta) "Nueva Materia" else "Editar Materia"))
		
   val materiasForm = new Form<Materia>("nuevaMateriaForm",new CompoundPropertyModel<Materia>(this.materia))
		this.agregarCamposEdicion(materiasForm)
		this.agregarAcciones(materiasForm)
		this.addChild(materiasForm)
		 //this.materia.asCompoundModel
		
	}
	
	
	def void agregarAcciones(Form<Materia> parent) {
		parent.addChild(new XButton("aceptar") => [
			onClick = [|
				//try {
					//materia.validar()
					//volver
					if (alta) {
						Materia.home.create(materia)
					} else {
						Materia.home.delete(materia)
						Materia.home.create(materia)
					}
					volver
				//} catch (UserException e) {
					//info(e.getMessage())
				//} catch (RuntimeException e) {
					//error("error en el ingreso de la materia")
				//}
			]				
		])
		parent.addChild(new XButton("cancelar") => [
			onClick = [| volver ]
		])
	}
	
	def volver() {
		mainPage.obtenerMaterias()
		responsePage = mainPage
	}
	

	def agregarCamposEdicion(Form<Materia> parent) {
		parent.addChild(new TextField<String>("nombre"))
		parent.addChild(new FeedbackPanel("feedbackPanel"))
	}
	   
	
}