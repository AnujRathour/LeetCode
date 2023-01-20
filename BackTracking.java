package com.rathour;

import java.util.ArrayList;

public class BackTracking {
    public static void main(String[] args) {
        System.out.println(count(3,3));
        ArrayList<String> ans=movesRet("",3,3);
        System.out.println(ans);
        ArrayList<String> res=movesRetWithDiagonal("",3,3);
        System.out.println(res);
        boolean[][] board={
                {true,true,true},
                {true,false,true},
                {true,true,true},
        };
        movesRetWithObstacles("",board,0,0);
    }
    static int count (int r,int c){
        if(r==1||c==1){
            return 1;
        }
        int left =count(r-1,c);
        int right=count(r,c-1);
        return left+ right;
    }
    static ArrayList<String> movesRet(String p,int r,int c){
        if(r==1&&c==1){
            ArrayList<String>list=new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String>ans=new ArrayList<>();
        if(r>1){
            ans.addAll(movesRet("D"+p,r-1,c));
        }
        if(c>1){
            ans.addAll(movesRet("R"+p,r,c-1));
        }
        return ans;
    }
    static ArrayList<String> movesRetWithDiagonal(String p,int r,int c){
        if(r==1&&c==1){
            ArrayList<String>list=new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String>ans=new ArrayList<>();
        if(r>1&&c>1){
            ans.addAll(movesRetWithDiagonal("D"+p,r-1,c-1));
        }
        if(r>1){
            ans.addAll(movesRetWithDiagonal("V"+p,r-1,c));
        }

        if(c>1){
            ans.addAll(movesRetWithDiagonal("H"+p,r,c-1));
        }
        return ans;
    }

    static void movesRetWithObstacles(String p,boolean[][] maze,int r,int c){
        if(r== maze.length-1&&c== maze[0].length-1){
            System.out.println(p);
            return;
        }
        if(!maze[r][c]){
            return ;
        }

        if(r< maze.length-1){
            movesRetWithObstacles("D"+p,maze,r+1,c);
        }
        if(c<maze[0].length-1){
            movesRetWithObstacles("R"+p,maze,r,c+1);
        }

    }
}
