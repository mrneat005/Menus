package com.example.menus;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.os.Bundle;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener{
    private Toast t1;
    private  Button contextMenuButton,contexualActionBarButton,popupButton;
    private ActionMode actionMode=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.mytoolbar);
        setSupportActionBar(toolbar);

        contextMenuButton = findViewById(R.id.contextMenuButton);
        contexualActionBarButton = findViewById(R.id.contextActionBarButton);

        contexualActionBarButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                if(actionMode!=null)
                {
                    return false;

                }
                actionMode = startActionMode(mAck);

                return true;
            }
        });


        popupButton = findViewById(R.id.popUpButton);
        popupButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                PopupMenu pop = new PopupMenu(popupButton.getContext(),v);
                pop.setOnMenuItemClickListener(MainActivity.this::onContextItemSelected);
                MenuInflater inflater = pop.getMenuInflater();
                inflater.inflate(R.menu.popup_menu,pop.getMenu());
                pop.show();
                return false;
            }
        });
        registerForContextMenu(contextMenuButton);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.copy: {



                Toast.makeText(this, "Copy Buttton in Context Menu is clicked...!", Toast.LENGTH_SHORT).show();
                return true;
            }
            case R.id.paste: {
                Toast.makeText(this, "paste Buttton in Context Menu is clicked...!", Toast.LENGTH_SHORT).show();
                return true;
            }
            case R.id.delete: {
                Toast.makeText(this, "delete Buttton in Context Menu is clicked...!", Toast.LENGTH_SHORT).show();
                return true;
            }
            default:
                return true;

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.myappbarmenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        ConstraintLayout myLayout = (ConstraintLayout) findViewById(R.id.myConstraintLayout);
        switch (item.getItemId())
        {
            case R.id.search: {
                Toast.makeText(this,"Search Button in the ActionBar is clicked...!",Toast.LENGTH_SHORT).show();
                return true;
            }
            case R.id.Blue: {
                if (item.isChecked()) {
                    item.setChecked(false);
                } else {
                    item.setChecked(true);
                }
                myLayout.setBackgroundColor(Color.BLUE);
                return true;
            }
            case R.id.Settings: {
                Toast.makeText(this,"Settings Button in the ActionBar is clicked...!",Toast.LENGTH_SHORT).show();
                 return true;
            }
            case R.id.Green: {
                if (item.isChecked()) {
                    item.setChecked(false);
                } else {
                    item.setChecked(true);
                }
                myLayout.setBackgroundColor(Color.GREEN);
                return true;
            }
            case R.id.Red: {
                if (item.isChecked()) {
                    item.setChecked(false);
                } else {
                    item.setChecked(true);
                }
                myLayout.setBackgroundColor(Color.RED);
                return true;
            }
            case R.id.cast: {
                Toast.makeText(this,"Cast Button in the ActionBar is clicked...!",Toast.LENGTH_SHORT).show();
                return true;
            }
            case R.id.Exit:{
                System.exit(0);
                return true;
            }
            default:
            {
                return super.onOptionsItemSelected(item);
            }
        }
}
private ActionMode.Callback mAck = new ActionMode.Callback() {
    @Override
    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
        MenuInflater inflater = mode.getMenuInflater();
        inflater.inflate(R.menu.contextual_action_bar_menu,menu);
        return true;
    }

    @Override
    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {

        return false;
    }

    @Override
    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.share: {
                showmessage("contentshared...!");
                mode.finish();
                return true;
            }
            case R.id.post: {
                showmessage("content posted...!");
                mode.finish();
                return true;
            }
        }
        return false;
    }

    @Override
    public void onDestroyActionMode(ActionMode mode) {
      actionMode=null;
    }
};

protected void showmessage(String s)
{
    Toast.makeText(this,s,Toast.LENGTH_SHORT).show();
}

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.copy0: {
                Toast.makeText(this, "Copy Buttton in popup Menu is clicked...!", Toast.LENGTH_SHORT).show();
                return true;
            }
            case R.id.paste0: {
                Toast.makeText(this, "paste Buttton in popup Menu is clicked...!", Toast.LENGTH_SHORT).show();
                return true;
            }
            case R.id.delete0: {
                Toast.makeText(this, "delete Buttton in popup Menu is clicked...!", Toast.LENGTH_SHORT).show();
                return true;
            }
            default:
                return true;
        }
    }
}