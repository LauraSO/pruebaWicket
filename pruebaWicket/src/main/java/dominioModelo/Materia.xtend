package dominioModelo

import org.uqbar.commons.model.Entity
import org.uqbar.commons.model.UserException

class Materia extends Entity{
	
	@Property String nombre
	@Property String anioCursada
	@Property Boolean finalAprobado
	@Property String profesor
	@Property String momentoCursada
	
	
	def validar() {
		if (nombre == null) {
			throw new UserException("Debe ingresar nombre de la materia")
		}
		
	}
	
	
	
}