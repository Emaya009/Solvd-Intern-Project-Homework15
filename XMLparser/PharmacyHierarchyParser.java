package pharmacy.XMLparser;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.Date;

public class PharmacyHierarchyParser {
        public static void main(String[] args) {
            try {
                // Create a DocumentBuilder
                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = factory.newDocumentBuilder();
                // Parse the XML file
                Document document = builder.parse("pharmacy.xml");
                // Get the root element
                Element root = document.getDocumentElement();
                // Get the pharmacy element
                Element pharmacyElement = (Element) root.getElementsByTagName("pharmacy").item(0);

                // Process the customer details
                NodeList customerList = pharmacyElement.getElementsByTagName("customer");
                for (int i = 0; i < customerList.getLength(); i++) {
                    Element customerElement = (Element) customerList.item(i);
                    int customerid = Integer.parseInt(customerElement.getElementsByTagName("id").item(0).getTextContent());
                    String customerName = customerElement.getElementsByTagName("name").item(0).getTextContent();
                    String customerAddress = customerElement.getElementsByTagName("address").item(0).getTextContent();
                    String customerCity = customerElement.getElementsByTagName("city").item(0).getTextContent();
                    String customerState = customerElement.getElementsByTagName("state").item(0).getTextContent();
                    int customerZip = Integer.parseInt(customerElement.getElementsByTagName("zip").item(0).getTextContent());
                    System.out.println("Customer Id: " + customerid);
                    System.out.println("Customer Name: " + customerName);
                    System.out.println("Customer Address: " + customerAddress);
                    System.out.println("City: " + customerCity);
                    System.out.println("State: " + customerState);
                    System.out.println("Zip: " + customerZip);

                    // Process the doctor details
                    NodeList doctorList = pharmacyElement.getElementsByTagName("doctor");
                    for (int j = 0; j < doctorList.getLength(); j++) {
                        Element doctorElement = (Element) doctorList.item(j);
                        int doctorId = Integer.parseInt(doctorElement.getElementsByTagName("id").item(0).getTextContent());
                        String doctorName = doctorElement.getElementsByTagName("name").item(0).getTextContent();
                        String speciality = doctorElement.getElementsByTagName("specialty").item(0).getTextContent();
                        System.out.println("Doctor Id: " + doctorId);
                        System.out.println("Doctor Name: " + doctorName);
                        System.out.println("Speciality " + speciality);
                    }
                }
                // Process the medicine ordered
                NodeList medicineOrdered = pharmacyElement.getElementsByTagName("medicine_order");
                for (int i = 0; i < medicineOrdered.getLength(); i++) {
                    Element medicine_orderElement = (Element) medicineOrdered.item(i);
                    int medicineId = Integer.parseInt(medicine_orderElement.getElementsByTagName("id").item(0).getTextContent());
                    int customerId = Integer.parseInt(medicine_orderElement.getElementsByTagName("customer_id").item(0).getTextContent());
                    int doctorId = Integer.parseInt(medicine_orderElement.getElementsByTagName("doctor_id").item(0).getTextContent());
                    Date orderDate = medicine_orderElement.getElementsByTagName("date").item(0).getNodeName();
                    System.out.println("Medicine Id: " + medicineId);
                    System.out.println("Customer Id: " + customerId);
                    System.out.println("Doctor Id: " + doctorId);
                    System.out.println("Date ordered: " + orderDate);
                }
                // Process the prescription items
                NodeList prescriptionItem = pharmacyElement.getElementsByTagName("prescription_item");
                for (int i = 0; i < prescriptionItem.getLength(); i++) {
                    Element prescription_itemElement = (Element) prescriptionItem.item(i);
                    int prescriptionId = Integer.parseInt(prescription_itemElement.getElementsByTagName("id").item(0).getTextContent());
                    int medicineOrderId = Integer.parseInt(prescription_itemElement.getElementsByTagName("medicine_order_id").item(0).getTextContent());
                    String drugName = prescription_itemElement.getElementsByTagName("drug_name").item(0).getTextContent();
                    String dosage = prescription_itemElement.getElementsByTagName("dosage").item(0).getTextContent();
                    System.out.println("Prescription Id: " + prescriptionId);
                    System.out.println("Medicine Order Id: " +medicineOrderId);
                    System.out.println("Drug Name: " + drugName);
                    System.out.println("Dosage: " + dosage);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

