package com.samir.andrew.stmarkkidneycenter.singleton;

/**
 * Created by ksi on 03-Jul-17.
 */

public class SingletonKidneyCenter
{

    private static SingletonKidneyCenter mInstance = null;

    private String personId;

    private SingletonKidneyCenter()
    {
    }

    public static SingletonKidneyCenter getInstance()
    {
        if (mInstance == null)
        {
            mInstance = new SingletonKidneyCenter();
        }
        return mInstance;
    }

    public static SingletonKidneyCenter getmInstance()
    {
        return mInstance;
    }

    public static void setmInstance(SingletonKidneyCenter mInstance)
    {
        SingletonKidneyCenter.mInstance = mInstance;
    }

    public String getPersonId()
    {
        return personId;
    }

    public void setPersonId(String personId)
    {
        this.personId = personId;
    }
}
