package trofiv.io.a0x4000.drawing;

import android.content.Context;
import android.graphics.Canvas;

import trofiv.io.a0x4000.drawing.common.Drawable;
import trofiv.io.a0x4000.model.GameModel;

public class Game implements Drawable {
    private final Context context;

    Game(final Context context, final GameModel gameModel) {
        this.context = context;
    }

    @Override
    public void draw(final Canvas canvas) {

    }
}
