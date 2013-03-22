import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class XMLFromFile {

	private String xmlElement;

	public XMLFromFile(String xmlFile) {
		try {
			loadXMLFileURL(xmlFile);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getXmlElement() {
		return xmlElement;
	}
	
	private void loadXMLFileURL(String urlAddress) throws Exception {
		URL url = new URL(urlAddress);
		URLConnection connection = url.openConnection();
		
		Document doc = parseXML(connection.getInputStream()); //Document represents HTML/XML 
		NodeList docNodes = doc.getElementsByTagName("title");

		for(int i = 0; i < docNodes.getLength(); i++) {
			System.out.println(docNodes.item(i).getTextContent());
		}
	}

	private Document parseXML(InputStream stream) throws Exception {
		DocumentBuilderFactory objDocumentBuilderFactory = null;
		DocumentBuilder objDocumentBuilder = null;
		Document doc = null;
       	try
        {
        	objDocumentBuilderFactory = DocumentBuilderFactory.newInstance();
            objDocumentBuilder = objDocumentBuilderFactory.newDocumentBuilder();

            doc = objDocumentBuilder.parse(stream);
        }
        catch(Exception ex)
        {
            throw ex;
        }       
        return doc;
    }
	
}
