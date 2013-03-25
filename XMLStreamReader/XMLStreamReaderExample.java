//http://tutorials.jenkov.com/java-xml/stax-xmlstreamreader.html

import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class XMLStreamReaderExample {

	public static void main(String [] args) {

		XMLInputFactory factory = XMLInputFactory.newInstance();

		try {
			URL url = new URL("http://comuppets.host56.com/?feed=rss2");
			URLConnection connection = url.openConnection();

			try { 
				XMLStreamReader streamReader =
					factory.createXMLStreamReader(connection.getInputStream());

				boolean inItemElement = false;
				boolean inHeader = true;
				String[] rssTags = {"title", "link", "description"};

				while(streamReader.hasNext()){
					
    				streamReader.next();
    				if(streamReader.getEventType() == XMLStreamReader.START_ELEMENT) {
						if (Arrays.asList(rssTags).contains(streamReader.getLocalName())
								&& inHeader == true) {
							inItemElement = true;
							try {        				
								System.out.println(streamReader.getElementText());
							}
							catch(XMLStreamException e) {
							}
						}
						if(streamReader.getLocalName() == "item") {
							inHeader = false;
						}
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
