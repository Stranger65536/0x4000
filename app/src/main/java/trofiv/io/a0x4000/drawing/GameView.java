package trofiv.io.a0x4000.drawing;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
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
    private final ActiveViews activeView;
    private Thread gameThread;

    @SuppressLint("ClickableViewAccessibility")
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
        final GestureDetector gesture = new GestureDetector(context,
                new CustomSimpleOnGestureListener());
        this.setOnTouchListener((v, event) -> {
            if (event.getAction() == MotionEvent.ACTION_UP) {
                return menuModel.getOnGestureListener().onSingleTapUp(event);
            }
            return gesture.onTouchEvent(event);
        });
    }

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

    private class CustomSimpleOnGestureListener extends SimpleOnGestureListener {
        @Override
        public boolean onSingleTapUp(final MotionEvent e) {
            Logger.i(e.toString());
            switch (activeView) {
                case MENU:
                    return menuModel.getOnGestureListener().onSingleTapUp(e);
                case GAME:
                    break;
                default:
                    throw new IllegalStateException(
                            "Unregistered view is about to be rendered: " + activeView + '!');
            }
            return super.onSingleTapUp(e);
        }

        @Override
        public boolean onFling(
                final MotionEvent e1,
                final MotionEvent e2,
                final float velocityX,
                final float velocityY) {
            Logger.i("Fling " + e1);
            Logger.i("Fling " + e2);
            switch (activeView) {
                case MENU:
                    return menuModel.getOnGestureListener().onFling(e1, e2, velocityX, velocityY);
                case GAME:
                    break;
                default:
                    throw new IllegalStateException(
                            "Unregistered view is about to be rendered: " + activeView + '!');
            }
            return true;
        }

        @Override
        public boolean onDown(final MotionEvent e) {
            Logger.i(e.toString());
            switch (activeView) {
                case MENU:
                    return menuModel.getOnGestureListener().onDown(e);
                case GAME:
                    break;
                default:
                    throw new IllegalStateException(
                            "Unregistered view is about to be rendered: " + activeView + '!');
            }
            return true;
        }

        @Override
        public boolean onSingleTapConfirmed(final MotionEvent e) {
            Logger.i(e.toString());
            switch (activeView) {
                case MENU:
                    return menuModel.getOnGestureListener().onSingleTapConfirmed(e);
                case GAME:
                    break;
                default:
                    throw new IllegalStateException(
                            "Unregistered view is about to be rendered: " + activeView + '!');
            }
            return super.onSingleTapConfirmed(e);
        }
    }
}
