package com.example.listviewsample;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

public class MessageAdapter extends BaseAdapter implements ListAdapter {

	private List<Message> messages;
	private Context context;

	public MessageAdapter(Context context, List<Message> messages) {
		super();
		this.messages = messages;
		this.context = context;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return messages.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return messages.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return messages.get(position).getId();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(context.LAYOUT_INFLATER_SERVICE);
		View view = inflater.inflate(R.layout.list_message_item, null);
		
		Message message = messages.get(position);
		String title = message.getTitle();
		String sender = message.getSender();
		
		TextView titleView = (TextView) view.findViewById(R.id.list_message_title);
		TextView senderView = (TextView) view.findViewById(R.id.list_message_sender);
		
		titleView.setText(title);
		senderView.setText(sender);

		return view;
	}

}
