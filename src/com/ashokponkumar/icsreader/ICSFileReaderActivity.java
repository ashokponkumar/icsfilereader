/**
 * 
 */
package com.ashokponkumar.icsreader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.fortuna.ical4j.data.ParserException;
import net.fortuna.ical4j.model.Calendar;
import net.fortuna.ical4j.model.Component;
import net.fortuna.ical4j.model.Property;
import net.fortuna.ical4j.model.TimeZoneRegistry;
import net.fortuna.ical4j.model.TimeZoneRegistryFactory;
import net.fortuna.ical4j.util.CompatibilityHints;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toast;

/**
 * @author ashokponkumar
 * 
 */
public class ICSFileReaderActivity extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.icsfileview);

		Intent intent = getIntent();
		String fileUri = intent.getData().toString();
		File file = new File(fileUri.substring(7));
		try {
			// BufferedReader br = new BufferedReader(new InputStreamReader(
			// new FileInputStream(file)));
			List<String> strings = new ArrayList<String>();
			// strings.add(br.readLine() + " Text");

			CompatibilityHints.setHintEnabled(
					CompatibilityHints.KEY_NOTES_COMPATIBILITY, true);
			CompatibilityHints.setHintEnabled(
					CompatibilityHints.KEY_RELAXED_VALIDATION, true);
			CompatibilityHints.setHintEnabled(
					CompatibilityHints.KEY_RELAXED_PARSING, true);
			CompatibilityHints.setHintEnabled(
					CompatibilityHints.KEY_RELAXED_UNFOLDING, true);
			TimeZoneRegistry tzr = TimeZoneRegistryFactory.getInstance()
					.createRegistry();
			MyCalendarBuilder cb = new MyCalendarBuilder(tzr);
			Calendar calendar = cb.build(new FileInputStream(file));

			for (Iterator i = calendar.getComponents().iterator(); i.hasNext();) {
				Component component = (Component) i.next();
				String entry = "Component [" + component.getName() + "]";

				for (Iterator j = component.getProperties().iterator(); j
						.hasNext();) {
					Property property = (Property) j.next();
					entry += "Property [" + property.getName() + ", "
							+ property.getValue() + "]";
				}
				strings.add(entry);
			}

			// parseICSFile(br);

			ArrayAdapter<String> icsFilesAdapter = new ArrayAdapter<String>(
					this, R.layout.icsfileitem, strings);
			setListAdapter(icsFilesAdapter);
		} catch (FileNotFoundException e) {
			Toast.makeText(this, "File Not Found", Toast.LENGTH_SHORT).show();
		} catch (IOException e) {
			Toast.makeText(this, "Unable to Read File", Toast.LENGTH_SHORT)
					.show();
		} catch (ParserException e) {
			Toast.makeText(this, "Invalid ICS File Format", Toast.LENGTH_SHORT)
					.show();
			e.printStackTrace();
		}
	}
	// private Map<Integer, Map<Integer, Map<Integer, List<CalendarEntry>>>>
	// parseICSFile(
	// BufferedReader br) {
	//		
	//		
	// Map<Integer, Map<Integer, Map<Integer, List<CalendarEntry>>>> yearMap =
	// new HashMap<Integer, Map<Integer, Map<Integer, List<CalendarEntry>>>>();
	// Map<>getTimeZones(br);
	// getCalendarEntry(br);
	// return yearMap;
	// }
}
