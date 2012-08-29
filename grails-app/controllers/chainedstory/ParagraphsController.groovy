package chainedstory

class ParagraphsController {

    def index() { 
		render " saraza"
		}
	def congrats() {
	
	}
	def write () {
		//write a new paragraph
		def parent = params.parent_paragraph
		def theParagraph = new Paragraph()
		theParagraph.leftSteps = 10
		
		if (parent) {
			theParagraph.parent = parent
			theParagraph.leftSteps = (Paragraph.findById(parent)?.leftSteps?:10)-1
		}
		theParagraph.author = params.author
		theParagraph.content = params.content
		
		println theParagraph.save()
		println "objeto: ${theParagraph.properties.toString()}"
		render "ok "
	}
	
	def list () {
		def salida = []
		Paragraph.list().each {
			println it.properties.toString()
			salida << "${it.id} -> Author: ${it.author}, Parent: ${it.parent}, content: ${it.content}"
		}
		render salida
	}
}
