package com.cos.myapplication4;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ChatFragment extends Fragment {

    private ChatAdapter chatAdapter;
    private RecyclerView rvChatList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frament_chat,container,false);
        rvChatList = view.findViewById(R.id.rv_chat_list);

        List<Chat> chats = new ArrayList<>();
        chats.add(new Chat(1, R.drawable.sangha, "상하", "오빠야 뭐해 ??", "5시간전"));
        chats.add(new Chat(2, R.drawable.sangha, "상하2", "오빠야 뭐하냐고 ??", "2시간전"));
        chats.add(new Chat(4, R.drawable.sangha, "상하3", "오빠야 뭐하냐!!!", "14시간전"));
        chats.add(new Chat(5, R.drawable.sangha, "상하4", "야", "3시간전"));
        chats.add(new Chat(6, R.drawable.sangha, "상하5", "호?", "2시간전"));
        chats.add(new Chat(7, R.drawable.sangha, "상하6", "랑", "1시간전"));
        chats.add(new Chat(8, R.drawable.sangha, "상하7", "나", "10시간전"));
        chats.add(new Chat(9, R.drawable.sangha, "상하8", "비", "9시간전"));
        chats.add(new Chat(10, R.drawable.sangha, "상하9", "야", "8시간전"));
        chats.add(new Chat(11, R.drawable.sangha, "상하10", "오빠야 뭐해 ??", "7시간전"));
        chats.add(new Chat(12, R.drawable.sangha, "상하11", "오빠야 뭐해 ??", "6시간전"));

        LinearLayoutManager manager = new LinearLayoutManager(container.getContext(), RecyclerView.VERTICAL, false);

        rvChatList.setLayoutManager(manager);
        chatAdapter = new ChatAdapter(chats);
        rvChatList.setAdapter(chatAdapter);

        return view;


    }
}
