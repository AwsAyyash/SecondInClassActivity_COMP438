package edu.cs.mobile438.secondinclass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

import com.google.gson.Gson;

import java.util.List;

import edu.cs.mobile438.secondinclass.model.Book;
import edu.cs.mobile438.secondinclass.model.BookService;
import edu.cs.mobile438.secondinclass.model.BookServiceDA;


public class MainActivity extends AppCompatActivity {

    private EditText editTextTitle;
    private EditText editTextAuthor;
    private EditText editTextPages;
    private Switch availableSwitch;


    private Button addButton;
    private Button saveAllButton;

    private BookService bookServiceDA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        setUpViews();


        bookServiceDA = new BookServiceDA();


        addButton.setOnClickListener(view -> {

            addBook();

        });

        saveAllButton.setOnClickListener(view -> {

            saveAllBooks();

        });

    }

    private void setUpViews() {

        editTextTitle = findViewById(R.id.editTextTitle);
        editTextAuthor = findViewById(R.id.editTextAutherName);
        editTextPages = findViewById(R.id.editTextPages);


        availableSwitch = findViewById(R.id.switchAvailable);
        addButton = findViewById(R.id.buttonAdd);
        saveAllButton = findViewById(R.id.buttonSaveAll);


    }

    private void saveAllBooks() {

        List<Book> arrayListBooks = bookServiceDA.getBooks();


        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        SharedPreferences.Editor editor = prefs.edit();

        Gson gson = new Gson();
        String booksStringJSON = gson.toJson(arrayListBooks);
        editor.putString("DATAJSON", booksStringJSON);
        editor.commit();

    }

    private void addBook() {

        boolean isActivated = availableSwitch.isChecked();


        Book book = new Book(editTextTitle.getText().toString().trim(),
                editTextAuthor.getText().toString().trim(),
                Integer.parseInt(editTextPages.getText().toString().trim()),
                isActivated
        );

        bookServiceDA.addBook(book);

    }
}