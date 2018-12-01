package trofiv.io.a0x4000.model;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.SurfaceHolder;

import trofiv.io.a0x4000.R.color;
import trofiv.io.a0x4000.R.font;
import trofiv.io.a0x4000.R.string;
import trofiv.io.a0x4000.drawing.common.Label;
import trofiv.io.a0x4000.model.common.AbstractModel;

public class MenuModel extends AbstractModel {
    private final Label title;

    public MenuModel(final Context context) {
        this.title = new Label();
        final Paint style = title.getStyle();
        style.setColor(context.getResources()
                .getColor(color.titleColor, context.getTheme()));
        title.setText(context.getResources().getString(string.title));
        final Typeface titleFont = context.getResources().getFont(font.clear_sans_bold);
        style.setTypeface(titleFont);
    }

    @Override
    public void surfaceCreated(final SurfaceHolder holder) {
        super.surfaceCreated(holder);
        final int width = getWidth();
        final int height = getHeight();
        synchronized (title) {
            title.setTextSizeForWidth(width * 0.6f);//TODO to resources
            title.setLeft((int) (width * 0.2f));//TODO to resources
            title.setTop((int) (title.getHeight() + height * 0.2f)); //TODO to resource
        }
    }

    @Override
    public void surfaceChanged(
            final SurfaceHolder holder,
            final int format,
            final int width,
            final int height) {
        super.surfaceChanged(holder, format, width, height);
        synchronized (title) {
            title.setTextSizeForWidth(width * 0.6f);//TODO to resources
            title.setLeft((int) (width * 0.2f));//TODO to resources
            title.setTop((int) (title.getHeight() + height * 0.2f)); //TODO to resource
        }
    }

    @Override
    public void surfaceDestroyed(final SurfaceHolder holder) {
        super.surfaceDestroyed(holder);
    }

    public Label getTitle() {
        return title;
    }
}
