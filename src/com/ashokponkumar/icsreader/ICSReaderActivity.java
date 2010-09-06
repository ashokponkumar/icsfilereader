package com.ashokponkumar.icsreader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * @author ashokponkumar
 * 
 */
public class ICSReaderActivity extends ListActivity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.icsfileslistview);
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
			icsFileNames.add(icsFile.getAbsolutePath());
		}
		return icsFileNames;
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		Intent intent = new Intent(Intent.ACTION_VIEW);
		intent.setDataAndType(Uri.fromFile(new File((String) l
				.getItemAtPosition(position))), "text/ics");
		// intent.setData(Uri.parse((String) l.getItemAtPosition(position)));
		this.startActivity(intent);
		Toast.makeText(this, (String) l.getItemAtPosition(position),
				Toast.LENGTH_SHORT).show();
	}
}