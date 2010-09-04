package com.ashokponkumar.icsreader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ICSReaderActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        setTitle("ICS File Viewer");
    }
    
    public void onOpenFile (View view)
    {
    	EditText text=(EditText)findViewById(R.id.EditText01);
    	String fileName=text.getText().toString();
    	try {
    		File file=getFileStreamPath(fileName);
			FileInputStream fis=new FileInputStream(file);
			BufferedReader br=new BufferedReader(new InputStreamReader(fis));
	    	text.setText(br.readLine());
		} catch (FileNotFoundException e) {
			Toast.makeText(this, "File Not Found", Toast.LENGTH_SHORT).show();
			return;
		} catch (IOException e) {
			Toast.makeText(this, "Unable To Read File", Toast.LENGTH_SHORT).show();
			return;
		}
    	
    }
}