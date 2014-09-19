package dominioModelo

import org.uqbar.commons.model.CollectionBasedHome
import org.apache.commons.collections15.Predicate
import dominioModelo.Materia
import java.util.List

class HomeMaterias extends CollectionBasedHome<Materia> {
	
	new() {
		
		this.init
	}
	
	def void init() {
		this.create("Algoritmos", "2004", false, "Sarlanga", "1er cuatrimestre - Nivel 1")
		this.create("Fisica II", "2011", true, "CosmeFulanito",  "1er cuatrimestre - Nivel 1")
	}

	def void create(String nombreMateria,String anioCursada,Boolean finalAprobado,String profesor,String momentoCursada) {
		var materia = new Materia
		materia.nombre=nombreMateria
		materia.anioCursada=anioCursada
		materia.finalAprobado=finalAprobado
		materia.profesor=profesor
		materia.momentoCursada=momentoCursada
		this.create(materia)
		materias.add(materia)
	}
	
	override protected Predicate<Materia> getCriterio(Materia example) {
		null
	}
	
	override createExample() {
		new Materia
	}
	
	override getEntityType() {
		typeof(Materia)
	}
	
	def  List<Materia>  getMaterias() {
		allInstances
	}
		
	}
	
	

