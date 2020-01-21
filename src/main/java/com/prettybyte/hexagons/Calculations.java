package com.prettybyte.hexagons;

import com.prettybyte.hexagons.Hexagon;
import com.prettybyte.hexagons.HexagonMap;
import com.prettybyte.hexagons.IPathInfoSupplier;
import com.prettybyte.hexagons.NoHexagonFoundException;
import com.prettybyte.hexagons.NoPathFoundException;

import java.util.ArrayList;
import java.util.Collections;

class Calculations {
    static ArrayList<com.prettybyte.hexagons.Hexagon> getPathBetween(com.prettybyte.hexagons.Hexagon start, com.prettybyte.hexagons.Hexagon destination, IPathInfoSupplier pathInfoSupplier) throws com.prettybyte.hexagons.NoPathFoundException {
        ArrayList<com.prettybyte.hexagons.Hexagon> closedSet = new ArrayList<>();    // The set of nodes already evaluated
        ArrayList<com.prettybyte.hexagons.Hexagon> openSet = new ArrayList<>();   // The set of tentative nodes to be evaluated, initially containing the start node
        openSet.add(start);
        start.aStarGscore = 0;
        start.aStarFscore = start.aStarGscore + com.prettybyte.hexagons.GridPosition.getDistance(start.position, destination.position);

        com.prettybyte.hexagons.Hexagon currentHexagon;
        int tentative_g_score;
        while (openSet.size() > 0) {
            currentHexagon = findHexagonWithLowestFscore(openSet);
            if (currentHexagon.position.equals(destination.position)) {
                return reconstruct_path(start, destination);
            }
            openSet.remove(currentHexagon);
            closedSet.add(currentHexagon);

            for (com.prettybyte.hexagons.Hexagon neighbour : currentHexagon.getNeighbours()) {
                if ((!pathInfoSupplier.isBlockingPath(neighbour)) || neighbour.equals(destination)) {
                    if (!closedSet.contains(neighbour)) {
                        tentative_g_score = currentHexagon.aStarGscore + pathInfoSupplier.getMovementCost(currentHexagon, neighbour);

                        if (!openSet.contains(neighbour) || tentative_g_score < neighbour.aStarGscore) {
                            neighbour.aStarCameFrom = currentHexagon;
                            neighbour.aStarGscore = tentative_g_score;
                            neighbour.aStarFscore = neighbour.aStarGscore + com.prettybyte.hexagons.GridPosition.getDistance(neighbour.position, destination.position);

                            /*
                            TODO: Vill få den att generera path som är mer som getLine() så att de inte rör sig kantigt på kartan. Nedanstående funkar sådär:
                            neighbour.aStarFscore = neighbour.aStarGscore + neighbour.getGraphicsDistanceTo(destination);

                            Ett sätt kunde vara att undersöka om man kan identifiera hex där path går runt ett hörn (har de unika g-värden?), dvs en ruta som definitivt ska besökas och sedan mäta det grafiska avståndet till dem som f-värde.
                             */
                            if (!openSet.contains(neighbour)) {
                                openSet.add(neighbour);
                            }
                        }
                    }
                }
            }
        }
        throw new NoPathFoundException("Can't find any path to the goal Hexagon");
    }

    private static com.prettybyte.hexagons.Hexagon findHexagonWithLowestFscore(ArrayList<com.prettybyte.hexagons.Hexagon> openSet) {
        com.prettybyte.hexagons.Hexagon hexagonWithLowestFscore = openSet.get(0);          // Just pick anyone and then see if we can find any better
        int lowestFscore = hexagonWithLowestFscore.aStarFscore;
        for (com.prettybyte.hexagons.Hexagon h : openSet) {
            if (h.aStarFscore < lowestFscore) {
                hexagonWithLowestFscore = h;
                lowestFscore = h.aStarFscore;
            }
        }
        return hexagonWithLowestFscore;
    }

    private static ArrayList<com.prettybyte.hexagons.Hexagon> reconstruct_path(com.prettybyte.hexagons.Hexagon start, com.prettybyte.hexagons.Hexagon goal) {
        ArrayList<com.prettybyte.hexagons.Hexagon> path = new ArrayList<>();
        com.prettybyte.hexagons.Hexagon currentHexagon = goal;
        while (currentHexagon != start) {
            path.add(currentHexagon);
            currentHexagon = currentHexagon.aStarCameFrom;
        }
        Collections.reverse(path);
        return path;
    }

    static ArrayList<com.prettybyte.hexagons.Hexagon> getLine(com.prettybyte.hexagons.GridPosition origin, com.prettybyte.hexagons.GridPosition destination, com.prettybyte.hexagons.HexagonMap map) {
        com.prettybyte.hexagons.Hexagon h;
        ArrayList<com.prettybyte.hexagons.Hexagon> result = new ArrayList<>();
        ArrayList<com.prettybyte.hexagons.GridPosition> positions = origin.line(destination);

        for (com.prettybyte.hexagons.GridPosition position : positions) {
            try {
                h = map.getHexagon(position);
                result.add(h);
            } catch (com.prettybyte.hexagons.NoHexagonFoundException ex) {
            }
        }
        return result;
    }

    static ArrayList<com.prettybyte.hexagons.Hexagon> getVisibleHexes(com.prettybyte.hexagons.Hexagon origin, int visibleRange, com.prettybyte.hexagons.HexagonMap map) {
        ArrayList<com.prettybyte.hexagons.GridPosition> ringMembers = origin.position.getPositionsOnCircleEdge(visibleRange);
        ArrayList<com.prettybyte.hexagons.Hexagon> result = new ArrayList<>();
        ArrayList<com.prettybyte.hexagons.Hexagon> line;
        for (com.prettybyte.hexagons.GridPosition ringMemberPosition : ringMembers) {
            line = getLine(origin.position, ringMemberPosition, map);
            for (com.prettybyte.hexagons.Hexagon hexagonInLine : line) {
                result.add(hexagonInLine);
                if (hexagonInLine.isVisualObstacle()) {
                    break;
                }
            }
        }
        return result;
    }

    static ArrayList<com.prettybyte.hexagons.Hexagon> getHexagonsOnRingEdge(com.prettybyte.hexagons.Hexagon center, int radius, com.prettybyte.hexagons.HexagonMap map) {
        ArrayList<com.prettybyte.hexagons.Hexagon> result = new ArrayList<>();
        for (com.prettybyte.hexagons.GridPosition position : center.position.getPositionsOnCircleEdge(radius)) {
            try {
                com.prettybyte.hexagons.Hexagon hexagon = map.getHexagon(position);
                result.add(hexagon);
            } catch (com.prettybyte.hexagons.NoHexagonFoundException e) {
            }
        }
        return result;
    }

    static ArrayList<com.prettybyte.hexagons.Hexagon> getHexagonsInRingArea(com.prettybyte.hexagons.Hexagon center, int radius, HexagonMap map) {
        ArrayList<com.prettybyte.hexagons.Hexagon> result = new ArrayList<>();
        for (com.prettybyte.hexagons.GridPosition position : center.position.getPositionsInCircleArea(radius)) {
            try {
                Hexagon hexagon = map.getHexagon(position);
                result.add(hexagon);
            } catch (NoHexagonFoundException e) {
            }
        }
        return result;
    }
}
