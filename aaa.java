

import java.util.ArrayList;

class Box{
    int height;
    int width;
    int depth;
    public Box(int height, int width, int depth){
        this.height=height;
        this.width=width;
        this.depth = depth;
    }
    public boolean canBeAbove(Box box){
        if(box==null)
            return true;
        if(height<box.height && width<box.width && depth<box.depth)
            return true;
        return false;
    }
    public void print(){
        System.out.println(height+" "+width+" "+depth);
    }
}

public class aaa {

    public static ArrayList<Box> maxBoxTower(Box[] boxes){
        return maxBoxTower(boxes, null);
    }
    private static ArrayList<Box> maxBoxTower(Box[] boxes, Box bottom){
        ArrayList<Box> maxTower = new ArrayList<Box>();
        int maxHeight = 0;
        //尝试每一个箱子
        for(int i=0; i<boxes.length; i++){
            //找到可以放在bottom上的箱子
            if(boxes[i].canBeAbove(bottom)){
                //以找到的箱子为底求解子问题（注意，这里的子问题会被重复求解，提高效率的办法是动态规划）
                ArrayList<Box> newTower = maxBoxTower(boxes, boxes[i]);
                //利用子问题的解构造当前问题的解
                int newHeight = calTowerHeight(newTower);
                if(newHeight>maxHeight){
                    maxHeight = newHeight;
                    maxTower = newTower;//以boxes[i]为底的最高塔
                }
            }
        }
        if(bottom != null){
            maxTower.add(0, bottom);
        }
        return maxTower;
    }
    private static int calTowerHeight(ArrayList<Box> tower){
        int height=0;
        for(Box box : tower){
            height += box.height;
        }
        return height;
    }



    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Box[] boxes = new Box[3];
        boxes[0] = new Box(4,5,6);
        boxes[1] = new Box(3,1,6);
        boxes[2] = new Box(3,2,1);
        ArrayList<Box> result = maxBoxTower(boxes);
        for(Box item : result){
            item.print();
        }
    }
}