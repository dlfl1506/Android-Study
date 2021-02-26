package com.cos.firestoreapp.service;

import android.util.Log;

import androidx.annotation.NonNull;

import com.cos.firestoreapp.model.Board;
import com.cos.firestoreapp.model.BoardDetailDto;
import com.cos.firestoreapp.model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class BoardService {

    private static final String TAG = "BoardService";
    private FirebaseFirestore db;

    public BoardService() {
        db = FirebaseFirestore.getInstance();
    }

    public void boardDetail(MyCallback myCallback){

        BoardDetailDto dto = new BoardDetailDto();
        DocumentReference docRef = db.collection("board").document("uAISMBVwaomO4b5GdM3p");

        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        Board board = task.getResult().toObject(Board.class);
                        String userId = board.getUserId();

                        dto.setBoard(board);

                        /////////////////////////////////////////////////////////////////////
                        DocumentReference docRef = db.collection("users").document(userId);
                        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                                if (task.isSuccessful()) {
                                    DocumentSnapshot document = task.getResult();
                                    if (document.exists()) {
                                        User user = task.getResult().toObject(User.class);

                                        dto.setUser(user);
                                        myCallback.back(dto);

                                        //Log.d(TAG, "dto " + dto);
                                    } else {
                                        //Log.d(TAG, "No such document");
                                    }
                                } else {
                                    //Log.d(TAG, "get failed with ", task.getException());
                                }
                            }
                        });
                        /////////////////////////////////////////////////////////////////////



                        //Log.d(TAG, "DocumentSnapshot data: " + document.getData());
                    } else {
                        //Log.d(TAG, "No such document");
                    }
                } else {
                    //Log.d(TAG, "get failed with ", task.getException());
                }
            }
        });
    }

    public void boardAll(){
        db.collection("board")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {

                        List<Board> boards = new ArrayList<>();

                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Board board = document.toObject(Board.class);
                                board.setId(document.getId());
                                boards.add(board);
                            }
                            Log.d(TAG, "onComplete: board : "+boards);
                        } else {
                            Log.d(TAG, "Error getting documents: ", task.getException());
                        }
                    }
                });
    }


    public void readTest(){
        db.collection("users")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {

                        //List<User> users = task.getResult().toObjects(User.class);

                        List<User> users = new ArrayList<>();

                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                User user = document.toObject(User.class);
                                user.setId(document.getId());
                                users.add(user);
                            }
                            Log.d(TAG, "onComplete: user : "+users);
                        } else {
                            Log.d(TAG, "Error getting documents: ", task.getException());
                        }
                    }
                });

    }

    public void dbUpdate(){
        DocumentReference washingtonRef = db.collection("users").document("yeJHjl9eDxhqBTVvpz55");

        // Set the "isCapital" field of the city 'DC'
        washingtonRef
                .update("phone", "0108888")
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d(TAG, "DocumentSnapshot successfully updated!");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error updating document", e);
                    }
                });
    }


    public void dbSaveOrUpdate(){

        User user = new User(null, "cos", "1234", "0102222");

        db.collection("users").document("yeJHjl9eDxhqBTVvpz55")
                .set(user)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d(TAG, "DocumentSnapshot successfully written!");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error writing document", e);
                    }
                });
    }

    public void dbReadAll(){
        db.collection("users")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            List<User> users = task.getResult().toObjects(User.class);

                            Log.d(TAG, "onComplete: users : "+users);
                            // user를 어뎁터에 던지면 됨
                        } else {
                            Log.w(TAG, "Error getting documents.", task.getException());
                        }
                    }
                });
    }

    public void dbSave() {
//        Map<String, Object> user = new HashMap<>();
//        user.put("first", "Ada");
//        user.put("last", "Lovelace");
//        user.put("born", 1815);

        User user = new User(null,"ssar", "1234", "0102222");


        // Add a new document with a generated ID
        db.collection("users")
                .add(user)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error adding document", e);
                    }
                });
    }
}