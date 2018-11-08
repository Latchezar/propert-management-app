package com.example.jorexa.landlordapp.chat;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.jorexa.landlordapp.R;
import com.example.jorexa.landlordapp.models.ChatMessage;
import com.example.jorexa.landlordapp.models.LoginUser;
import com.example.jorexa.landlordapp.models.Property;

import javax.inject.Inject;

public class chatListAdapter extends ArrayAdapter<ChatMessage> {
    @Inject
    public chatListAdapter(@NonNull Context context) {
        super(context, -1);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater =
                (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = layoutInflater.inflate(
                R.layout.messages,
                parent,
                false
        );

        TextView senderName = view.findViewById(R.id.tv_chat_name);
        TextView timeStamp = view.findViewById(R.id.tv_chat_timestamp);

        ChatMessage message = getItem(position);

        //dd/MM/yyyy hh:mm:ss

        senderName.setText(message.getMessageText());
        String dateTime = message.getMessageID()+"";
        dateTime = convertDate(dateTime,"hh:mm:ss");
        timeStamp.setText(dateTime);

        return view;
     }

    public static String convertDate(String dateInMilliseconds,String dateFormat) {
        return DateFormat.format(dateFormat, Long.parseLong(dateInMilliseconds)).toString();
    }
}


