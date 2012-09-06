import java.util.List;

import chainedstory.Paragraph;
import grails.converters.JSON

class BootStrap {

    def init = { servletContext ->
    /*    JSON.registerObjectMarshaller(Story) {
            def returnArray = [:]
            returnArray['title'] = it.title
            return returnArray
        }*/
    }
    def destroy = {
    }
}
