package com.example.jorexa.landlordapp.chat;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jorexa.landlordapp.R;
import com.example.jorexa.landlordapp.models.ChatMessage;
import com.example.jorexa.landlordapp.models.LoginUser;
import com.example.jorexa.landlordapp.models.Property;
import com.example.jorexa.landlordapp.propertyDetails.propertyDetailsContracts;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class chatFragment extends Fragment implements chatContracts.View {

    private chatContracts.Presenter mPresenter;

    @BindView(R.id.tv_chat_title)
    TextView mChatTitle;

    @BindView(R.id.ed_message)
    EditText mNewMessage;

    @BindView(R.id.lv_chatMessages)
    ListView mChatListView;

    @Inject
    ArrayAdapter<ChatMessage> mChatAdapter;

    @Inject
    public chatFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_chat, container, false);

        ButterKnife.bind(this, view);

        mChatListView.setAdapter(mChatAdapter);

        return view;
    }

    @Override
    public void setPresenter(chatContracts.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showCustomException(String text) {

    }

    @Override
    public void setChatTitle(LoginUser mainUser) {
        runOnUi(() -> {
            String userTypeName = "";
                if(mainUser.getUserType() == 1) {
                    userTypeName = "landlord";
                } else if (mainUser.getUserType() == 2) {
                    userTypeName = "tenant";
                }
                String titleMessage = "Chat with " + mainUser.getFirstName() + " " + mainUser.getLastName() + " your " + userTypeName;
                mChatTitle.setText(titleMessage);
         });
    }

    @Override
    public void showMessages(List<ChatMessage> chat) {
        runOnUi(() -> {
            mChatAdapter.addAll(chat);
            mChatListView.setSelection(mChatListView.getCount() - 1);
        });
    }

    @Override
    public void onResume(){
        super.onResume();
        mPresenter.subscribe(this);
    }

    @Override
    public void stopChat() {
        mPresenter.stopChat();
    }

    @Override
    public void startAgain() {
        mPresenter.showMessages(0);
    }

    @Override
    public void showError(Exception e) {

    }

    @OnClick(R.id.btn_send_messsage)
    public void testButton() {
        String newMessage = mNewMessage.getText().toString();
        mNewMessage.getText().clear();
        mPresenter.sendMessage(newMessage);
    }

    private void runOnUi(Runnable action) {
        getActivity().runOnUiThread(action);
    }

}
