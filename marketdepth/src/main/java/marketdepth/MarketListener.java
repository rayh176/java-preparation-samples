package marketdepth;

import java.util.EventListener;

/**
 * For each market depth we have an instrument associated with a price,
 */
public interface MarketListener<E> extends EventListener{
    void onUpdate(E e);
}
