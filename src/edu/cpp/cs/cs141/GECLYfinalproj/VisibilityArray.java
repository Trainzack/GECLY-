package edu.cpp.cs.cs141.GECLYfinalproj;

/**
 * This class creates a new visibility array for use with the engine and UI.
 *
 * @author Gavin Kremer
 */
public class VisibilityArray {

    private boolean[][] visibility;
    /**
     * This is the constructor for {@link VisibilityArray}
     * @param player player for reference.
     * @param direction direction player is looking.
     */
    VisibilityArray(Player player,byte direction,boolean isDebug){
        this.visibility = new boolean[9][9];
        for (int i =0;i<9;++i){
            for (int l =0;l<9;++l){
                if (i == player.getLocation().getX() && l == player.getLocation().getY()){
                    visibility[i][l] = true;
                    continue;
                }
                else if(i == 1 && (l ==1||l==4||l==7)){
                    visibility[i][l] = true;
                    continue;
                }
                else if(i == 4 && (l ==1||l==4||l==7)){
                    visibility[i][l] = true;
                    continue;
                }
                else if(i == 7 && (l ==1||l==4||l==7)) {
                    visibility[i][l] = true;
                    continue;
                }
                visibility[i][l] = isDebug;
            }
        }
        switch (direction){
            case 0:
                try{visibility[player.getLocation().getX()-1][player.getLocation().getY()] = true;} catch(IndexOutOfBoundsException ex){/*nothing here*/}
                try{visibility[player.getLocation().getX()-2][player.getLocation().getY()] = true;} catch(IndexOutOfBoundsException ex){/*nothing here*/}
                if(player.hasNightVision()){
                    try{visibility[player.getLocation().getX()-2][player.getLocation().getY()+1] = true;}catch(IndexOutOfBoundsException ex){/*nothing here*/}
                    try{visibility[player.getLocation().getX()-2][player.getLocation().getY()-1] = true;}catch(IndexOutOfBoundsException ex){/*nothing here*/}
                }
                break;
            case 1:
                try{visibility[player.getLocation().getX()][player.getLocation().getY()+1] = true;}catch(IndexOutOfBoundsException ex){/*nothing here*/}
                try{visibility[player.getLocation().getX()][player.getLocation().getY()+2] = true;}catch(IndexOutOfBoundsException ex){/*nothing here*/}
                if(player.hasNightVision()){
                    try{visibility[player.getLocation().getX()+1][player.getLocation().getY()+2] = true;}catch(IndexOutOfBoundsException ex){/*nothing here*/}
                    try{visibility[player.getLocation().getX()+-1][player.getLocation().getY()+2] = true;}catch(IndexOutOfBoundsException ex){/*nothing here*/}
                }
                break;
            case 2:
                try{visibility[player.getLocation().getX()+1][player.getLocation().getY()] = true;}catch(IndexOutOfBoundsException ex){/*nothing here*/}
                try{visibility[player.getLocation().getX()+2][player.getLocation().getY()] = true;}catch(IndexOutOfBoundsException ex){/*nothing here*/}
                if(player.hasNightVision()){
                    try{visibility[player.getLocation().getX()+2][player.getLocation().getY()+1] = true;}catch(IndexOutOfBoundsException ex){/*nothing here*/}
                    try{visibility[player.getLocation().getX()+2][player.getLocation().getY()-1] = true;}catch(IndexOutOfBoundsException ex){/*nothing here*/}
                }
                break;
            case 3:
                try{visibility[player.getLocation().getX()][player.getLocation().getY()-1] = true;}catch(IndexOutOfBoundsException ex){/*nothing here*/}
                try{visibility[player.getLocation().getX()][player.getLocation().getY()-2] = true;}catch(IndexOutOfBoundsException ex){/*nothing here*/}
                if(player.hasNightVision()){
                    try{visibility[player.getLocation().getX()+1][player.getLocation().getY()-2] = true;}catch(IndexOutOfBoundsException ex){/*nothing here*/}
                    try{visibility[player.getLocation().getX()-1][player.getLocation().getY()-2] = true;}catch(IndexOutOfBoundsException ex){/*nothing here*/}
                }
                break;
            default:
                break;
        }


    }
    public boolean[][] getVisibility(){
        return this.visibility;
    }
}
