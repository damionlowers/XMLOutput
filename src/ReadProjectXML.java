import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class ReadProjectXML {
	
	private List<String> peerList = new ArrayList<String>();
	private List<String> sectionList = new ArrayList<String>();
	File fXmlFile;
	
	
	
	
	public ReadProjectXML() throws ParserConfigurationException, SAXException, IOException 
	{
		fXmlFile = new File("file.xml");
		readXML();
	 
	}
	
	
	public void readXML()throws ParserConfigurationException, SAXException, IOException
	{
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);
				doc.getDocumentElement().normalize();
			 
				System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			 
				
				NodeList nList = doc.getElementsByTagName("Peer");
				NodeList SecNodeList = doc.getElementsByTagName("Section");
			 
			 
				for (int temp = 0; temp < nList.getLength(); temp++) {
			 
					Node nNode = nList.item(temp);
			 
					//System.out.println("\nCurrent Element :" + peerNode.getNodeName());
			 
					if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			 
						Element eElement = (Element) nNode;
						
						int PeerListLength = eElement.getElementsByTagName("PeerName").getLength();

						
						for(int i=0;i<PeerListLength;i++)
						{
							peerList.add(eElement.getElementsByTagName("PeerName").item(i).getTextContent());
							//System.out.println(eElement.getElementsByTagName("PeerName").item(i).getTextContent());
						}
					}
				}
				
				for(int temp = 0;temp<SecNodeList.getLength();temp++)
				{
					Node secNode = SecNodeList.item(temp);
					//System.out.println("\nCurrent Element :" + secNode.getNodeName());
					if(secNode.getNodeType() == Node.ELEMENT_NODE)
					{
						Element element = (Element) secNode;
						int sectionListLength = element.getElementsByTagName("SectionName").getLength();
						
						for(int i=0;i<sectionListLength;i++)
						{
							sectionList.add(element.getElementsByTagName("SectionName").item(i).getTextContent());
							//System.out.println(element.getElementsByTagName("SectionName").item(i).getTextContent());
						}
					}
				}
	}
	
	public List<String> getSectionList()
	{
		return sectionList;
	}
	
	public List<String> getPeerList()
	{
		return peerList;
	}

}
