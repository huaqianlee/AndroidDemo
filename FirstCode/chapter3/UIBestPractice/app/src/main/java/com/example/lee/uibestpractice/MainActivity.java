package com.example.lee.uibestpractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Msg> mMsgLists = new ArrayList<>();
    private EditText inputText;
    private Button send;
    private RecyclerView msgRecyclerView;
    private MsgAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            
        initMsgs();
        msgRecyclerView = (RecyclerView) findViewById(R.id.msg_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        msgRecyclerView.setLayoutManager(layoutManager);
        adapter = new MsgAdapter(mMsgLists);
        msgRecyclerView.setAdapter(adapter);

        send = (Button) findViewById(R.id.send);
        inputText = (EditText) findViewById(R.id.input_text);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = inputText.getText().toString();
                if (!"".equals(content)) {
                    Msg msg = new Msg(content,Msg.TYPE_SENT);
                    mMsgLists.add(msg);
                    adapter.notifyItemInserted(mMsgLists.size()-1);  // 刷新消息
                    msgRecyclerView.scrollToPosition(mMsgLists.size()-1); //listview 定位到最后一行
                    inputText.setText(""); // 清空输入框

                } else {
                    Toast.makeText(MainActivity.this, "The input text can not be emputy!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void initMsgs() {
        Msg msg1 = new Msg("Hello , this is msg1!", Msg.TYPE_RECEIVED);
        mMsgLists.add(msg1);
        Msg msg2 = new Msg("Hi, this is Msg2!",Msg.TYPE_SENT);
        mMsgLists.add(msg2);
        Msg msg3 = new Msg("Hey, this is Msg3!", Msg.TYPE_RECEIVED);
        mMsgLists.add(msg3);
    }
}
