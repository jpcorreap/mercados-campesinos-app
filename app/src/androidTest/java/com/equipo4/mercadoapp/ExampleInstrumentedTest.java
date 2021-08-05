package com.equipo4.mercadoapp;

import android.content.Context;

import androidx.test.filters.LargeTest;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.equipo4.mercadoapp.model.User;
import com.equipo4.mercadoapp.sqlite.OpenHelper;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class ExampleInstrumentedTest {

    private OpenHelper helper;

    @Before
    public void setup(){
        helper = new OpenHelper(InstrumentationRegistry.getInstrumentation().getTargetContext());
        helper.openDB();
    }
    @After
    public void finish(){
        helper.closeDB();
    }

    @Test
    public void validateNull(){
        assertNotNull(helper);
    }

    @Test
    public void insertUser(){
        //Test to ensure a new user is created
        User user = new User("Pepito Perez", "Pepito35", "pepito35@hotmail.com",
                "prueba51","3101234567");
        long rows = helper.insert(User.TABLE, user.getContentValues());
        assertNotEquals(-1, rows);
    }

    @Test
    public void negateInsertUser(){
        //Test to prove the db doesn't allow username or email repetitions
        User user = new User("Pepito Perez", "Pepito35", "pepito35@hotmail.com",
                "prueba51","3101234567");
        long rows = helper.insert(User.TABLE, user.getContentValues());
        assertEquals(rows, -1);
    }
}