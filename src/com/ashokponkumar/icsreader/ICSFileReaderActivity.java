/**
 * 
 */
package com.ashokponkumar.icsreader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

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
		String fileName = intent.getData().toString();
		File file = new File(fileName);
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					new FileInputStream(file)));
			List<String> strings = new ArrayList<String>();
			strings.add(br.readLine() + " Text");

			ArrayAdapter<String> icsFilesAdapter = new ArrayAdapter<String>(
					this, R.layout.icsfileitem, strings);
			setListAdapter(icsFilesAdapter);
		} catch (FileNotFoundException e) {
			Toast.makeText(this, "File Not Found", Toast.LENGTH_SHORT).show();
		} catch (IOException e) {
			Toast.makeText(this, "Unable to Read File", Toast.LENGTH_SHORT)
					.show();
		}

	}
}
