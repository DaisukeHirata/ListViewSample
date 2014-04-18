package com.example.listviewsample;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		private View rootView;

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			this.rootView = rootView;
		
			//setListener();
			
			setUpEmailList();
			
			return rootView;
		}

		private void setUpEmailList() {
			
			// Retrieve these message from somewhere ...
			List<Message> messages = new ArrayList<Message>();
			
			messages.add(new Message(0, "Bob Smith", "My Cat has gone missing."));
			messages.add(new Message(1, "Sue Blake", "Special Offer"));
			messages.add(new Message(2, "Mike Peters", "Read any good books?"));
			messages.add(new Message(3, "Sarah Rogers", "Is the canteen on fire?"));
		
			MessageAdapter adapter = new MessageAdapter(messages);
			
			ListView listView = (ListView)rootView.findViewById(R.id.list);

			listView.setAdapter(adapter);	
			
			// Handle OnItemClick ... 
			
		}

		private void setListener() {

			String[] values = getResources().getStringArray(
					R.array.list_options);
			
			values[0] = "Zeus";

			ArrayAdapter<String> adapter = new ArrayAdapter<String>(
					getActivity(),
					android.R.layout.simple_expandable_list_item_1, values);

			ListView list = (ListView) rootView.findViewById(R.id.list);
			
			list.setAdapter(adapter);
			
			list.setOnItemClickListener(new OnItemClickListener() {
				public void onItemClick(AdapterView<?> adapter, View arg1,
						int pos, long arg3) {
					Toast.makeText(
							getActivity(),
							"Pos: " + pos + ": value: "
									+ adapter.getItemAtPosition(pos),
							Toast.LENGTH_SHORT).show();
				}
			});
		}
	}

}
