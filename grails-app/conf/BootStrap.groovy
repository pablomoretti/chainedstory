import java.util.List;

import chainedstory.Paragraph;
import grails.converters.JSON
import chainedstory.Story;

class BootStrap {

    def init = { servletContext ->
        JSON.registerObjectMarshaller(Story) {
            def returnArray = [:]
            returnArray['title'] = it.title
            returnArray['id'] = it.id
            returnArray['category'] = it.category
            returnArray['created'] = it.created
            returnArray['status'] = it.status
            return returnArray
        }
        JSON.registerObjectMarshaller(Paragraph) {
            def returnArray = [:]
            returnArray['content'] = it.content
            returnArray['id'] = it.id
            returnArray['author_id'] = it.authorId
            returnArray['author_name'] = it.authorName
            returnArray['created'] = it.created
            returnArray['facebook_id'] = it.facebookId
            return returnArray
        }
    }
    def destroy = {
    }
}
