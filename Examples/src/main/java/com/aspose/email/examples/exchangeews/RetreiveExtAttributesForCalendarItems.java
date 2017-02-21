package com.aspose.email.examples.exchangeews;

import com.aspose.email.*;
import com.aspose.email.system.collections.generic.IGenericList;

import java.util.UUID;

/**
 * Created by hp on 2/20/2017.
 */
public class RetreiveExtAttributesForCalendarItems {

    public static void main(String[] args) {

        RetreiveExtAttributesForCalendarItems();
    }

    public static void RetreiveExtAttributesForCalendarItems()
    {
        //ExStart: RetreiveExtAttributesForCalendarItems
        IEWSClient client = EWSClient.getEWSClient("https://exchange.office365.com/Exchange.asmx", "username","password");

        java.util.List<String> uriList = java.util.Arrays.asList(client.listItems(client.getMailboxInfo().getCalendarUri()));

        //Define the Extended Attribute Property Descriptor for searching purpose
        //In this case, we have a K1 Long named property for Calendar item
        UUID uuid = UUID.fromString("00020329-0000-0000-C000-000000000046");
        PropertyDescriptor propertyDescriptor = new PidNamePropertyDescriptor("K1", PropertyDataType.Integer32, uuid);

        java.util.List<PropertyDescriptor> propertyDescriptors = java.util.Arrays.asList(new PropertyDescriptor[] { propertyDescriptor});
        IGenericList<MapiCalendar> mapiCalendarList = client.fetchMapiCalendar(uriList, propertyDescriptors);

        for (MapiCalendar cal: mapiCalendarList)
        {
            for (MapiNamedProperty namedProperty : (Iterable<MapiNamedProperty>) cal.getNamedProperties().getValues())
            {
                System.out.println(namedProperty.getNameId() + " = " + namedProperty.getInt32());
            }
        }
        //ExEnd: RetreiveExtAttributesForCalendarItems
    }
}
