import java.net.URL;
import java.net.URLConnection;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class XMLStreamReaderExample {

	public static void main(String [] args) {

		XMLInputFactory factory = XMLInputFactory.newInstance();
		try {
			URL url = new URL("http://rss.cnn.com/rss/cnn_topstories.rss");
			URLConnection connection = url.openConnection();
			try { 
				XMLStreamReader streamReader =
					factory.createXMLStreamReader(connection.getInputStream());
				while(streamReader.hasNext()){
    				streamReader.next();
    				if(streamReader.getEventType() == XMLStreamReader.START_ELEMENT){
        				System.out.println(streamReader.getLocalName());
    				}
				}

			}
			catch(XMLStreamException e) {
				e.printStackTrace();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
