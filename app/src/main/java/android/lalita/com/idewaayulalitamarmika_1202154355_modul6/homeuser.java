package android.lalita.com.idewaayulalitamarmika_1202154355_modul6;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
*/
public class homeuser extends Fragment {
    //deklarasi variable
    AdapterP adapterPost;
    DatabaseReference nDatabaseRef;
    ArrayList<DatabasePost> list;
    RecyclerView newRecView;


    public homeuser() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_homeuser, container, false);
        //firebase instance
        nDatabaseRef = FirebaseDatabase.getInstance().getReference().child("post");
        //mebuat arraylist baru
        list = new ArrayList<>();
        //membuat adapter baru
        adapterPost = new AdapterP(list, this.getContext());
        //mengenali recycler view pada layout
        newRecView = view.findViewById(R.id.inirecyclerview);

        //menampilkan recycler view nya
        newRecView.setHasFixedSize(true);
        newRecView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        newRecView.setAdapter(adapterPost);

        //listener yang menghandle ketika nilai pada firebase berubah
        nDatabaseRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                    //mendapatkan nilai dari post saat ini
                    DatabasePost crnt = dataSnapshot.getValue(DatabasePost.class);
                    if(crnt.getUsr().equals(FirebaseAuth.getInstance().getCurrentUser().getEmail())){
                        crnt.key = dataSnapshot.getKey();
                        list.add(crnt);
                        adapterPost.notifyDataSetChanged();
                    }
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        return view;
    }
}

