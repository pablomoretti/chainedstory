package chainedstory

class Paragraph {

	Story story //story containing this paragraph
	String content //paragraph content
	String authorId //facebookId of the author 
	String authorName //avoid extra call 
	Integer height // position of the paragraph in the story branch 
	Paragraph parent // parent paragraph, previous in the story
	List children //knowing the children paragraphs saves some extra code
	String facebookId //id of the paragraph object in FBOG
	 
	static belongsTo = [story:Story]
    static hasMany = [children: Paragraph]
	static constraints = {
		parent nullable:true
		facebookId nullable:true
		children nullable:true
		authorName nullable:true
    }
}
