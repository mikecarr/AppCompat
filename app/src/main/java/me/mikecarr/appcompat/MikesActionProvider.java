package me.mikecarr.appcompat;

import android.content.Context;
import android.support.v4.view.ActionProvider;
import android.view.View;

/**
 * Created by mcarr on 11/11/14.
 */
public class MikesActionProvider extends ActionProvider {

    /**
     * Creates a new instance. ActionProvider classes should always implement a
     * constructor that takes a single Context parameter for inflating from menu XML.
     *
     * @param context Context for accessing resources.
     */
    public MikesActionProvider(Context context) {
        super(context);
    }

    @Override
    public View onCreateActionView() {
        return null;
    }
}
