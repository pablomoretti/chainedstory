import java.util.List;

import chainedstory.Paragraph;

class BootStrap {

    def init = { servletContext ->
		
		Paragraph p1 = new Paragraph()
		
		p1.author = 1426088112
		
		p1.content = "Habia una vez ...."
		
		p1.leftSteps = 10
		
		println p1.save(flush:true);
		
    }
    def destroy = {
    }
}
