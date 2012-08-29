package chainedstory

class Story {
	
	String name
	String author
	String authorName
	Integer status
	Paragraph rootParagraph
	
	static hasMany = [paragraphs:Paragraph]
	
    static constraints = {
		authorName nullable:true
		rootParagraph nullable:true	
    }
}
