package com.prettybyte.hexagons;

import com.prettybyte.hexagons.Hexagon;

public interface IPathInfoSupplier {
    boolean isBlockingPath(Hexagon hexagon);

    int getMovementCost(Hexagon from, Hexagon to);
}
