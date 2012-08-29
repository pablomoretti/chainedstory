package chainedstory

class Paragraph {

	
	String author
	String content
	Integer leftSteps
	Paragraph parent
	List children
	 
    static hasMany = [children: Paragraph]
	static constraints = {
		parent nullable:true
		
    }
}
