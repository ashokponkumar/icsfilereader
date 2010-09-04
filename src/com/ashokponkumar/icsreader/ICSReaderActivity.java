package com.ashokponkumar.icsreader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

/**
 * @author ashokponkumar
 * 
 */
public class ICSReaderActivity extends ListActivity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		setTitle("ICS Files");

		List<String> icsFiles = getICSFilesInSDCard();

		if (icsFiles.size() > 0) {
			ArrayAdapter<String> icsFilesAdapter = new ArrayAdapter<String>(
					this, R.layout.icsfileitem, icsFiles);
			setListAdapter(icsFilesAdapter);
		}
	}

	private List<String> getICSFilesInSDCard() {
		File file = new File("/sdcard/");
		File[] icsFiles = file.listFiles(new ICSFilesFilter());
		List<String> icsFileNames = new ArrayList<String>();
		for (File icsFile : icsFiles) {
			icsFileNames.add(icsFile.getName());
		}
		return icsFileNames;
	}
}