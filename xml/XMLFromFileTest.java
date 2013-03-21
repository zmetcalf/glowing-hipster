public class XMLFromFileTest {

	public static void main(String [] args) {
		XMLFromFile xmler = new XMLFromFile("test.xml");
		System.out.println(xmler.getXmlElement());
	}
}
