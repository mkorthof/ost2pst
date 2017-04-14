package com.aspose.email.examples.outlook.msg;

import java.util.UUID;

import com.aspose.email.MapiMessage;
import com.aspose.email.MapiNamedProperty;
import com.aspose.email.MapiProperty;
import com.aspose.email.MapiPropertyType;
import com.aspose.email.system.BitConverter;
import com.aspose.email.system.collections.ArrayList;
import com.aspose.email.system.collections.IList;

public class SetAdditionalMAPIProperties {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//ExStart: SetAdditionalProperties
		// PT_MV_FLOAT, PT_MV_R4, mv.float
		MapiMessage msg = new MapiMessage();
		IList values = (IList) new ArrayList();
		values.addItem((float) 1);
		values.addItem((float) 2);
		msg.setProperty(new MapiProperty(0x23901004, values));

		//PT_MV_DOUBLE, PT_MV_R8
		values = (IList) new ArrayList();
		values.addItem((double) 1);
		values.addItem((double) 2);
		msg.setProperty(new MapiProperty(0x23901005, values));

		//PT_MV_APPTIME
		values = (IList) new ArrayList();
		values.addItem(30456.34);
		values.addItem(40655.45);
		msg.setProperty(new MapiProperty(0x23901007, values));

		//PT_MV_I8, PT_MV_LONGLONG
		values = (IList) new ArrayList();
		values.addItem((long) 30456);
		values.addItem((long) 40655);
		msg.setProperty(new MapiProperty(0x23901014, values));

		//PT_MV_SHORT, PT_MV_I2, mv.i2
		values = (IList) new ArrayList();
		values.addItem((short) 1);
		values.addItem((short) 2);
		msg.setProperty(new MapiProperty(0x23901002, values));

		//PT_MV_BOOLEAN
		values = (IList) new ArrayList();
		values.addItem(true);
		values.addItem(false);
		msg.setProperty(new MapiProperty(0x2390100b, values));

		//PT_NULL
		msg.setProperty(new MapiProperty(0x67400001, new byte[1]));

		//PT_MV_LONG
		values = (IList) new ArrayList();
		values.addItem((int) 4);

		UUID uuid = UUID.randomUUID();
		MapiProperty property = new MapiProperty(msg.getNamedPropertyMapping().getNextAvailablePropertyId(MapiPropertyType.PT_MV_LONG), values);
		msg.getNamedPropertyMapping().addNamedPropertyMapping(property, 0x00008028, uuid);
		msg.setProperty(property);

		//OR you can set the custom property (with the custom name)
		MapiMessage message = new MapiMessage("sender@test.com", "recipient@test.com", "subj", "Body of test msg");

		values = (IList) new ArrayList();
		values.addItem((int) 4);

		property = new MapiProperty(message.getNamedPropertyMapping().getNextAvailablePropertyId(MapiPropertyType.PT_MV_LONG), values);

		message.addCustomProperty(property, "customProperty");
		
		//PT_FLOAT
		//Please note that you need explicit cast to float value for this to work
		float floatValue = 123.456F;
		MapiMessage newMsg = new MapiMessage();
		long floatTag = newMsg.getNamedPropertyMapping().getNextAvailablePropertyId(MapiPropertyType.PT_FLOAT);
		UUID guid = UUID.randomUUID();
		MapiProperty newMapiProperty = new MapiProperty(floatTag, BitConverter.getBytesSingle(floatValue));
		newMsg.getNamedPropertyMapping().addNamedPropertyMapping(newMapiProperty,(long) 12, guid);
		newMsg.setProperty(newMapiProperty);

		boolean propertyIsOk = false;
		for (MapiNamedProperty prop : (Iterable<MapiNamedProperty>) newMsg.getNamedProperties().getValues())
		{
		    if (prop.getGuid().equals(guid))
		    {
		        float val = prop.getFloat();
		        propertyIsOk = val == floatValue;
		    }
		}
		//ExEnd: SetAdditionalProperties
	}

}
