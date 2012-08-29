package chainedstory

class Paragraph {

	
	String author
	String content
	Integer leftSteps
	Paragraph parent
	List children
	String facebookId
	 
    static hasMany = [children: Paragraph]
	static constraints = {
		parent nullable:true
		facebookId nullable:true
		children nullable:true
    }
}
