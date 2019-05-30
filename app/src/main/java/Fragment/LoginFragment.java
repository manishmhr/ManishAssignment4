package Fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.assignment3_manishmhr.DashboardActivity;
import com.example.assignment3_manishmhr.R;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link LoginFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link LoginFragment#newInstance} factory method to
 * create an instance of this fragment.
 */

public class LoginFragment extends Fragment {
    EditText etUsername, etPassword;
    Button btnLogin;
    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_login, container, false);

        etUsername = view.findViewById(R.id.etUsername);
        etPassword = view.findViewById(R.id.etPassword);
        btnLogin = view.findViewById(R.id.btnLogin);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"Welcome back",
                        Toast.LENGTH_SHORT).show();
                Login();
            }
        });
        return view;
    }
    private void Login(){
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("User", Context.MODE_PRIVATE);
        String Username =sharedPreferences.getString("username","");
        String Password =sharedPreferences.getString("password","");

        if(Username.equals(etUsername.getText().toString()) && Password.equals(etPassword.getText().toString())){
            Intent intent = new Intent(getContext(), DashboardActivity.class);
            startActivity(intent);
        }
        else {
            Toast.makeText(getContext(),"Incorrect Username or Password.",Toast.LENGTH_LONG).show();

        }
    }
}
