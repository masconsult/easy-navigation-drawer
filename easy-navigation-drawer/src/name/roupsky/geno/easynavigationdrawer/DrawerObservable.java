
package name.roupsky.geno.easynavigationdrawer;

import android.database.Observable;
import android.support.v4.widget.DrawerLayout.DrawerListener;
import android.view.View;

public class DrawerObservable extends Observable<DrawerListener> {
    /**
     * Called when a drawer's position changes.
     * 
     * @param drawerView The child view that was moved
     * @param slideOffset The new offset of this drawer within its range, from 0-1
     */
    public void onDrawerSlide(View drawerView, float slideOffset) {
        synchronized (mObservers) {
            // since onChanged() is implemented by the app, it could do anything, including
            // removing itself from {@link mObservers} - and that could cause problems if
            // an iterator is used on the ArrayList {@link mObservers}.
            // to avoid such problems, just march thru the list in the reverse order.
            for (int i = mObservers.size() - 1; i >= 0; i--) {
                mObservers.get(i).onDrawerSlide(drawerView, slideOffset);
            }
        }
    }

    /**
     * Called when a drawer has settled in a completely open state. The drawer is interactive at this point.
     * 
     * @param drawerView Drawer view that is now open
     */
    public void onDrawerOpened(View drawerView) {
        synchronized (mObservers) {
            // since onChanged() is implemented by the app, it could do anything, including
            // removing itself from {@link mObservers} - and that could cause problems if
            // an iterator is used on the ArrayList {@link mObservers}.
            // to avoid such problems, just march thru the list in the reverse order.
            for (int i = mObservers.size() - 1; i >= 0; i--) {
                mObservers.get(i).onDrawerOpened(drawerView);
            }
        }
    }

    /**
     * Called when a drawer has settled in a completely closed state.
     * 
     * @param drawerView Drawer view that is now closed
     */
    public void onDrawerClosed(View drawerView) {
        synchronized (mObservers) {
            // since onChanged() is implemented by the app, it could do anything, including
            // removing itself from {@link mObservers} - and that could cause problems if
            // an iterator is used on the ArrayList {@link mObservers}.
            // to avoid such problems, just march thru the list in the reverse order.
            for (int i = mObservers.size() - 1; i >= 0; i--) {
                mObservers.get(i).onDrawerClosed(drawerView);
            }
        }
    }

    /**
     * Called when the drawer motion state changes. The new state will be one of {@link #STATE_IDLE},
     * {@link #STATE_DRAGGING} or {@link #STATE_SETTLING}.
     * 
     * @param newState The new drawer motion state
     */
    public void onDrawerStateChanged(int newState) {
        synchronized (mObservers) {
            // since onChanged() is implemented by the app, it could do anything, including
            // removing itself from {@link mObservers} - and that could cause problems if
            // an iterator is used on the ArrayList {@link mObservers}.
            // to avoid such problems, just march thru the list in the reverse order.
            for (int i = mObservers.size() - 1; i >= 0; i--) {
                mObservers.get(i).onDrawerStateChanged(newState);
            }
        }
    }
}
