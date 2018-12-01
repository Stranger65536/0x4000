package trofiv.io.a0x4000.drawing;

import android.content.Context;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;

import trofiv.io.a0x4000.DrawingRunnable;
import trofiv.io.a0x4000.model.ActiveViews;
import trofiv.io.a0x4000.model.GameModel;
import trofiv.io.a0x4000.model.MenuModel;
import trofiv.io.a0x4000.utils.Logger;

import static trofiv.io.a0x4000.utils.Logger.LoggerDepth;

public final class GameView extends SurfaceView implements Callback {
    private final MenuModel menuModel;
    private final GameModel gameModel;
    private final Game game;
    private final Menu menu;
    private Thread gameThread;
    private ActiveViews activeView;

    public GameView(final Context context) {
        super(context);
        //noinspection ThisEscapedInObjectConstruction
        getHolder().addCallback(this);
        setFocusable(true);
        this.activeView = ActiveViews.MENU;
        this.menuModel = new MenuModel(context);
        this.gameModel = new GameModel();
        this.menu = new Menu(context, menuModel);
        this.game = new Game(context, gameModel);
    }

//    public static Bitmap drawableToBitmap(final Drawable drawable) {
//        if (drawable instanceof BitmapDrawable) {
//            return ((BitmapDrawable) drawable).getBitmap();
//        }
//
//        final Bitmap bitmap = Bitmap.createBitmap(
//                drawable.getIntrinsicWidth(),
//                drawable.getIntrinsicHeight(),
//                Config.ARGB_8888);
//        final Canvas canvas = new Canvas(bitmap);
//        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
//        drawable.draw(canvas);
//
//        return bitmap;
//    }

    @Override
    public void surfaceCreated(final SurfaceHolder holder) {
        final Runnable gameRunnable = new DrawingRunnable(getHolder(), this);
        this.gameThread = new Thread(gameRunnable);
        this.menuModel.surfaceCreated(getHolder());
        this.gameModel.surfaceCreated(getHolder());
        gameThread.start();
    }

    @Override
    public void surfaceChanged(
            final SurfaceHolder holder,
            final int format,
            final int width,
            final int height) {
        this.menuModel.surfaceChanged(holder, format, width, height);
        this.gameModel.surfaceChanged(holder, format, width, height);
    }

    @Override
    public void surfaceDestroyed(final SurfaceHolder holder) {
        gameThread.interrupt();
        try {
            gameThread.join();
            this.menuModel.surfaceDestroyed(holder);
            this.gameModel.surfaceDestroyed(holder);
        } catch (InterruptedException e) {
            Logger.e("Interruption issue!", e, LoggerDepth.ACTUAL_METHOD);
        }
    }

    @Override
    public void draw(final Canvas canvas) {
        super.draw(canvas);
        if (canvas != null) {
            switch (activeView) {
                case MENU:
                    menu.draw(canvas);
                    break;
                case GAME:
                    game.draw(canvas);
                    break;
                default:
                    throw new IllegalStateException(
                            "Unregistered view is about to be rendered: " + activeView + '!');
            }
        }
    }
}
