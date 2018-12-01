package trofiv.io.a0x4000.drawing;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;

import trofiv.io.a0x4000.R.color;
import trofiv.io.a0x4000.drawing.common.Drawable;
import trofiv.io.a0x4000.drawing.common.Label;
import trofiv.io.a0x4000.model.MenuModel;

public class Menu implements Drawable {
    private final Context context;
    private final Paint backgroundPaint;
    private final Label title;

    Menu(final Context context, final MenuModel menuModel) {
        this.context = context;
        final Theme theme = context.getTheme();
        final int backgroundColor = context.getResources().getColor(color.background, theme);
        this.backgroundPaint = new Paint();
        backgroundPaint.setColor(backgroundColor);
        backgroundPaint.setStyle(Style.FILL);
        this.title = menuModel.getTitle();
    }

    @Override
    public void draw(final Canvas canvas) {
        drawBackground(canvas);
        title.draw(canvas);
    }

    private void drawBackground(final Canvas canvas) {
        canvas.drawPaint(backgroundPaint);
    }
}
