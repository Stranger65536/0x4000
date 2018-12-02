package trofiv.io.a0x4000.model;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.SurfaceHolder;

import trofiv.io.a0x4000.R.color;
import trofiv.io.a0x4000.R.drawable;
import trofiv.io.a0x4000.R.font;
import trofiv.io.a0x4000.R.string;
import trofiv.io.a0x4000.drawing.common.Button;
import trofiv.io.a0x4000.drawing.common.Icon;
import trofiv.io.a0x4000.drawing.common.Label;
import trofiv.io.a0x4000.model.common.AbstractModel;

public class MenuModel extends AbstractModel {
    private final Label title;
    private final Button classicModeButton;
    private final Drawable classicButtonDrawable;

    public MenuModel(final Context context) {
        classicButtonDrawable = context.getResources().getDrawable(
                drawable.classic_mode_icon_240dp, context.getTheme());
        title = initTitle(context);
        classicModeButton = initClassicModeButton(context);
    }

    private static Label initTitle(final Context context) {
        final Label titleElem = new Label();
        final Paint style = titleElem.getStyle();
        style.setColor(context.getResources()
                .getColor(color.titleColor, context.getTheme()));
        titleElem.setText(context.getResources().getString(string.title));
        final Typeface titleFont = context.getResources().getFont(font.clear_sans_bold);
        style.setTypeface(titleFont);
        return titleElem;
    }

    private Button initClassicModeButton(final Context context) {
        final Button button = new Button();
        final Paint backgroundStyle = button.getBackgroundStyle();
        backgroundStyle.setColor(context.getResources()
                .getColor(color.gameButtonBackgroundColor, context.getTheme()));
        final Icon icon = button.getIcon();
        icon.setDrawable(classicButtonDrawable);
        final Label label = button.getLabel();
        label.setText(context.getResources().getText(string.classicModeButtonText).toString());
        final Typeface titleFont = context.getResources().getFont(font.clear_sans_bold);
        label.getStyle().setTypeface(titleFont);
        label.getStyle().setColor(context.getResources()
                .getColor(color.gameButtonTextColor, context.getTheme()));
        return button;
    }

    @Override
    public void surfaceCreated(final SurfaceHolder holder) {
        super.surfaceCreated(holder);
        final int width = getWidth();
        final int height = getHeight();
        alignTitle(width, height);
        alignClassicModeButton(width);
    }

    @Override
    public void surfaceChanged(
            final SurfaceHolder holder,
            final int format,
            final int width,
            final int height) {
        super.surfaceChanged(holder, format, width, height);
        alignTitle(width, height);
        alignClassicModeButton(width);
    }

    @Override
    public void surfaceDestroyed(final SurfaceHolder holder) {
        super.surfaceDestroyed(holder);
    }

    private void alignClassicModeButton(final int width) {
        synchronized (classicModeButton) {
            classicModeButton.setLeft((int) (width * 0.15f));//TODO to resources
            classicModeButton.setWidth((int) (width * 0.7f));//TODO to resources
            classicModeButton.setTop((int) (width * 0.55f));//TODO to resources
            classicModeButton.setHeight((int) (width * 0.15f));//TODO to resources
            classicModeButton.setRx(10);//TODO depends on size, to resources
            classicModeButton.setRy(10);//TODO depends on size, to resources
            final Icon icon = classicModeButton.getIcon();
            //noinspection SynchronizationOnLocalVariableOrMethodParameter,NestedSynchronizedStatement
            synchronized (icon) {
                icon.setHeight((int) (classicModeButton.height() * 0.5)); //TODO to resources
                icon.setTop((int) (classicModeButton.top()
                        + classicModeButton.height() * 0.25)); //TODO to resources
                icon.setLeft((int) (classicModeButton.left()
                        + classicModeButton.height() * 0.25));//TODO to resources
                icon.setWidth(icon.height());
            }
            final Label label = classicModeButton.getLabel();
            //noinspection NestedSynchronizedStatement,SynchronizationOnLocalVariableOrMethodParameter
            synchronized (label) {
                label.setTextSizeForHeight(classicModeButton.height() * 0.3f);//TODO to resources
                label.setLeft((int) (classicModeButton.left()
                        + classicModeButton.width() / 2.0f - label.width() / 2.0f));//TODO to resources
                label.setTop((int) (classicModeButton.bottom()
                        - classicModeButton.height() * 0.35f));//TODO to resources
            }
        }
    }

    private void alignTitle(final int width, final int height) {
        synchronized (title) {
            title.setTextSizeForWidth(width * 0.6f);//TODO to resources
            title.setLeft((int) (width * 0.2f));//TODO to resources
            title.setTop((int) (title.getHeight() + height * 0.2f)); //TODO to resource
        }
    }

    public Label getTitle() {
        return title;
    }

    public Button getClassicModeButton() {
        return classicModeButton;
    }
}
