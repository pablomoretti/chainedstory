package chainedstory

class Story {
	
	String title //story title
	String status //(open/finished)
	String category //not used yet. 
	//String facebookId //We should add a Chained Story object to FBOG
	Date created //creation date
	Integer maxSteps //How long should a story branch be
	
    static constraints = {
		category nullable:true
    }
}
