import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Element;


public class WriteXMLProject {
	
	private List<String> peerList = new ArrayList<String>();
	private List<String> sectionList = new ArrayList<String>();
	
	
	
	public WriteXMLProject(List<String> peerList,List<String> sectionList) throws TransformerException
	{
		this.peerList = peerList;
		this.sectionList = sectionList;
		SetupXML();
	}
	
	
	
	
	public void SetupXML() throws TransformerException{
		
		String element = "Headline";
		
		try 
		{
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			
			org.w3c.dom.Document doc = docBuilder.newDocument();
			
			
			
			//create root element for XML
			Element rootElement = doc.createElement(element);
			doc.appendChild(rootElement);
			
			//create project element, which is a sub-element of rooElement
			Element project = doc.createElement("projectName");
			rootElement.appendChild(project);
			//set id for the project element
			Attr attr = doc.createAttribute("id");
			attr.setValue("projectid");
			project.setAttributeNode(attr);
			
			Element projectPath = doc.createElement("projectPath");
			projectPath.appendChild(doc.createTextNode("this is the project path"));
			project.appendChild(projectPath);
			
			
			Element Peer = doc.createElement("Peer");
			rootElement.appendChild(Peer);
			Attr peerAttr = doc.createAttribute("id");
			peerAttr.setValue("peers");
			Peer.setAttributeNode(peerAttr);
			
			//create for loop here for peer-----
			
			for(int i=0;i<peerList.size();i++)
			{
				
				Element PeerName = doc.createElement("PeerName");
				PeerName.appendChild(doc.createTextNode(peerList.get(i)));
				Peer.appendChild(PeerName);
				Attr peerNameAttr = doc.createAttribute("id");
				peerNameAttr.setValue(""+i);
				PeerName.setAttributeNode(peerNameAttr);
			}
			
			
			
			
			Element Section = doc.createElement("Section");
			rootElement.appendChild(Section);
			Attr sectionAttr = doc.createAttribute("id");
			sectionAttr.setValue("sections");
			Section.setAttributeNode(sectionAttr);
			
			//create for loop here for section
			
			for(int i=0;i<sectionList.size();i++)
			{
				Element sectionName = doc.createElement("SectionName");
				sectionName.appendChild(doc.createTextNode(sectionList.get(i)));
				Section.appendChild(sectionName);
				Attr sectionNameAttr = doc.createAttribute("id");
				sectionNameAttr.setValue(""+i);
				sectionName.setAttributeNode(sectionNameAttr);
			}
			
			TransformerFactory transformerFactory  = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			/*StreamResult result = new StreamResult(System.out);*/
			StreamResult result = new StreamResult(new File("file.xml"));
			transformer.transform(source, result);
		}
		catch (ParserConfigurationException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
