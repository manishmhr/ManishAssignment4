package Fragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.assignment3_manishmhr.R;

import static android.content.Context.MODE_PRIVATE;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link RegisterFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link RegisterFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RegisterFragment extends Fragment {

    private EditText etUsername, etPassword, etConfirmPassword;
    private Button btnRegister;

    public RegisterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_reg, container, false);
        etUsername = view.findViewById(R.id.etUsername);
        etPassword = view.findViewById(R.id.etPassword);
        etConfirmPassword = view.findViewById(R.id.etConfirmPassword);
        btnRegister = view.findViewById(R.id.btnRegister);


        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Register();
            }
        });
        return view;
    }

    private void Register() {

        if (etPassword.getText().toString().equals(etConfirmPassword.getText().toString())) {
            SharedPreferences sharedPreferences = getContext().getSharedPreferences("User",MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();

            editor.putString("username", etUsername.getText().toString());
            editor.putString("password", etPassword.getText().toString());
            editor.commit();
            Toast.makeText(getContext(), "Registration Successful", Toast.LENGTH_LONG).show();

        } else {
            etPassword.setText("");
            etConfirmPassword.setText("");
            Toast.makeText(getContext(), "Password Do Not Match", Toast.LENGTH_LONG).show();
        }


    }
}
